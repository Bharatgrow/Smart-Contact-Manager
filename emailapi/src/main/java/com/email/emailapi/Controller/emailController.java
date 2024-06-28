package com.email.emailapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.email.emailapi.Model.emailRequest;
import com.email.emailapi.Service.EmailService;

@RestController
public class emailController {
@Autowired
    private EmailService emailService;

    @RequestMapping("/welcome")
    public String welcome(){

        return "this is email api";
    }

    @RequestMapping(value = "/sendEmail",method = RequestMethod.POST )
    public ResponseEntity<?> sendEmail(@RequestBody emailRequest request){

        boolean result=this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
        System.out.println(request);

        if(result){

        return ResponseEntity.ok("Done");}

        else
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("not sent");
    }
}
