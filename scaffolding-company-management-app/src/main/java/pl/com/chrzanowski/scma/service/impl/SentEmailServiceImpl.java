package pl.com.chrzanowski.scma.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.com.chrzanowski.scma.config.ApplicationConfig;
import pl.com.chrzanowski.scma.domain.SentEmail;
import pl.com.chrzanowski.scma.domain.enumeration.DictionaryType;
import pl.com.chrzanowski.scma.domain.enumeration.Language;
import pl.com.chrzanowski.scma.domain.enumeration.MailEvent;
import pl.com.chrzanowski.scma.payload.request.NewPasswordPutRequest;
import pl.com.chrzanowski.scma.payload.request.PasswordResetRequest;
import pl.com.chrzanowski.scma.payload.response.MessageResponse;
import pl.com.chrzanowski.scma.repository.SentEmailRepository;
import pl.com.chrzanowski.scma.service.DictionaryService;
import pl.com.chrzanowski.scma.service.EmailSenderService;
import pl.com.chrzanowski.scma.service.SentEmailService;
import pl.com.chrzanowski.scma.service.dto.ConfirmationTokenDTO;
import pl.com.chrzanowski.scma.service.dto.DictionaryDTO;
import pl.com.chrzanowski.scma.service.dto.SentEmailDTO;
import pl.com.chrzanowski.scma.service.mapper.SentEmailMapper;

import java.util.List;
import java.util.Locale;

@Service
public class SentEmailServiceImpl implements SentEmailService {
    private final Logger log = LoggerFactory.getLogger(SentEmailServiceImpl.class);

    private final EmailSenderService emailSenderService;
    private final SentEmailRepository sentEmailRepository;
    private final DictionaryService dictionaryService;
    private final TemplateEngine templateEngine;
    private final ApplicationConfig applicationConfig;
    private final SentEmailMapper sentEmailMapper;

    public SentEmailServiceImpl(EmailSenderService emailSenderService, SentEmailRepository sentEmailRepository,
                                DictionaryService dictionaryService, TemplateEngine templateEngine,
                                ApplicationConfig applicationConfig, SentEmailMapper sentEmailMapper) {
        this.emailSenderService = emailSenderService;
        this.sentEmailRepository = sentEmailRepository;
        this.dictionaryService = dictionaryService;
        this.templateEngine = templateEngine;
        this.applicationConfig = applicationConfig;
        this.sentEmailMapper = sentEmailMapper;
    }

    @Override
    public MessageResponse sendAfterRegistration(ConfirmationTokenDTO confirmationTokenDTO, Locale locale) {
        log.debug("Request to send email to confirm user registration: {}", confirmationTokenDTO.getEmail());
        Context context = new Context(locale);
        context.setVariable("loginPageUrl", applicationConfig.getScaffoldingAppUrl() + "/login");
        context.setVariable("emailConfirmationLink",
                applicationConfig.getScaffoldingAppUrl() + "/confirm?token=" + confirmationTokenDTO.getConfirmationToken());
        //template to send as string
        String content = templateEngine.process("mail-after-registration", context);
        String title = chooseTitle(MailEvent.AFTER_REGISTRATION, locale);
        SentEmailDTO sentEmailDTO = SentEmailDTO.builder()
                .userId(confirmationTokenDTO.getUserId())
                .userEmail(confirmationTokenDTO.getEmail())
                .title(title)
                .content(content)
                .mailEvent(MailEvent.AFTER_REGISTRATION)
                .language(Language.from(locale.getLanguage())).build();
        emailSenderService.sendEmail(sentEmailDTO);
        SentEmail sentEmail = sentEmailMapper.toEntity(sentEmailDTO);
        sentEmailRepository.save(sentEmail);
        return new MessageResponse("Register successful");
    }

    @Override
    public MessageResponse sendAfterPasswordChange(NewPasswordPutRequest newPasswordPutRequest) {
        log.debug("Request to send email to confirm password reset.");
        return new MessageResponse("");
    }

    @Override
    public MessageResponse sendPasswordResetMail(PasswordResetRequest passwordResetRequest) {
        return new MessageResponse("");
    }

    private String chooseTitle(MailEvent mailEvent, Locale locale) {

        List<DictionaryDTO> list = dictionaryService.getDictionary(DictionaryType.EMAIL_TITLES, locale);

        for (DictionaryDTO dictionaryData : list) {
            if (dictionaryData.getCode().equals(mailEvent.getCode())) {
                return dictionaryData.getValue();
            }
        }

        throw new IllegalArgumentException("No email title!");

    }
}
