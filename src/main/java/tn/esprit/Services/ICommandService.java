package tn.esprit.Services;

import tn.esprit.Entities.Command;
import tn.esprit.Entities.Request;
import tn.esprit.Entities.User;

import java.util.HashMap;
import java.util.List;

public interface ICommandService {

    Command addCommand (Command d);
    Command updateCommand (Command d);
    void deleteCommand (Integer idCommand);
    List<Command> retrieveMyCommand(Integer idUser);
    HashMap<String, Integer> CommandByStatus();


    List<Command> retrieveAllCommand();
    Command retrieveCommand(Integer idCommand);






}