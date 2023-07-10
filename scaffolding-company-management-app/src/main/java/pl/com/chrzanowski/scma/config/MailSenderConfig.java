package pl.com.chrzanowski.scma.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailSenderConfig {

    private final ApplicationConfig applicationConfig;

    public MailSenderConfig(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setProtocol(applicationConfig.getMailProtocol());
        javaMailSender.setHost(applicationConfig.getMailHost());
        javaMailSender.setPort(applicationConfig.getMailPort());
        return javaMailSender;
    }
}
