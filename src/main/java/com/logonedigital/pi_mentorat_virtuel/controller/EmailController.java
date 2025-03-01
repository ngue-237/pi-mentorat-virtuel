package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.services.EmailService.EmailSender;
import org.springframework.web.bind.annotation.GetMapping;

public class EmailController

{
    private final EmailSender emailSender;



    public EmailController(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @GetMapping(path = "E-mail/get")
    public String sendSimpleMail(){
        String to = "miranda@gmail.com";
        String from = "yours@gmail.com";
        String subject = "test mail";
        String body = "Bonjour le monde du code";
        try {
            this.emailSender.sendSimpleMail(to, from, subject, body);
            return "Courier electronique envoyé avec succès !";
        }
        catch (Exception e){
            return "Error !" ;
        }
    }
}
