package tn.esprit.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Role;
import tn.esprit.Entities.User;
import tn.esprit.Repositories.UserRepository;
import tn.esprit.Services.IUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@Tag(name = "User management")
@RequestMapping("/User")
@AllArgsConstructor
@CrossOrigin("*")
public class UserRestController {

    IUserService userService;


     @PostMapping("/add-User")
     public User addUser(@RequestBody User u) {
       User user = userService.addUser(u);
       return user;
     }


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

}
