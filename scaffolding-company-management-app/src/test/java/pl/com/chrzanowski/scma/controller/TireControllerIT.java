package pl.com.chrzanowski.scma.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import pl.com.chrzanowski.scma.ScaffoldingCompanyManagementAppApplication;

import java.time.Instant;

@SpringBootTest(classes = ScaffoldingCompanyManagementAppApplication.class)
@AutoConfigureMockMvc
@WithMockUser
public class TireControllerIT {
    private static final String API_PATH = "/api/tires";

    private static final Instant DEFAULT_CREATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant DEFAULT_MODIFY_DATE = Instant.ofEpochMilli(36000L);
    private static final Integer FIRST_WIDTH = 45;
    private static final Integer SECOND_WIDTH = 55;
    private static final Integer UPDATED_WIDTH = 65;

}
