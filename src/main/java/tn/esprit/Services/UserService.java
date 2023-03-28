package tn.esprit.Services;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Role;
import tn.esprit.Entities.User;
import tn.esprit.Registration.Token.ConfirmationToken;
import tn.esprit.Registration.Token.ConfirmationTokenService;
import tn.esprit.Repositories.UserRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserService implements IUserService, UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
     @Autowired
    private final UserRepository userRepository;


    @Override
    public User addUser(User u) {
        userRepository.save(u);
        return u;
    }

    @Override
    public List<User> getUsers() {
        // return userRepository.findAll(Sort.by(Sort.Direction.DESC, "firstName"));
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }


  /*  @Override
    public void deleteUserByEmail(String email) {
        User u = userRepository.findByEmail(email).orElse(null);
        userRepository.delete(u);
    }*/

    @Override
    public void deleteUserById(Integer id) {
        User u = userRepository.findByIdUser(id).orElse(null);
        userRepository.delete(u);

    }


    @Override
    public void updateUser(User user) {
        userRepository.save(user);

    }

    @Override
    public List<User> findByFirstNameContains(String firstName) {
        return userRepository.findByFirstNameContains(firstName);
    }

    @Override
    public List<User> getRole(Role role) {
        return userRepository.getRole(role);
    }

    @Override
    public List<Object[]> countTotalUsersByRole() {
        return userRepository.countTotalUsersByRole();
    }


    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(User u){
        boolean userExists = userRepository
                .findByEmail(u.getEmail())
                .isPresent();

        if(userExists){
            throw new IllegalStateException("Email already taken");
        }
        String encodedPassword = bCryptPasswordEncoder
                .encode(u.getPassword());

        u.setPassword(encodedPassword);

        userRepository.save(u);

        String  token = UUID.randomUUID().toString();
        // TODO : send confirmation token
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                u
        );


        confirmationTokenService.saveConfirmationToken(
                confirmationToken
        );

        //TODO: SEND EMAIL
        return token;

    }

    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }
}
