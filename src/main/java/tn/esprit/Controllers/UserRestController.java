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
@RequestMapping("/user")
@AllArgsConstructor
public class UserRestController {

    IUserService userService;


      // http://localhost:8082/PharmaLife/user/addUser
     @PostMapping("/addUser")
     public User addUser(@RequestBody User u) {
       User user = userService.addUser(u);
       return user;
     }


  // http://localhost:8082/PharmaLife/user/AllUsers
  @GetMapping("/AllUsers")
    @ResponseBody
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }


  // http://localhost:8082/PharmaLife/user/findUserByEmail/{email}
  @GetMapping("/findUserByEmail/{email}")
    @ResponseBody
    public User findByEmail(@PathVariable("email") String email){
        return userService.findByEmail(email);
    }


  // http://localhost:8082/PharmaLife/user/getUserById/{id}
  @GetMapping("/getUserById/{id}")
  @ResponseBody
  public User findById(@PathVariable("id") Integer id){
    return userService.findById(id);
  }


  // http://localhost:8082/PharmaLife/user/deleteUser/{id}
  @DeleteMapping("/deleteUser/{id}")
  @ResponseBody
  public void deleteUserById(@PathVariable("id") Integer id){
    userService.deleteUserById(id);
  }


  // http://localhost:8082/PharmaLife/user/updateUser
    @PutMapping("/updateUser")
    @ResponseBody
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

  // http://localhost:8082/PharmaLife/user/findByFirstNameContains/{firstName}
  @GetMapping("/findByFirstNameContains/{firstName}")
    @ResponseBody
    public List<User> findByFirstNameContains(@PathVariable("firstName") String firstName){
        return userService.findByFirstNameContains(firstName);
    }


  // http://localhost:8082/PharmaLife/user/findByRole/{role}
  @GetMapping("/findByRole/{role}")
    @ResponseBody
    public List<User> getRole(@PathVariable("role") Role role){
        return userService.getRole(role);
    }


  // http://localhost:8082/PharmaLife/user/countRole
  @GetMapping("/countRole")
    @ResponseBody
    public List<Object[]> countTotalUsersByRole(){
          return userService.countTotalUsersByRole();
    }

}
