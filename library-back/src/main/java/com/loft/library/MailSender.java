package com.loft.library;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailSender {

    private JavaMailSender javaMailSender;

    public MailSender(JavaMailSender mailSender) {
        this.javaMailSender = mailSender;
    }

    public void sendMail() throws MailException{
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo("lflolo972@gmail.com");
        message.setSubject("premier JavaMail");
        message.setText("Ce mail a été envoyé via java");
        javaMailSender.send(message);
    }
}
