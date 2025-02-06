package com.logonedigital.pi_mentorat_virtuel.coltroller;

import com.logonedigital.pi_mentorat_virtuel.service.mailService.MailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping(path = "E-mail/get")
    public String sendSimpleMail(){
        String to = "it'sMe@gmail.com";
        String from = "forYou@gmail.com";
        String subject = "test mail";
        String body = "Bonjour le monde du code";
        try {
            this.mailService.sendSimpleMail(to, from, subject, body);
            return "Courier electronique envoyé avec succès !";
        }
        catch (Exception e){
            return "Error !" ;
        }
    }
}
