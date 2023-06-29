package pl.com.chrzanowski.scma.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.config.ApplicationConfig;
import pl.com.chrzanowski.scma.exception.EmailSendFailException;
import pl.com.chrzanowski.scma.service.EmailSenderService;
import pl.com.chrzanowski.scma.service.dto.SentEmailDTO;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {
    private static final Logger log = LoggerFactory.getLogger(EmailSenderServiceImpl.class);
    private final JavaMailSender javaMailSender;
    private final ApplicationConfig applicationConfig;

    public EmailSenderServiceImpl(JavaMailSender javaMailSender, ApplicationConfig applicationConfig) {
        this.javaMailSender = javaMailSender;
        this.applicationConfig = applicationConfig;
    }

    @Override
    public void sendEmail(SentEmailDTO sentEmailDTO) {
        log.debug("Sending email to: {}", sentEmailDTO.getUserEmail());
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(sentEmailDTO.getUserEmail());
            helper.setReplyTo(applicationConfig.getReplyToEmail());
            helper.setFrom(applicationConfig.getFromEmail());
            helper.setSubject(sentEmailDTO.getTitle());
            helper.setText(sentEmailDTO.getContent(), true);
        } catch (MessagingException e) {
            log.error("Failed to send email", e);
            throw new EmailSendFailException("Failed to send email");
        }

        sendMail(mail);

    }

    private void sendMail(MimeMessage mail) {
        new Thread(() -> {
            javaMailSender.send(mail);
        }).start();
    }

}
