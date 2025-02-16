package com.logonedigital.pi_mentorat_virtuel.configuration;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@AllArgsConstructor
public class SmtpConfig {
    private Environment environment;

    @Bean
    public JavaMailSender sender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.environment.getProperty("spring.mail.host"));
        mailSender.setPort(2525);
        mailSender.setUsername(this.environment.getProperty("spring.mail.username"));
        mailSender.setPassword(this.environment.getProperty("spring.mail.password"));

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "*");

        return mailSender;
    }
}