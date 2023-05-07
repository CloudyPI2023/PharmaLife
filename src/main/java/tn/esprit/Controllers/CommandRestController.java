package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Command;
import tn.esprit.Services.ICommandService;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/commands")

public class CommandRestController {
    ICommandService iCommandService;

    @PostMapping("/add-command")
    public Command addCommand(@RequestBody Command d){
        Command command = iCommandService.addCommand(d);
        return command;
    }

    @PutMapping("/editCommand")
    public Command updateCommand(@RequestBody Command d){
        Command command = iCommandService.updateCommand(d);
        return command;
    }

    @DeleteMapping("/delete-command/{idCommand}")
    public void deleteCommand(@PathVariable("idCommand") Integer IdCommand){
        iCommandService.deleteCommand(IdCommand);
    }

    @GetMapping("/getMyCommand/{idUser}")
    public List<Command> getCommandByUser (@PathVariable("idUser") Integer idUser)
    {
        return iCommandService.retrieveMyCommand(idUser);

    }


    @GetMapping("/retrieveAllCommand")
    public List<Command> retrieveAllCommand(){
        List<Command> listCommand = iCommandService.retrieveAllCommand();
        return listCommand;
    }

    @GetMapping("/retrieveCommand/{idCommand}")
    public Command retrieveCommand(@PathVariable("idCommand")Integer IdCommand){
        return iCommandService.retrieveCommand(IdCommand);
    }

    @GetMapping("/statisticsCommandStatus")
    HashMap<String, Integer> CommandByStatus(){
        return iCommandService.CommandByStatus();
    }



}