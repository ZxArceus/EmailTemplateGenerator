package com.example.emailapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor
public class EmailResponse {
    private  String emailTemplate;
    private long responseTimeInMs;
    private  String timeStamp;
}
