package com.loft.exposition.libraryback.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

public class MailSender {

    @Autowired
    private JavaMailSender javaMailSender;
}
