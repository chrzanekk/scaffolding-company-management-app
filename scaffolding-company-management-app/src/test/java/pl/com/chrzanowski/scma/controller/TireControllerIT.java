package pl.com.chrzanowski.scma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.com.chrzanowski.scma.ScaffoldingCompanyManagementAppApplication;
import pl.com.chrzanowski.scma.domain.Tire;
import pl.com.chrzanowski.scma.domain.enumeration.*;
import pl.com.chrzanowski.scma.repository.TireRepository;
import pl.com.chrzanowski.scma.service.TireService;
import pl.com.chrzanowski.scma.service.dto.TireDTO;
import pl.com.chrzanowski.scma.service.mapper.TireMapper;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(classes = ScaffoldingCompanyManagementAppApplication.class)
@AutoConfigureMockMvc
@WithMockUser
public class TireControllerIT {
    private static final String API_PATH = "/api/tires";

    private static final Instant DEFAULT_CREATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant DEFAULT_MODIFY_DATE = Instant.ofEpochMilli(36000L);
    private static final String FIRST_BRAND = "first brand";
    private static final String SECOND_BRAND = "second brand";
    private static final String UPDATED_BRAND = "updated brand";
    private static final String FIRST_MODEL = "first model";
    private static final String SECOND_MODEL = "second model";
    private static final String UPDATED_MODEL = "updated model";

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
    @Autowired
    private TireMapper tireMapper;


    private final ObjectMapper objectMapper = new ObjectMapper();


    private Tire firstTire;
    private Tire secondTire;
    private Tire thirdTire;

    public static Tire createEntity(EntityManager em) {
        return new Tire()
                .setBrand(FIRST_BRAND)
                .setModel(FIRST_MODEL)
                .setWidth(FIRST_WIDTH)
                .setProfile(FIRST_PROFILE)
                .setDiameter(FIRST_DIAMETER)
                .setSpeedIndex(FIRST_SPEED_INDEX)
                .setCapacityIndex(FIRST_CAPACITY_INDEX)
                .setTireReinforcedIndex(FIRST_REINFORCED_INDEX)
                .setTireSeasonType(FIRST_SEASON_TYPE)
                .setRunOnFlat(false)
                .setType(FIRST_TIRE_TYPE)
                .setCreateDate(DEFAULT_CREATE_DATE);
    }

    public static Tire createSecondEntity(EntityManager em) {
        return new Tire()
                .setBrand(SECOND_BRAND)
                .setModel(SECOND_MODEL)
                .setWidth(SECOND_WIDTH)
                .setProfile(SECOND_PROFILE)
                .setDiameter(SECOND_DIAMETER)
                .setSpeedIndex(SECOND_SPEED_INDEX)
                .setCapacityIndex(SECOND_CAPACITY_INDEX)
                .setTireReinforcedIndex(SECOND_REINFORCED_INDEX)
                .setTireSeasonType(SECOND_SEASON_TYPE)
                .setRunOnFlat(false)
                .setType(SECOND_TIRE_TYPE)
                .setCreateDate(DEFAULT_CREATE_DATE);
    }

    public static Tire createUpdatedEntity(EntityManager em) {
        return new Tire()
                .setBrand(UPDATED_BRAND)
                .setModel(UPDATED_MODEL)
                .setWidth(UPDATED_WIDTH)
                .setProfile(UPDATED_PROFILE)
                .setDiameter(UPDATED_DIAMETER)
                .setSpeedIndex(UPDATED_SPEED_INDEX)
                .setCapacityIndex(UPDATED_CAPACITY_INDEX)
                .setTireReinforcedIndex(UPDATED_REINFORCED_INDEX)
                .setTireSeasonType(UPDATED_SEASON_TYPE)
                .setType(UPDATED_TIRE_TYPE)
                .setRunOnFlat(true)
                .setCreateDate(DEFAULT_CREATE_DATE)
                .setModifyDate(DEFAULT_MODIFY_DATE);
    }


    @BeforeEach
    public void initTest() {
        firstTire = createEntity(em);
        secondTire = createSecondEntity(em);
        thirdTire = createUpdatedEntity(em);
    }

