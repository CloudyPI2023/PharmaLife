package tn.esprit.RegistrationAuth.Registration;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.RegistrationAuth.MessageResponse;
import tn.esprit.Repositories.UserRepository;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/forgetPassword/{email}")
    public Map<String, String> forgetpassword(@PathVariable("email") String email) {
        Map<String, String> temp = new HashMap<String, String>();
        temp.put("token", registrationService.forgetpassword(email));
        return temp;
    }
    @GetMapping("/reset/{token}/{email}/{password}")
    public Map<String, String> reset(@PathVariable("token") String token,@PathVariable("email") String email,@PathVariable("password") String password) {
        Map<String, String> temp = new HashMap<String, String>();
        temp.put("token", registrationService.resetPassword(token,email,password));
        return temp;

    }

}
