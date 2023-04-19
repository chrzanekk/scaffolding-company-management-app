package pl.com.chrzanowski.scma.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
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
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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

}
