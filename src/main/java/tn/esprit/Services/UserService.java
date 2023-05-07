package tn.esprit.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.User;
import tn.esprit.Repositories.UserRepository;

@Service
@AllArgsConstructor
@Aspect
@Slf4j
public class UserService implements IUserService {
    UserRepository userRepository;
    @Override
    public User retrieveUser(Integer idUser) {
        return userRepository.findById(idUser).get();
    }
}
