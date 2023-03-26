package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Donation;
import tn.esprit.Entities.Request;
import tn.esprit.Services.IRequestService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/requests")
public class RequestRestController {
    IRequestService iRequestService;

    @PostMapping("/addRequest")
    public Request addRequest(@RequestBody Request r){
        Request request = iRequestService.addRequest(r);
        return request;
    }

    @DeleteMapping("cancelRequest/{id_request}")
    public void cancelRequest(@PathVariable("id_request") Integer IdRequest){
        iRequestService.cancelRequest(IdRequest);
    }

    @GetMapping("/retrieveAllRequests")
    public List<Request> retrieveAllRequests(){
        List<Request> listRequests = iRequestService.retrieveAllRequests();
        return listRequests;
    }

    @GetMapping("/retrieveRequest/{id_request}")
    public Request retrieveRequest(@PathVariable("id_request")Integer IdRequest){
        return iRequestService.retrieveRequest(IdRequest);
    }
}
