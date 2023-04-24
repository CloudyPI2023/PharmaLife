package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.Entities.Donation;
import tn.esprit.Entities.Request;
import tn.esprit.Services.IRequestService;

import java.util.List;

@RestController
@CrossOrigin("*")
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

    @GetMapping("/getMyRequests/{idAssociation}")
    public List<Request> getRequestByAssociation (@PathVariable("idAssociation") Integer idAssociation)
    {
        return iRequestService.retrieveMyRequests(idAssociation);
    }





    @GetMapping("/retrieveAllRequests")
    public List<Request> retrieveAllRequests(){
        List<Request> listRequests = iRequestService.retrieveAllRequests();
        return listRequests;
    }

    @GetMapping("/retrieveAllRequestsInProgress")
    public List<Request> retrieveAllRequestsInProgress(){
        List<Request> listRequests = iRequestService.retrieveAllRequestsInProgress();
        return listRequests;
    }
    @GetMapping("/retrieveAllRequestsAccepted")
    public List<Request> retrieveAllRequestsAccepted(){
        List<Request> listRequests = iRequestService.retrieveAllRequestsAccepted();
        return listRequests;
    }
    @GetMapping("/retrieveAllRequestsRefused")
    public List<Request> retrieveAllRequestsRefused(){
        List<Request> listRequests = iRequestService.retrieveAllRequestsInRefused();
        return listRequests;
    }


    @PostMapping("/sendEmailToAssociation/{email}")
    @ResponseBody
    public void sendEmailToAssociation (@PathVariable String email) {
        iRequestService.sendMailToAssociation(email);
    }

    @GetMapping("/retrieveRequest/{id_request}")
    public Request retrieveRequest(@PathVariable("id_request")Integer IdRequest){
        return iRequestService.retrieveRequest(IdRequest);
    }

    @PutMapping("/updateRequest")
    public Request updateRequest(@RequestBody Request r){
        Request request = iRequestService.updateRequest(r);
        return request;
    }

    @PutMapping("/assignRequestToDonation/{id_donation}")
    public Request assignRequestToDonation(@RequestBody Request r, @PathVariable("id_donation")Integer IdDonation){
        Request request = iRequestService.assignRequestToDonation(r,IdDonation);
        return request;
    }

    @PutMapping("/updateRequestDonation")
    public Request updateRequestDonation(@RequestBody Request r){
        Request request = iRequestService.updateRequestDonation(r);
        return request;
    }

}
