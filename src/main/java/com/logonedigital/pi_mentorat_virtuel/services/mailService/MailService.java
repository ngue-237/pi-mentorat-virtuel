package com.logonedigital.pi_mentorat_virtuel.services.mailService;

public interface MailService {

    void sendSimpleMail(String to, String from, String subject, String body);
}
