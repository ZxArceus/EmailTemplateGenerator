package com.example.emailapp.Service;

import com.example.emailapp.dto.EmailRequest;
import com.example.emailapp.dto.EmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class EmailService {
    @Autowired
    OpenRouterService aiService;

    public EmailResponse createEmail(EmailRequest request) {
        long start = System.currentTimeMillis();

        String email = aiService.generateEmail(
                request.getPurpose(),
                request.getRecipient(),
                request.getTone()
        );

        long end = System.currentTimeMillis();
        long time = end - start;



        return new EmailResponse(email, time, LocalDateTime.now().toString());

    }
}