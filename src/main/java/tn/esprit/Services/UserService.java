package tn.esprit.Services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Role;
import tn.esprit.Entities.User;
import tn.esprit.RegistrationAuth.Registration.Token.ConfirmationToken;
import tn.esprit.RegistrationAuth.Registration.Token.ConfirmationTokenService;
import tn.esprit.Repositories.UserRepository;


import java.time.LocalDateTime;
import java.util.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService, UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
     @Autowired
    private final UserRepository userRepository;


    @Override
    public User addUser(User u) {
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
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


  /*  @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }*/
  @Override
  public UserDetails loadUserByUsername(String email)
          throws UsernameNotFoundException {
      User user = userRepository.findByEmail(email).orElse(null);;
      if(user == null){
          throw new UsernameNotFoundException("User not found in the database");

      }if(!user.isEnabled()) {
          throw new UsernameNotFoundException("You need To Confirm your email");
      }else{
          log.info("User found in the database: {}", email);
      }
      List<SimpleGrantedAuthority> authorities = getUserAuthority(user.getRole().name());
      System.out.println(user.getUsername());

      return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), authorities);    }

     private List<SimpleGrantedAuthority> getUserAuthority(String userRoles) {
        Set<SimpleGrantedAuthority> roles = new HashSet<SimpleGrantedAuthority>();

        roles.add(new SimpleGrantedAuthority(userRoles));
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;

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
