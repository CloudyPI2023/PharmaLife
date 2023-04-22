package tn.esprit.Services;

import org.springframework.security.core.userdetails.UserDetails;
import tn.esprit.Entities.Role;
import tn.esprit.Entities.User;

import java.util.List;

public interface IUserService {


    User findByEmail(String email);

    User findById(Integer id);

    List<User> getUsers();

    User addUser(User u);

    void deleteUserById(Integer id);

    void updateUser(User user);

    List<User> findByFirstNameContains(String firstName);

    List<User> getRole(Role role);

    List<Object[]> countTotalUsersByRole();

    UserDetails loadUserByUsername(String email);

    String signUpUser(User u);

    int enableUser(String email);

    User findByToken(String t) ;

    }
