package tn.esprit.RegistrationAuth.Login;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.User;
import tn.esprit.Repositories.UserRepository;
import tn.esprit.SMS.TwilioConfiguration;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping(path="/auth")
@AllArgsConstructor
@CrossOrigin("*")
public class LoginController {

    private final UserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;



    @PostMapping
    public ResponseEntity<?> authenticateUser(@RequestBody LoginForm loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElse(null);

        try {
            // find user by email
            if (user == null) {
                // user not found
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email/password");
            }

            if (!user.isEnabled()) {
                // user not enabled
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Your account is not enabled. Please verify your account.");
            }

            if (user.isAccountNonLocked()) {
                // perform authentication
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

                // authentication successful
                if(user.getLoginAttempts()<3) {
                    userRepository.resetLoginAttempts(0,user.getEmail());
                }
                return ResponseEntity.ok("Login successful");
            } else {
                // user account is locked
                if (user.getLockTime() != null && user.getLockTime().plusMinutes(5).isBefore(LocalDateTime.now())) {
                    // lock time is more than 24 hours ago, unlock the account
                    userRepository.unlockUser(user.getEmail());
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Your account was locked, but is now unlocked. Please try logging in again.");
                } else {
                    // lock time is less than 24 hours ago, return a forbidden status
                    long remainingTime = ChronoUnit.MINUTES.between(LocalDateTime.now(), user.getLockTime().plusMinutes(5));
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Your account is locked for " + remainingTime + " minutes. Please try again later.");
                }
            }
        } catch (AuthenticationException e) {
            // authentication failed
            if (user != null || passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                if (!user.isEnabled()) {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Please verify your account before logging in.");
                } else if (!user.isAccountNonLocked()) {
                    long remainingTime = ChronoUnit.MINUTES.between(LocalDateTime.now(), user.getLockTime().plusMinutes(5));
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Your account has been locked for " + remainingTime + " minutes. Please try again later.");
                } else {
                    int attempts = user.getLoginAttempts() + 1;
                    userRepository.updateLoginAttempts(attempts, loginRequest.getEmail());
                    if (attempts >= 3) {
                        userRepository.lockUser(LocalDateTime.now(), user.getEmail());
                        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Your account has been locked for 24 hours. Please contact support for assistance.");
                    }
                }
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email/password");
        }
    }

}
