package com.example.emailapp.Controller;

import com.example.emailapp.Service.EmailService;
import com.example.emailapp.dto.EmailRequest;
import com.example.emailapp.dto.EmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired private EmailService emailService;
    @PostMapping("/generate")
    public ResponseEntity<EmailResponse> generateEmail(@RequestBody EmailRequest emailRequest){
        EmailResponse response=emailService.createEmail(emailRequest);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/healthCheck")
    public String healthCheck(){
        return  "Email template  generator is running";
    }
}
