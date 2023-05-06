package tn.esprit.Services;

import tn.esprit.Entities.Request;
import tn.esprit.Entities.User;

public interface IUserService {
    User retrieveUser(Integer idUser);
}
