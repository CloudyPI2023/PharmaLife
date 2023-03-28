package tn.esprit.Registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.User;
import tn.esprit.Services.UserService;

import javax.validation.constraints.Email;

@RestController
@RequestMapping(path="api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private  final UserService userService;
    private RegistrationService registrationService;
    private EmailValidator emailValidator;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        boolean isValidEmail =  emailValidator.test(request.getEmail());
        if(!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        return userService.signUpUser(
                new User(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPhoneNumber(),
                        request.getBirthDate(),
                        request.getAddress(),
                        request.getCity(),
                        request.getPassword(),
                        request.getRole(),
                        request.getGender()
                )
        );

    }


    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
