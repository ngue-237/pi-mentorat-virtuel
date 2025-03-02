package com.logonedigital.pi_mentorat_virtuel.services.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmailSender {
    private  JavaMailSender javaMailSender;

    public void notify(Activation activation){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("etondemiranda@gmail.com");

        message.setTo(activation.getMentore().email());

        message.setSubject("Votre code d'activation");

        message.setText("Bonjour Mr/Mne "+activation.getMentore().firstname()+" "+activation.getMentore().lastname()+"<br>"+"Your activation code is: " + activation.getCode());

        javaMailSender.send(message);

    }

    public void sendSimpleMail(String to, String from, String subject, String body) {
    }
}