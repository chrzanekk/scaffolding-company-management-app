package pl.com.chrzanowski.scma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import pl.com.chrzanowski.scma.ScaffoldingCompanyManagementAppApplication;
import pl.com.chrzanowski.scma.domain.Tire;
import pl.com.chrzanowski.scma.domain.enumeration.*;
import pl.com.chrzanowski.scma.repository.TireRepository;
import pl.com.chrzanowski.scma.service.TireService;

import javax.persistence.EntityManager;
import java.time.Instant;

@SpringBootTest(classes = ScaffoldingCompanyManagementAppApplication.class)
@AutoConfigureMockMvc
@WithMockUser
public class TireControllerIT {
    private static final String API_PATH = "/api/tires";

    private static final Instant DEFAULT_CREATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant DEFAULT_MODIFY_DATE = Instant.ofEpochMilli(36000L);
    private static final Integer FIRST_WIDTH = 255;
    private static final Integer SECOND_WIDTH = 265;
    private static final Integer UPDATED_WIDTH = 275;
    private static final Integer FIRST_PROFILE = 55;
    private static final Integer SECOND_PROFILE = 45;
    private static final Integer UPDATED_PROFILE = 35;
    private static final Integer FIRST_DIAMETER = 16;
    private static final Integer SECOND_DIAMETER = 17;
    private static final Integer UPDATED_DIAMETER = 18;
    private static final TireSpeedIndex FIRST_SPEED_INDEX = TireSpeedIndex.V;
    private static final TireSpeedIndex SECOND_SPEED_INDEX = TireSpeedIndex.W;
    private static final TireSpeedIndex UPDATED_SPEED_INDEX = TireSpeedIndex.U;
    private static final TireLoadCapacityIndex FIRST_CAPACITY_INDEX = TireLoadCapacityIndex.NINETY_NINE;
    private static final TireLoadCapacityIndex SECOND_CAPACITY_INDEX = TireLoadCapacityIndex.NINETY_ONE;
    private static final TireLoadCapacityIndex UPDATED_CAPACITY_INDEX = TireLoadCapacityIndex.NINETY_FIVE;
    private static final TireReinforcedIndex FIRST_REINFORCED_INDEX = TireReinforcedIndex.SL;
    private static final TireReinforcedIndex SECOND_REINFORCED_INDEX = TireReinforcedIndex.XL;
    private static final TireReinforcedIndex UPDATED_REINFORCED_INDEX = TireReinforcedIndex.C;
    private static final TireSeasonType FIRST_SEASON_TYPE = TireSeasonType.ALL_SEASON;
    private static final TireSeasonType SECOND_SEASON_TYPE = TireSeasonType.SUMMER;
    private static final TireSeasonType UPDATED_SEASON_TYPE = TireSeasonType.WINTER;
    private static final TireType FIRST_TIRE_TYPE = TireType.D;
    private static final TireType SECOND_TIRE_TYPE = TireType.D;
    private static final TireType UPDATED_TIRE_TYPE = TireType.R;

    @Autowired
    private MockMvc restTireMvc;
    @Autowired
    private EntityManager em;
    @Autowired
    private TireRepository tireRepository;
    @Autowired
    private TireService tireService;

    private Tire firstTire;
    private Tire secondTire;
    private Tire thirdTire;


}
