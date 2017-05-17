package com.fortegroup.controller.complaints;

import com.fortegroup.model.complaints.Complaint;
import com.fortegroup.service.complaints.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 5/9/17.
 */
@RestController
@RequestMapping("/rest/complaints/")
public class ComplaintsController {

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping(value = "complaint",method = RequestMethod.POST)
    public ResponseEntity<?> addComplaint(@RequestBody Complaint complaint){
        try {
            complaintService.saveComplaint(complaint);
            return ResponseEntity.ok(true);
        }catch (Throwable e) {
            return ResponseEntity.ok(false);
        }
    }

    @RequestMapping(value = "/protected/complaint",method = RequestMethod.PUT)
    public ResponseEntity<?> approveComplaint(@RequestBody Complaint complaint){
        complaintService.approveComplaint(complaint);
        return ResponseEntity.ok(true);
    }

    @RequestMapping(value = "/protected/complaint",method = RequestMethod.GET)
    public ResponseEntity<?> getNotApprovedComplaints(){
        return ResponseEntity.ok(complaintService.getAllNotApprovedComplaints());
    }

    @RequestMapping(value = "/protected/complaint/all",method = RequestMethod.GET)
    public ResponseEntity<?> getAllComplaints(){
        return ResponseEntity.ok(complaintService.getAllComplaints());
    }
}
