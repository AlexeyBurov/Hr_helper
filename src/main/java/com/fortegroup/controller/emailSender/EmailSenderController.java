package com.fortegroup.controller.emailSender;

import com.fortegroup.model.email.EmailRequest;
import com.fortegroup.service.emailSender.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by alex on 5/3/17.
 */
@RestController
@RequestMapping("/rest/emails")
public class EmailSenderController {

    @Autowired
    private EmailSenderService emailSenderService;

    @RequestMapping(value = "/protected/sendEmail",method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestParam Long id,@RequestParam boolean flag){
        if(flag) {
            return ResponseEntity.ok(emailSenderService.sendApprovingEmails(id));
        }else {
            return ResponseEntity.ok(emailSenderService.sendRefusalEmails(id));
        }
    }

    @RequestMapping(value = "/protected/sendEmails",method = RequestMethod.POST)
    public ResponseEntity<?> sendEmails(@RequestBody EmailRequest request){
        if(request.isFlag()){
            return ResponseEntity.ok(emailSenderService.sendApprovingEmails(request.getPersonsId()));
        }else {
            return ResponseEntity.ok(emailSenderService.sendApprovingEmails(request.getPersonsId()));
        }
    }
}
