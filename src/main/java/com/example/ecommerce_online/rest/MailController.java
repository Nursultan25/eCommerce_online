package com.example.ecommerce_online.rest;

import com.example.ecommerce_online.model.request.EmailRequest;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail/")
@CrossOrigin("*")
public class MailController {

    private final JavaMailSender emailSender;

    @Autowired
    public MailController(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @PostMapping("/send")
    public String send(@RequestBody EmailRequest emailTo) {
        Lorem lorem = LoremIpsum.getInstance();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(emailTo.getEmail());
        message.setSubject(lorem.getWords(5, 10));
        message.setText(lorem.getParagraphs(2, 5));
        emailSender.send(message);
        return "Email sended to " + emailTo.getEmail();
    }
}