    private void createGlobalTireInDB() {
        em.persist(firstTire);
        em.flush();
    }
    private void createSecondGlobalTireInDB() {
        em.persist(secondTire);
        em.flush();
    }

    @Test
    @Transactional
    public void createTire() throws Exception {
        List<Tire> allTiresBeforeTest = tireRepository.findAll();
        int sizeBeforeTest = allTiresBeforeTest.size();

        TireDTO tireDTO = tireMapper.toDto(firstTire);

        restTireMvc.perform(post(API_PATH + "/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isOk());

        List<Tire> allTiresAfterTest = tireRepository.findAll();
        int sizeAfterTest = allTiresAfterTest.size();
        assertThat(sizeAfterTest).isEqualTo(sizeBeforeTest + 1);
    }

    @Test
    @Transactional
    public void createTireShouldThrowBadRequestForMissingBrand() throws Exception {
        List<Tire> allTiresBeforeTest = tireRepository.findAll();

        TireDTO tireDTO = TireDTO.builder()
                .model(FIRST_MODEL)
                .width(FIRST_WIDTH)
                .profile(FIRST_PROFILE)
                .diameter(FIRST_DIAMETER)
                .tireReinforcedIndex(FIRST_REINFORCED_INDEX)
                .speedIndex(FIRST_SPEED_INDEX)
                .capacityIndex(FIRST_CAPACITY_INDEX)
                .tireSeasonType(FIRST_SEASON_TYPE)
                .type(FIRST_TIRE_TYPE)
                .runOnFlat(false)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(post(API_PATH + "/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void createTireShouldThrowBadRequestForMissingModel() throws Exception {
        List<Tire> allTiresBeforeTest = tireRepository.findAll();

        TireDTO tireDTO = TireDTO.builder()
                .brand(FIRST_BRAND)
                .width(FIRST_WIDTH)
                .profile(FIRST_PROFILE)
                .diameter(FIRST_DIAMETER)
                .tireReinforcedIndex(FIRST_REINFORCED_INDEX)
                .speedIndex(FIRST_SPEED_INDEX)
                .capacityIndex(FIRST_CAPACITY_INDEX)
                .tireSeasonType(FIRST_SEASON_TYPE)
                .type(FIRST_TIRE_TYPE)
                .runOnFlat(false)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(post(API_PATH + "/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void createTireShouldThrowBadRequestForMissingWidth() throws Exception {
        List<Tire> allTiresBeforeTest = tireRepository.findAll();

        TireDTO tireDTO = TireDTO.builder()
                .brand(FIRST_BRAND)
                .model(FIRST_MODEL)
                .profile(FIRST_PROFILE)
                .diameter(FIRST_DIAMETER)
                .tireReinforcedIndex(FIRST_REINFORCED_INDEX)
                .speedIndex(FIRST_SPEED_INDEX)
                .capacityIndex(FIRST_CAPACITY_INDEX)
                .tireSeasonType(FIRST_SEASON_TYPE)
                .type(FIRST_TIRE_TYPE)
                .runOnFlat(false)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(post(API_PATH + "/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void createTireShouldThrowBadRequestForMissingProfile() throws Exception {
        List<Tire> allTiresBeforeTest = tireRepository.findAll();

        TireDTO tireDTO = TireDTO.builder()
                .brand(FIRST_BRAND)
                .model(FIRST_MODEL)
                .width(FIRST_WIDTH)
                .diameter(FIRST_DIAMETER)
                .tireReinforcedIndex(FIRST_REINFORCED_INDEX)
                .speedIndex(FIRST_SPEED_INDEX)
                .capacityIndex(FIRST_CAPACITY_INDEX)
                .tireSeasonType(FIRST_SEASON_TYPE)
                .type(FIRST_TIRE_TYPE)
                .runOnFlat(false)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(post(API_PATH + "/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void createTireShouldThrowBadRequestForMissingDiameter() throws Exception {
        List<Tire> allTiresBeforeTest = tireRepository.findAll();

        TireDTO tireDTO = TireDTO.builder()
                .brand(FIRST_BRAND)
                .model(FIRST_MODEL)
                .width(FIRST_WIDTH)
                .profile(FIRST_PROFILE)
                .tireReinforcedIndex(FIRST_REINFORCED_INDEX)
                .speedIndex(FIRST_SPEED_INDEX)
                .capacityIndex(FIRST_CAPACITY_INDEX)
                .tireSeasonType(FIRST_SEASON_TYPE)
                .type(FIRST_TIRE_TYPE)
                .runOnFlat(false)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(post(API_PATH + "/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void createTireShouldThrowBadRequestForMissingReinforcedIndex() throws Exception {
        List<Tire> allTiresBeforeTest = tireRepository.findAll();

        TireDTO tireDTO = TireDTO.builder()
                .brand(FIRST_BRAND)
                .model(FIRST_MODEL)
                .width(FIRST_WIDTH)
                .profile(FIRST_PROFILE)
                .diameter(FIRST_DIAMETER)
                .speedIndex(FIRST_SPEED_INDEX)
                .capacityIndex(FIRST_CAPACITY_INDEX)
                .tireSeasonType(FIRST_SEASON_TYPE)
                .type(FIRST_TIRE_TYPE)
                .runOnFlat(false)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(post(API_PATH + "/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void createTireShouldThrowBadRequestForMissingSpeedIndex() throws Exception {
        List<Tire> allTiresBeforeTest = tireRepository.findAll();

        TireDTO tireDTO = TireDTO.builder()
                .brand(FIRST_BRAND)
                .model(FIRST_MODEL)
                .width(FIRST_WIDTH)
                .profile(FIRST_PROFILE)
                .diameter(FIRST_DIAMETER)
                .tireReinforcedIndex(FIRST_REINFORCED_INDEX)
                .capacityIndex(FIRST_CAPACITY_INDEX)
                .tireSeasonType(FIRST_SEASON_TYPE)
                .type(FIRST_TIRE_TYPE)
                .runOnFlat(false)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(post(API_PATH + "/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void createTireShouldThrowBadRequestForMissingCapacityIndex() throws Exception {
        List<Tire> allTiresBeforeTest = tireRepository.findAll();

        TireDTO tireDTO = TireDTO.builder()
                .brand(FIRST_BRAND)
                .model(FIRST_MODEL)
                .width(FIRST_WIDTH)
                .profile(FIRST_PROFILE)
                .diameter(FIRST_DIAMETER)
                .tireReinforcedIndex(FIRST_REINFORCED_INDEX)
                .speedIndex(FIRST_SPEED_INDEX)
                .tireSeasonType(FIRST_SEASON_TYPE)
                .type(FIRST_TIRE_TYPE)
                .runOnFlat(false)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(post(API_PATH + "/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void createTireShouldThrowBadRequestForMissingSeasonType() throws Exception {
        List<Tire> allTiresBeforeTest = tireRepository.findAll();

        TireDTO tireDTO = TireDTO.builder()
                .brand(FIRST_BRAND)
                .model(FIRST_MODEL)
                .width(FIRST_WIDTH)
                .profile(FIRST_PROFILE)
                .diameter(FIRST_DIAMETER)
                .tireReinforcedIndex(FIRST_REINFORCED_INDEX)
                .speedIndex(FIRST_SPEED_INDEX)
                .capacityIndex(FIRST_CAPACITY_INDEX)
                .type(FIRST_TIRE_TYPE)
                .runOnFlat(false)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(post(API_PATH + "/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void createTireShouldThrowBadRequestForMissingType() throws Exception {
        List<Tire> allTiresBeforeTest = tireRepository.findAll();

        TireDTO tireDTO = TireDTO.builder()
                .brand(FIRST_BRAND)
                .model(FIRST_MODEL)
                .width(FIRST_WIDTH)
                .profile(FIRST_PROFILE)
                .diameter(FIRST_DIAMETER)
                .tireReinforcedIndex(FIRST_REINFORCED_INDEX)
                .speedIndex(FIRST_SPEED_INDEX)
                .capacityIndex(FIRST_CAPACITY_INDEX)
                .tireSeasonType(FIRST_SEASON_TYPE)
                .runOnFlat(false)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(post(API_PATH + "/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void createTireShouldThrowBadRequestForMissingRunOnFlat() throws Exception {
        List<Tire> allTiresBeforeTest = tireRepository.findAll();

        TireDTO tireDTO = TireDTO.builder()
                .brand(FIRST_BRAND)
                .model(FIRST_MODEL)
                .width(FIRST_WIDTH)
                .profile(FIRST_PROFILE)
                .diameter(FIRST_DIAMETER)
                .tireReinforcedIndex(FIRST_REINFORCED_INDEX)
                .speedIndex(FIRST_SPEED_INDEX)
                .capacityIndex(FIRST_CAPACITY_INDEX)
                .tireSeasonType(FIRST_SEASON_TYPE)
                .type(FIRST_TIRE_TYPE)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(post(API_PATH + "/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void updateTire() throws Exception {
        createGlobalTireInDB();
        List<Tire> allTiresBeforeTest = tireRepository.findAll();
        int sizeBeforeTest = allTiresBeforeTest.size();
        thirdTire.setId(allTiresBeforeTest.get(0).getId());

        TireDTO tireDTO = tireMapper.toDto(thirdTire);

        restTireMvc.perform(put(API_PATH + "/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isOk());

        List<Tire> allTiresAfterTest = tireRepository.findAll();
        int sizeAfterTest = allTiresAfterTest.size();
        assertThat(sizeAfterTest).isEqualTo(sizeBeforeTest);
    }

    @Test
    @Transactional
    public void updateTireShouldThrowBadRequestForMissingBrand() throws Exception {
        createGlobalTireInDB();
        List<Tire> allTiresBeforeTest = tireRepository.findAll();
        int sizeBeforeTest = allTiresBeforeTest.size();
        Long id = allTiresBeforeTest.get(0).getId();

        TireDTO tireDTO = TireDTO.builder()
                .id(id)
                .model(UPDATED_MODEL)
                .width(UPDATED_WIDTH)
                .profile(UPDATED_PROFILE)
                .diameter(UPDATED_DIAMETER)
                .tireReinforcedIndex(UPDATED_REINFORCED_INDEX)
                .speedIndex(UPDATED_SPEED_INDEX)
                .capacityIndex(UPDATED_CAPACITY_INDEX)
                .tireSeasonType(UPDATED_SEASON_TYPE)
                .type(UPDATED_TIRE_TYPE)
                .runOnFlat(false)
                .modifyDate(DEFAULT_MODIFY_DATE)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(put(API_PATH + "/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    public void updateTireShouldThrowBadRequestForMissingModel() throws Exception {
        createGlobalTireInDB();
        List<Tire> allTiresBeforeTest = tireRepository.findAll();
        int sizeBeforeTest = allTiresBeforeTest.size();
        Long id = allTiresBeforeTest.get(0).getId();

        TireDTO tireDTO = TireDTO.builder()
                .id(id)
                .brand(UPDATED_BRAND)
                .width(UPDATED_WIDTH)
                .profile(UPDATED_PROFILE)
                .diameter(UPDATED_DIAMETER)
                .tireReinforcedIndex(UPDATED_REINFORCED_INDEX)
                .speedIndex(UPDATED_SPEED_INDEX)
                .capacityIndex(UPDATED_CAPACITY_INDEX)
                .tireSeasonType(UPDATED_SEASON_TYPE)
                .type(UPDATED_TIRE_TYPE)
                .runOnFlat(false)
                .modifyDate(DEFAULT_MODIFY_DATE)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(put(API_PATH + "/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    public void updateTireShouldThrowBadRequestForMissingWidth() throws Exception {
        createGlobalTireInDB();
        List<Tire> allTiresBeforeTest = tireRepository.findAll();
        int sizeBeforeTest = allTiresBeforeTest.size();
        Long id = allTiresBeforeTest.get(0).getId();

        TireDTO tireDTO = TireDTO.builder()
                .id(id)
                .brand(UPDATED_BRAND)
                .model(UPDATED_MODEL)
                .profile(UPDATED_PROFILE)
                .diameter(UPDATED_DIAMETER)
                .tireReinforcedIndex(UPDATED_REINFORCED_INDEX)
                .speedIndex(UPDATED_SPEED_INDEX)
                .capacityIndex(UPDATED_CAPACITY_INDEX)
                .tireSeasonType(UPDATED_SEASON_TYPE)
                .type(UPDATED_TIRE_TYPE)
                .runOnFlat(false)
                .modifyDate(DEFAULT_MODIFY_DATE)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(put(API_PATH + "/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    public void updateTireShouldThrowBadRequestForMissingProfile() throws Exception {
        createGlobalTireInDB();
        List<Tire> allTiresBeforeTest = tireRepository.findAll();
        int sizeBeforeTest = allTiresBeforeTest.size();
        Long id = allTiresBeforeTest.get(0).getId();

        TireDTO tireDTO = TireDTO.builder()
                .id(id)
                .brand(UPDATED_BRAND)
                .model(UPDATED_MODEL)
                .width(UPDATED_WIDTH)
                .diameter(UPDATED_DIAMETER)
                .tireReinforcedIndex(UPDATED_REINFORCED_INDEX)
                .speedIndex(UPDATED_SPEED_INDEX)
                .capacityIndex(UPDATED_CAPACITY_INDEX)
                .tireSeasonType(UPDATED_SEASON_TYPE)
                .type(UPDATED_TIRE_TYPE)
                .runOnFlat(false)
                .modifyDate(DEFAULT_MODIFY_DATE)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(put(API_PATH + "/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    public void updateTireShouldThrowBadRequestForMissingDiameter() throws Exception {
        createGlobalTireInDB();
        List<Tire> allTiresBeforeTest = tireRepository.findAll();
        int sizeBeforeTest = allTiresBeforeTest.size();
        Long id = allTiresBeforeTest.get(0).getId();

        TireDTO tireDTO = TireDTO.builder()
                .id(id)
                .brand(UPDATED_BRAND)
                .model(UPDATED_MODEL)
                .width(UPDATED_WIDTH)
                .profile(UPDATED_PROFILE)
                .tireReinforcedIndex(UPDATED_REINFORCED_INDEX)
                .speedIndex(UPDATED_SPEED_INDEX)
                .capacityIndex(UPDATED_CAPACITY_INDEX)
                .tireSeasonType(UPDATED_SEASON_TYPE)
                .type(UPDATED_TIRE_TYPE)
                .runOnFlat(false)
                .modifyDate(DEFAULT_MODIFY_DATE)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(put(API_PATH + "/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    public void updateTireShouldThrowBadRequestForMissingReinforcedIndex() throws Exception {
        createGlobalTireInDB();
        List<Tire> allTiresBeforeTest = tireRepository.findAll();
        int sizeBeforeTest = allTiresBeforeTest.size();
        Long id = allTiresBeforeTest.get(0).getId();

        TireDTO tireDTO = TireDTO.builder()
                .id(id)
                .brand(UPDATED_BRAND)
                .model(UPDATED_MODEL)
                .width(UPDATED_WIDTH)
                .profile(UPDATED_PROFILE)
                .diameter(UPDATED_DIAMETER)
                .speedIndex(UPDATED_SPEED_INDEX)
                .capacityIndex(UPDATED_CAPACITY_INDEX)
                .tireSeasonType(UPDATED_SEASON_TYPE)
                .type(UPDATED_TIRE_TYPE)
                .runOnFlat(false)
                .modifyDate(DEFAULT_MODIFY_DATE)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(put(API_PATH + "/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    public void updateTireShouldThrowBadRequestForMissingSpeedIndex() throws Exception {
        createGlobalTireInDB();
        List<Tire> allTiresBeforeTest = tireRepository.findAll();
        int sizeBeforeTest = allTiresBeforeTest.size();
        Long id = allTiresBeforeTest.get(0).getId();

        TireDTO tireDTO = TireDTO.builder()
                .id(id)
                .brand(UPDATED_BRAND)
                .model(UPDATED_MODEL)
                .width(UPDATED_WIDTH)
                .profile(UPDATED_PROFILE)
                .diameter(UPDATED_DIAMETER)
                .tireReinforcedIndex(UPDATED_REINFORCED_INDEX)
                .capacityIndex(UPDATED_CAPACITY_INDEX)
                .tireSeasonType(UPDATED_SEASON_TYPE)
                .type(UPDATED_TIRE_TYPE)
                .runOnFlat(false)
                .modifyDate(DEFAULT_MODIFY_DATE)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(put(API_PATH + "/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    public void updateTireShouldThrowBadRequestForMissingCapacityIndex() throws Exception {
        createGlobalTireInDB();
        List<Tire> allTiresBeforeTest = tireRepository.findAll();
        int sizeBeforeTest = allTiresBeforeTest.size();
        Long id = allTiresBeforeTest.get(0).getId();

        TireDTO tireDTO = TireDTO.builder()
                .id(id)
                .brand(UPDATED_BRAND)
                .model(UPDATED_MODEL)
                .width(UPDATED_WIDTH)
                .profile(UPDATED_PROFILE)
                .diameter(UPDATED_DIAMETER)
                .tireReinforcedIndex(UPDATED_REINFORCED_INDEX)
                .speedIndex(UPDATED_SPEED_INDEX)
                .tireSeasonType(UPDATED_SEASON_TYPE)
                .type(UPDATED_TIRE_TYPE)
                .runOnFlat(false)
                .modifyDate(DEFAULT_MODIFY_DATE)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(put(API_PATH + "/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    public void updateTireShouldThrowBadRequestForMissingSeasonType() throws Exception {
        createGlobalTireInDB();
        List<Tire> allTiresBeforeTest = tireRepository.findAll();
        int sizeBeforeTest = allTiresBeforeTest.size();
        Long id = allTiresBeforeTest.get(0).getId();

        TireDTO tireDTO = TireDTO.builder()
                .id(id)
                .brand(UPDATED_BRAND)
                .model(UPDATED_MODEL)
                .width(UPDATED_WIDTH)
                .profile(UPDATED_PROFILE)
                .diameter(UPDATED_DIAMETER)
                .tireReinforcedIndex(UPDATED_REINFORCED_INDEX)
                .speedIndex(UPDATED_SPEED_INDEX)
                .capacityIndex(UPDATED_CAPACITY_INDEX)
                .type(UPDATED_TIRE_TYPE)
                .runOnFlat(false)
                .modifyDate(DEFAULT_MODIFY_DATE)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(put(API_PATH + "/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    public void updateTireShouldThrowBadRequestForMissingType() throws Exception {
        createGlobalTireInDB();
        List<Tire> allTiresBeforeTest = tireRepository.findAll();
        int sizeBeforeTest = allTiresBeforeTest.size();
        Long id = allTiresBeforeTest.get(0).getId();

        TireDTO tireDTO = TireDTO.builder()
                .id(id)
                .brand(UPDATED_BRAND)
                .model(UPDATED_MODEL)
                .width(UPDATED_WIDTH)
                .profile(UPDATED_PROFILE)
                .diameter(UPDATED_DIAMETER)
                .tireReinforcedIndex(UPDATED_REINFORCED_INDEX)
                .speedIndex(UPDATED_SPEED_INDEX)
                .capacityIndex(UPDATED_CAPACITY_INDEX)
                .tireSeasonType(UPDATED_SEASON_TYPE)
                .runOnFlat(false)
                .modifyDate(DEFAULT_MODIFY_DATE)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(put(API_PATH + "/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    public void updateTireShouldThrowBadRequestForMissingRunOnFlat() throws Exception {
        createGlobalTireInDB();
        List<Tire> allTiresBeforeTest = tireRepository.findAll();
        int sizeBeforeTest = allTiresBeforeTest.size();
        Long id = allTiresBeforeTest.get(0).getId();

        TireDTO tireDTO = TireDTO.builder()
                .id(id)
                .brand(UPDATED_BRAND)
                .model(UPDATED_MODEL)
                .width(UPDATED_WIDTH)
                .profile(UPDATED_PROFILE)
                .diameter(UPDATED_DIAMETER)
                .tireReinforcedIndex(UPDATED_REINFORCED_INDEX)
                .speedIndex(UPDATED_SPEED_INDEX)
                .capacityIndex(UPDATED_CAPACITY_INDEX)
                .tireSeasonType(UPDATED_SEASON_TYPE)
                .type(UPDATED_TIRE_TYPE)
                .modifyDate(DEFAULT_MODIFY_DATE)
                .createDate(DEFAULT_CREATE_DATE).build();

        restTireMvc.perform(put(API_PATH + "/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(tireDTO))).andExpect(status().isBadRequest());

    }

    @Test
    @Transactional
    public void findAllTires() throws Exception {
        createGlobalTireInDB();
        createSecondGlobalTireInDB();

        int sizeBeforeTest = tireRepository.findAll().size();

        MvcResult result = restTireMvc.perform(get(API_PATH + "/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isNotEmpty()).andReturn();


        int sizeAfterTest = result.getResponse().getContentLength();
        String list = result.getResponse().getContentAsString();
        JSONArray jsonArray = new JSONArray(list);
        List<Object> tireDTOList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            tireDTOList.add(jsonArray.get(i));
        }

        int size = tireDTOList.size();
        assertThat(size).isEqualTo(sizeBeforeTest);
    }

    @Test
    @Transactional
    public void findTireById() throws Exception {
        createGlobalTireInDB();
        List<Tire> tireList = tireRepository.findAll();
        int sizeBeforeTest = tireList.size();

        restTireMvc.perform(get(API_PATH + "/getById/{id}", firstTire.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(firstTire.getId().intValue()))
                .andExpect(jsonPath("$.brand").value(firstTire.getBrand()))
                .andExpect(jsonPath("$.model").value(firstTire.getModel()))
                .andExpect(jsonPath("$.width").value(firstTire.getWidth()))
                .andExpect(jsonPath("$.profile").value(firstTire.getProfile()))
                .andExpect(jsonPath("$.diameter").value(firstTire.getDiameter()))
                .andExpect(jsonPath("$.type").value(firstTire.getType().toString()))
                .andExpect(jsonPath("$.tireReinforcedIndex").value(firstTire.getTireReinforcedIndex().toString()))
                .andExpect(jsonPath("$.speedIndex").value(firstTire.getSpeedIndex().toString()))
                .andExpect(jsonPath("$.capacityIndex").value(firstTire.getCapacityIndex().toString()))
                .andExpect(jsonPath("$.tireSeasonType").value(firstTire.getTireSeasonType().toString()))
                .andExpect(jsonPath("$.runOnFlat").value(firstTire.getRunOnFlat()));
    }

    @Test
    @Transactional
    public void deleteTireById() throws Exception {
        createGlobalTireInDB();

        List<Tire> tireList = tireRepository.findAll();
        int sizeBeforeTest = tireList.size();

        restTireMvc.perform(delete(API_PATH + "/delete/{id}", firstTire.getId()))
                .andExpect(status().isOk());
        List<Tire> tireListAfterTest = tireRepository.findAll();
        int sizeAfterTest = tireListAfterTest.size();

        assertThat(sizeAfterTest).isEqualTo(sizeBeforeTest - 1);
    }

    @Test
    @Transactional
    public void findTireByBrand() throws Exception {
        createGlobalTireInDB();
        createSecondGlobalTireInDB();
        defaultTireShouldBeFound("brand=" + FIRST_BRAND);
        defaultTireShouldNotBeFound("brand=" + UPDATED_BRAND);
    }

    @Test
    @Transactional
    public void findTireByModel() throws Exception {
        createGlobalTireInDB();
        createSecondGlobalTireInDB();
        defaultTireShouldBeFound("model=" + FIRST_MODEL);
        defaultTireShouldNotBeFound("model=" + UPDATED_MODEL);
    }

    @Test
    @Transactional
    public void findTireByWidth() throws Exception {
        createGlobalTireInDB();
        createSecondGlobalTireInDB();
        defaultTireShouldBeFound("widthStartsWith=" + FIRST_WIDTH + "&widthEndWith=" + FIRST_WIDTH);
        defaultTireShouldNotBeFound("widthStartsWith=" + UPDATED_WIDTH + "&widthEndWith=" + UPDATED_WIDTH);
    }

    @Test
    @Transactional
    public void findTireByProfile() throws Exception {
        createGlobalTireInDB();
        createSecondGlobalTireInDB();
        defaultTireShouldBeFound("profileStartsWith=" + FIRST_PROFILE + "&profileEndWith=" + FIRST_PROFILE);
        defaultTireShouldNotBeFound("profileStartsWith=" + UPDATED_PROFILE + "&profileEndWith=" + UPDATED_PROFILE);
    }

    @Test
    @Transactional
    public void findTireByDiameter() throws Exception {
        createGlobalTireInDB();
        createSecondGlobalTireInDB();
        defaultTireShouldBeFound("diameterStartsWith=" + FIRST_DIAMETER + "&diameterEndWith=" + FIRST_DIAMETER);
        defaultTireShouldNotBeFound("diameterStartsWith=" + UPDATED_DIAMETER + "&diameterEndWith=" + UPDATED_DIAMETER);
    }

    @Test
    @Transactional
    public void findTireByType() throws Exception {
        createGlobalTireInDB();
        createSecondGlobalTireInDB();
        defaultTireShouldBeFound("type=" + FIRST_TIRE_TYPE);
        defaultTireShouldNotBeFound("type=" + UPDATED_TIRE_TYPE);
    }

    @Test
    @Transactional
    public void findTireByReinforcedIndex() throws Exception {
        createGlobalTireInDB();
        createSecondGlobalTireInDB();
        defaultTireShouldBeFound("reinforcedIndex=" + FIRST_REINFORCED_INDEX);
        defaultTireShouldNotBeFound("reinforcedIndex=" + UPDATED_REINFORCED_INDEX);
    }

    @Test
    @Transactional
    public void findTireBySpeedIndex() throws Exception {
        createGlobalTireInDB();
        createSecondGlobalTireInDB();
        defaultTireShouldBeFound("speedIndex=" + FIRST_SPEED_INDEX);
        defaultTireShouldNotBeFound("speedIndex=" + UPDATED_SPEED_INDEX);
    }

    @Test
    @Transactional
    public void findTireByCapacityIndex() throws Exception {
        createGlobalTireInDB();
        createSecondGlobalTireInDB();
        defaultTireShouldBeFound("loadCapacityIndex=" + FIRST_CAPACITY_INDEX);
        defaultTireShouldNotBeFound("loadCapacityIndex=" + UPDATED_CAPACITY_INDEX);
    }

    @Test
    @Transactional
    public void findTireBySeasonType() throws Exception {
        createGlobalTireInDB();
        createSecondGlobalTireInDB();
        defaultTireShouldBeFound("seasonType=" + FIRST_SEASON_TYPE);
        defaultTireShouldNotBeFound("seasonType=" + UPDATED_SEASON_TYPE);
    }

    @Test
    @Transactional
    public void findTireByRunOnFlat() throws Exception {
        createGlobalTireInDB();
        createSecondGlobalTireInDB();
        defaultTireShouldBeFound("runOnFlat=" + firstTire.getRunOnFlat());
        defaultTireShouldNotBeFound("runOnFlat=true");
    }


    private void defaultTireShouldBeFound(String filter) throws Exception {
        restTireMvc.perform(get(API_PATH + "/?sort=id,desc&" + filter)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.[*].id").value(hasItem(firstTire.getId().intValue())))
                .andExpect(jsonPath("$.[*].brand").value(hasItem(firstTire.getBrand())))
                .andExpect(jsonPath("$.[*].model").value(hasItem(firstTire.getModel())))
                .andExpect(jsonPath("$.[*].width").value(hasItem(firstTire.getWidth())))
                .andExpect(jsonPath("$.[*].profile").value(hasItem(firstTire.getProfile())))
                .andExpect(jsonPath("$.[*].diameter").value(hasItem(firstTire.getDiameter())))
                .andExpect(jsonPath("$.[*].type").value(hasItem(firstTire.getType().toString())))
                .andExpect(jsonPath("$.[*].tireReinforcedIndex").value(hasItem(firstTire.getTireReinforcedIndex().toString())))
                .andExpect(jsonPath("$.[*].speedIndex").value(hasItem(firstTire.getSpeedIndex().toString())))
                .andExpect(jsonPath("$.[*].capacityIndex").value(hasItem(firstTire.getCapacityIndex().toString())))
                .andExpect(jsonPath("$.[*].tireSeasonType").value(hasItem(firstTire.getTireSeasonType().toString())))
                .andExpect(jsonPath("$.[*].runOnFlat").value(hasItem(firstTire.getRunOnFlat())));
    }
    private void defaultTireShouldNotBeFound(String filter) throws Exception {
        restTireMvc.perform(get(API_PATH + "/?sort=id,desc&" + filter)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }
}
