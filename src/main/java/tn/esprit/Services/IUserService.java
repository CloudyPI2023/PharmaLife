package tn.esprit.Services;

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

}
