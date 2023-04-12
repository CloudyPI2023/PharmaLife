package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Command;
import tn.esprit.Services.CommandService;
import tn.esprit.Services.ICommandService;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8082")
@RestController
@AllArgsConstructor
public class CommandRestController {
    private  final ICommandService commandService;

    // http://localhost:8081/PharmaLife/all-commands
    @GetMapping("/all-commands")
    public List<Command> getCommands() {
        return commandService.retrieveAll();
    }

    // http://localhost:8081/PharmaLife/add-Command
    @PostMapping("/add-commands")
    public Command addCommand(@RequestBody Command p) {
        return commandService.addCommand(p);
    }

    // http://localhost:8081/PharmaLife/edit-command
    @PutMapping("/edit-commands")
    public Command editProduct(@RequestBody Command p) {
        return commandService.editCommand(p);
    }

    // http://localhost:8081/PharmaLife/delet-command/id
    @DeleteMapping("/delete-commands/{idCommand}")
    public void deleteProduct(@PathVariable("idCommand") Long id) {
        commandService.deleteCommand(id);
    }
}