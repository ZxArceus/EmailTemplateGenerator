package com.example.emailapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {
     private  String purpose;
     private  String recipient;
     private  String tone;
}
