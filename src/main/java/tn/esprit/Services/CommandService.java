package tn.esprit.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import tn.esprit.Entities.Command;
import tn.esprit.Repositories.CommandRepository;

import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class CommandService implements ICommandService {
    private final CommandRepository commandRepository;

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
    public Command editCommand(Command p)  throws RuntimeException {

        if (p.getIdCommand() == null) {
            throw new IllegalArgumentException("Command ID cannot be null");
        }

        try {
            return commandRepository.save(p);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update Command", e);
        }
    }
    @Override
    public void deleteCommand(Long idCommand) {
        Optional<Command> command = commandRepository.findById(idCommand);

        command.ifPresent(p -> {
            commandRepository.delete(p);
            log.info("Product with id " + idCommand + " has been deleted");
        });

    }
    @Override
    public List<Command> retrieveAll() {
        return commandRepository.findAll();
    }

}

