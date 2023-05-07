package tn.esprit.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Command;
import tn.esprit.Entities.Donation;
import tn.esprit.Entities.User;
import tn.esprit.Repositories.CommandRepository;
import tn.esprit.Repositories.UserRepository;


import java.util.HashMap;
import java.util.List;



@AllArgsConstructor
@Slf4j
@Service
public class CommandService implements ICommandService {
    private final CommandRepository commandRepository;

    UserRepository userRepository;


//    @Override
//    /* public Command addCommand(Command p) {
//        if (p.getShippingAddressCommand() == null || p.getShippingAddressCommand().isEmpty()) {
//            throw new IllegalArgumentException("ShippingAddress cannot be empty");
//        }
//        try {
//            return commandRepository.save(p);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to add ShippingAdress", e);
//        }
//    } */

    @Override
     public Command addCommand(Command p) {
            return commandRepository.save(p);
        }

    @Override
    public Command updateCommand(Command d) {
        return commandRepository.save(d);
    }

    @Override
    public void deleteCommand(Integer idCommand) {
        commandRepository.deleteById(idCommand);
    }


    @Override
    public List<Command> retrieveMyCommand(Integer idUser) {
        User user = userRepository.findById(idUser).orElse(null) ;
        return commandRepository.getCommandByUserCommand(user.getIdUser());
    }


    @Override
    public List<Command> retrieveAllCommand() {
        return (List<Command>) commandRepository.findAll();
    }

    @Override
    public Command retrieveCommand(Integer idCommand) {
        return commandRepository.findById(Math.toIntExact(Long.valueOf(idCommand))).get();
    }


    @Override
    public HashMap<String, Integer> CommandByStatus() {
        HashMap<String, Integer> map=new HashMap<>();
        List<Command> listCommands= (List<Command>) commandRepository.findAll();
        for (Command d:listCommands) {
            String status = d.getStatusCommand();
            if(map.containsKey(status)){
                map.put(status,map.get(status)+1);
            }
            else {
                map.put(status,1);
            }
        }
        return map;
    }







}



