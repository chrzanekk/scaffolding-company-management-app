package pl.com.chrzanowski.scma.service;

import pl.com.chrzanowski.scma.payload.request.NewPasswordPutRequest;
import pl.com.chrzanowski.scma.payload.request.PasswordResetRequest;
import pl.com.chrzanowski.scma.payload.response.MessageResponse;
import pl.com.chrzanowski.scma.service.dto.ConfirmationTokenDTO;

public interface SentEmailService {
    MessageResponse sendAfterRegistration(ConfirmationTokenDTO confirmationTokenDTO);

    MessageResponse sendAfterPasswordChange(NewPasswordPutRequest newPasswordPutRequest);

    MessageResponse sendPasswordResetMail(PasswordResetRequest passwordResetRequest);
}
