package pl.com.chrzanowski.scma.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.payload.request.NewPasswordPutRequest;
import pl.com.chrzanowski.scma.payload.request.PasswordResetRequest;
import pl.com.chrzanowski.scma.payload.response.MessageResponse;
import pl.com.chrzanowski.scma.repository.SentEmailRepository;
import pl.com.chrzanowski.scma.service.EmailSenderService;
import pl.com.chrzanowski.scma.service.SentEmailService;
import pl.com.chrzanowski.scma.service.dto.ConfirmationTokenDTO;

@Service
public class SentEmailServiceImpl implements SentEmailService {
    private final Logger log = LoggerFactory.getLogger(SentEmailServiceImpl.class);

    private final EmailSenderService emailSenderService;
    private final SentEmailRepository sentEmailRepository;

    public SentEmailServiceImpl(EmailSenderService emailSenderService, SentEmailRepository sentEmailRepository) {
        this.emailSenderService = emailSenderService;
        this.sentEmailRepository = sentEmailRepository;
    }

    @Override
    public MessageResponse sendAfterRegistration(ConfirmationTokenDTO confirmationTokenDTO) {
        log.debug("Request to send email to confirm user registration: {}", confirmationTokenDTO.getEmail());

        return new MessageResponse("");
    }
//todo extend NewPasswordPutRequest to user email
    @Override
    public MessageResponse sendAfterPasswordChange(NewPasswordPutRequest newPasswordPutRequest) {
        log.debug("Request to send email to confirm password reset.");
        return new MessageResponse("");
    }
    //todo extend NewPasswordPutRequest to user email
    @Override
    public MessageResponse sendPasswordResetMail(PasswordResetRequest passwordResetRequest) {
        return new MessageResponse("");
    }
}
