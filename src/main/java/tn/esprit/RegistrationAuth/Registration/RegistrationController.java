package tn.esprit.RegistrationAuth.Registration;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.RegistrationAuth.MessageResponse;
import tn.esprit.Repositories.UserRepository;

@RestController
@RequestMapping(path="/registration")
@AllArgsConstructor
@CrossOrigin("*")
public class RegistrationController {

    private RegistrationService registrationService;
    private final UserRepository userRepository;



    @PostMapping
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        registrationService.register(request);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }



    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }



}
