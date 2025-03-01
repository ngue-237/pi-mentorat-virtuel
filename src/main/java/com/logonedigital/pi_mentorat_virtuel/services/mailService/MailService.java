package com.logonedigital.pi_mentorat_virtuel.service.mailService;

public interface MailService {

    void sendSimpleMail(String to, String from, String subject, String body);
}
