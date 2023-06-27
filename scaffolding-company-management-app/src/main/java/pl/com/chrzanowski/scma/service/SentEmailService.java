package pl.com.chrzanowski.scma.service;

import pl.com.chrzanowski.scma.payload.request.NewPasswordPutRequest;
import pl.com.chrzanowski.scma.payload.request.PasswordResetRequest;
import pl.com.chrzanowski.scma.payload.response.MessageResponse;
import pl.com.chrzanowski.scma.service.dto.ConfirmationTokenDTO;

import java.util.Locale;

public interface SentEmailService {
    MessageResponse sendAfterRegistration(ConfirmationTokenDTO confirmationTokenDTO, Locale locale);

    MessageResponse sendAfterEmailConfirmation(ConfirmationTokenDTO confirmationTokenDTO, Locale locale);

    MessageResponse sendAfterPasswordChange(NewPasswordPutRequest newPasswordPutRequest);

    MessageResponse sendPasswordResetMail(PasswordResetRequest passwordResetRequest);
}
