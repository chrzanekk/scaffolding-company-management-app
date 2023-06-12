package pl.com.chrzanowski.scma.service;

import pl.com.chrzanowski.scma.service.dto.UserDTO;

public interface EmailService {

    void sendAfterRegistration(UserDTO userDTO);

    void sendAfterPasswordChange(UserDTO userDTO);

    //    todo create passwordResetToken entity and DTO to handle send email below
    void sendPasswordResetMail(String token);

    void sendEmail(String recipientMail, String subject, String content);
}
