package com.example.emailapp.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class OpenRouterService {

    @Value("${openrouter.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String generateEmail(String purpose, String recipient, String tone) {

        String url = "https://openrouter.ai/api/v1/chat/completions";

        String prompt = String.format(
                "Write a short %s email to %s about %s. " +
                        "Include a subject line. Keep it brief.",
                tone, recipient, purpose
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        Map<String, Object> body = Map.of(
                "model", "gpt-4o-mini",
                "messages", List.of(
                        Map.of("role", "user", "content", prompt)
                )
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response =
                restTemplate.postForEntity(url, request, Map.class);

        // Extract assistant reply
        var choices = (List) response.getBody().get("choices");
        if (choices != null && !choices.isEmpty()) {
            Map firstChoice = (Map) choices.get(0);
            Map message = (Map) firstChoice.get("message");
            return (String) message.get("content");
        }
        return "No response from model.";
    }
}

