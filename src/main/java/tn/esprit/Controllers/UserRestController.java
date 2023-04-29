package tn.esprit.Controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.Entities.Role;
import tn.esprit.Entities.User;
import tn.esprit.Image.ImageUpload;
import tn.esprit.Repositories.UserRepository;
import tn.esprit.Services.IUserService;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.annotation.security.RolesAllowed;
import javax.xml.ws.Response;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Tag(name = "User management")
@RequestMapping("/User")
@AllArgsConstructor
@CrossOrigin("*")
public class UserRestController {

    IUserService userService;

     @PostMapping(value = "/add-User")
     public User addUser(@RequestBody   User u){
         User user = userService.addUser(u);
       return user;
     }
   /*  @PostMapping("/add-User")
    public User addUser(@RequestBody  User u, @RequestPart("file") MultipartFile file) throws IOException {
        // Save the file to a temporary location
        File tempFile = File.createTempFile("temp", null);
        file.transferTo(tempFile);

        // Set the imageUser attribute of the user object
        u.setImageUser(tempFile.getAbsolutePath());


        User user = userService.addUser(u);

        return user;
    }*/





  @GetMapping("/all-Users")
    @ResponseBody
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }


  @GetMapping("/retrieve-UserByEmail/{emailUser}")
    @ResponseBody
    public User findByEmail(@PathVariable("emailUser") String emailUser){
        return userService.findByEmail(emailUser);
    }


  @GetMapping("/retrieve-User/{idUser}")
  @ResponseBody
  public User findById(@PathVariable("idUser") Integer idUser){
    return userService.findById(idUser);
  }


  @DeleteMapping("/delete-User/{idUser}")
  @ResponseBody
  public void deleteUserById(@PathVariable("idUser") Integer idUser){
    userService.deleteUserById(idUser);
  }


    @PutMapping("/update-User")

    @ResponseBody
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

  @GetMapping("/find-ByFirstNameContains/{firstName}")
    @ResponseBody
    public List<User> findByFirstNameContains(@PathVariable("firstName") String firstName){
        return userService.findByFirstNameContains(firstName);
    }


  @GetMapping("/find-ByRole/{role}")
    @ResponseBody
    public List<User> getRole(@PathVariable("role") Role role){
        return userService.getRole(role);
    }


  @GetMapping("/countRole")
    @ResponseBody
    public List<Object[]> countTotalUsersByRole(){
          return userService.countTotalUsersByRole();
    }

    @GetMapping("/role-statistics")
    public ResponseEntity<Map<String, Double>> getRoleStatistics() {
        Map<String, Double> roleStatistics = userService.getRoleStatistics();
        return ResponseEntity.ok().body(roleStatistics);
    }

    @GetMapping("/gender-statistics")
    public ResponseEntity<Map<String, Double>> getGenderStatistics() {
        Map<String, Double> genderStatistics = userService.getGenderStatistics();
        return ResponseEntity.ok().body(genderStatistics);
    }

    @GetMapping("/activationStatus-statistics")
    public ResponseEntity<Map<String, Double>> getActivationStatusStatistics() {
        Map<String, Double> actStatistics = userService.getActivationStatusStatistics();
        return ResponseEntity.ok().body(actStatistics);
    }



    @GetMapping("/roles")
    public List<String> getRoles() {
        return Arrays.stream(Role.values())
                .map(Role::toString)
                .collect(Collectors.toList());
    }
}
