package pl.com.chrzanowski.scma.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
@Configuration
@EnableCaching
@EnableScheduling
public class ApplicationConfig {

    @Value("${platform.replyToEmail}")
    private String replyToEmail;

    @Value("${platform.fromEmail}")
    private String fromEmail;

    @Value("${company.name}")
    private String companyName;

    @Value("${company.addressFirstLine}")
    private String companyAddressFirstLine;

    @Value("${company.addressSecondLine}")
    private String companyAddressSecondLine;

    @Value("${company.nip}")
    private String companyNip;

    @Value("${company.regon}")
    private String companyRegon;

    @Value("${company.contactMail}")
    private String companyContactMail;

    @Value("${company.contactMailto}")
    private String companyContactMailto;

    @Value("${platform.url}")
    private String scaffoldingAppUrl;

    @Value("${tokenValidityTimeInMinutes}")
    private Long tokenValidityTimeInMinutes;

    @Value("${logo.frontPath}")
    private String logoFrontPath;

    @Value("${logo.panelPath}")
    private String logoPanelPath;

    @Value("${faviconPath}")
    private String faviconPath;

    @Value("${platform.name.front}")
    private String appNameFront;

    @Value("${platform.name.panel}")
    private String appNamePanel;

    @Value("${company.country}")
    private String companyCountry;

    @Value("${company.pageUrl}")
    private String companyPageUrl;

    @Value("${path-to-service-actions-demand-pdf}")
    private String pathToServiceActionsPdf;

    @Value("${path-to-fonts}")
    private String pathToFonts;

    @Value("${path-to-email-template}")
    private String pathToEmailTemplate;

    @Value("${spring.mail.port}")
    private Integer mailPort;
    @Value("${spring.mail.host}")
    private String mailHost;
    @Value("${spring.mail.properties.mail.transport.protocol}")
    private String mailProtocol;


    private String templateNameServiceActionsDemandPdf = "admin-vehicle-service-actions-pdf.html";

    public String getPathToServiceActionsPdf() {
        return pathToServiceActionsPdf;
    }

    public String getTemplateNameServiceActionsDemandPdf() {
        return templateNameServiceActionsDemandPdf;
    }

    public String getPathToFonts() {
        return pathToFonts;
    }

    public String getReplyToEmail() {
        return replyToEmail;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddressFirstLine() {
        return companyAddressFirstLine;
    }

    public String getCompanyAddressSecondLine() {
        return companyAddressSecondLine;
    }

    public String getCompanyNip() {
        return companyNip;
    }

    public String getCompanyRegon() {
        return companyRegon;
    }

    public String getCompanyContactMail() {
        return companyContactMail;
    }

    public String getCompanyContactMailto() {
        return companyContactMailto;
    }

    public String getScaffoldingAppUrl() {
        return scaffoldingAppUrl;
    }

    public Long getTokenValidityTimeInMinutes() {
        return tokenValidityTimeInMinutes;
    }

    public String getLogoFrontPath() {
        return logoFrontPath;
    }

    public String getLogoPanelPath() {
        return logoPanelPath;
    }

    public String getAppNameFront() {
        return appNameFront;
    }

    public String getAppNamePanel() {
        return appNamePanel;
    }

    public String getCompanyCountry() {
        return companyCountry;
    }

    public String getCompanyPageUrl() {
        return companyPageUrl;
    }

    public String getFaviconPath() {
        return faviconPath;
    }

    public String getPathToEmailTemplate() {
        return pathToEmailTemplate;
    }

    public Integer getMailPort() {
        return mailPort;
    }

    public String getMailHost() {
        return mailHost;
    }

    public String getMailProtocol() {
        return mailProtocol;
    }

    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.serializationInclusion(JsonInclude.Include.NON_NULL);
        return builder;
    }
}
