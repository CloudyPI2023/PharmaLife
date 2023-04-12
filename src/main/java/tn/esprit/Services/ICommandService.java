package tn.esprit.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Entities.Command;

import java.util.List;

public interface ICommandService  {
    Command addCommand(Command p);

    Command editCommand(Command p)  throws RuntimeException;

    void deleteCommand(Long idCommand);

    List<Command> retrieveAll();
}
