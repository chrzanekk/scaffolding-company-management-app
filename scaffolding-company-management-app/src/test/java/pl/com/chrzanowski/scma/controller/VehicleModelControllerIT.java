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
import pl.com.chrzanowski.scma.domain.VehicleBrand;
import pl.com.chrzanowski.scma.domain.VehicleModel;
import pl.com.chrzanowski.scma.repository.VehicleBrandRepository;
import pl.com.chrzanowski.scma.repository.VehicleModelRepository;
import pl.com.chrzanowski.scma.service.VehicleModelService;
import pl.com.chrzanowski.scma.service.dto.VehicleModelDTO;
import pl.com.chrzanowski.scma.service.mapper.VehicleModelMapper;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = ScaffoldingCompanyManagementAppApplication.class)
@AutoConfigureMockMvc
@WithMockUser
public class VehicleModelControllerIT {


    private static final String API_PATH = "/api/vehicleModels";

    private static final String FIRST_DEFAULT_MODEL_NAME = "firstDefaultModel";
    private static final String FIRST_UPDATED_MODEL_NAME = "firstUpdatedModel";
    private static final String FIRST_BAD_MODEL_NAME = "firstBadModel";
    private static final String SECOND_DEFAULT_MODEL_NAME = "secondDefaultModel";
    private static final String SECOND_UPDATED_MODEL_NAME = "secondUpdatedModel";

    private static final String FIRST_DEFAULT_BRAND_NAME = "firstDefaultVehicleBrand";
    private static final String FIRST_UPDATED_BRAND_NAME = "firstUpdatedVehicleBrand";
    private static final String FIRST_BAD_BRAND_NAME = "firstBadVehicleBrand";
    private static final String SECOND_DEFAULT_BRAND_NAME = "secondDefaultVehicleBrand";
    private static final String SECOND_UPDATED_BRAND_NAME = "secondUpdatedVehicleBrand";

    private static final Instant DEFAULT_CREATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant DEFAULT_MODIFY_DATE = Instant.ofEpochMilli(36000L);
    private static final Instant DEFAULT_REMOVE_DATE = Instant.ofEpochMilli(720000L);

    @Autowired
    private VehicleModelRepository vehicleModelRepository;
    @Autowired
    private VehicleBrandRepository vehicleBrandRepository;
    @Autowired
    private VehicleModelService vehicleModelService;
    @Autowired
    private VehicleModelMapper vehicleModelMapper;
    @Autowired
    MockMvc restVehicleModelMockMvc;
    @Autowired
    private EntityManager em;
    private VehicleModel vehicleModel;
    private VehicleModel secondVehicleModel;

    public static VehicleModel createEntity(EntityManager em) {
        VehicleModel vehicleModel = new VehicleModel().setName(FIRST_DEFAULT_MODEL_NAME).setCreateDate(DEFAULT_CREATE_DATE);
        VehicleBrand vehicleBrand;
        if(TestUtil.findAll(em, VehicleBrand.class).isEmpty()) {
            vehicleBrand = VehicleBrandControllerIT.createEntity(em);
            em.persist(vehicleBrand);
            em.flush();
        } else {
            vehicleBrand = TestUtil.findAll(em, VehicleBrand.class).get(0);
        }
        vehicleModel.setVehicleBrand(vehicleBrand);
        return vehicleModel;
    }

    public static VehicleModel createUpdatedEntity(EntityManager em) {
        VehicleModel vehicleModel =
                new VehicleModel().setName(FIRST_UPDATED_MODEL_NAME).setCreateDate(DEFAULT_CREATE_DATE)
                        .setModifyDate(DEFAULT_MODIFY_DATE);
        VehicleBrand vehicleBrand;
        if(TestUtil.findAll(em, VehicleBrand.class).isEmpty()) {
            vehicleBrand = VehicleBrandControllerIT.createEntity(em);
            em.persist(vehicleBrand);
            em.flush();
        } else {
            vehicleBrand = TestUtil.findAll(em, VehicleBrand.class).get(0);
        }
        vehicleModel.setVehicleBrand(vehicleBrand);
        return vehicleModel;
    }

    @BeforeEach
    public void initTest() {
        vehicleModel = createEntity(em);
    }


    @Test
    @Transactional
    public void createVehicleModel() throws Exception {
        int sizeBeforeTest = vehicleModelRepository.findAll().size();

        VehicleModelDTO vehicleModelDTO = vehicleModelMapper.toDto(vehicleModel);
        List<VehicleBrand> allBrands = vehicleBrandRepository.findAll();

        restVehicleModelMockMvc.perform(post(API_PATH + "/add").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(vehicleModelDTO))).andExpect(status().isOk());

        List<VehicleModel> vehicleModelList = vehicleModelRepository.findAll();
        VehicleModel firstVehicleModelFromDB = vehicleModelList.get(0);
        int sizeAfterTest = vehicleModelList.size();
        assertThat(sizeAfterTest).isEqualTo(sizeBeforeTest + 1);
        assertThat(firstVehicleModelFromDB.getName()).isEqualTo(FIRST_DEFAULT_MODEL_NAME);
        assertThat(firstVehicleModelFromDB.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
    }

    @Test
    @Transactional
    public void updateVehicleModel() throws Exception {
        createGlobalTwoVehicleModels();
        int sizeBeforeTest = vehicleModelRepository.findAll().size();

        List<VehicleModel> allVehicleModelListBeforeTest = vehicleModelRepository.findAll();

        VehicleModelDTO vehicleModelDTO = vehicleModelMapper.toDto(vehicleModel);
        VehicleModelDTO vehicleModelDToToUpdate =
                VehicleModelDTO.Builder.builder().id(vehicleModelDTO.getId()).name(FIRST_UPDATED_MODEL_NAME)
                        .createDate(vehicleModelDTO.getCreateDate()).modifyDate(DEFAULT_MODIFY_DATE).brandId(vehicleModelDTO.getVehicleBrandId()).build();

        restVehicleModelMockMvc.perform(put(API_PATH + "/update").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(vehicleModelDToToUpdate))).andExpect(status().isOk());

        List<VehicleModel> allVehicleModelList = vehicleModelRepository.findAll();
        VehicleModel firstVehicleModelFromDB = allVehicleModelList.get(0);
        int sizeAfterTest = allVehicleModelList.size();
        assertThat(sizeAfterTest).isEqualTo(sizeBeforeTest);
        assertThat(firstVehicleModelFromDB.getId()).isEqualTo(vehicleModelDTO.getId());
        assertThat(firstVehicleModelFromDB.getName()).isEqualTo(FIRST_UPDATED_MODEL_NAME);
        assertThat(firstVehicleModelFromDB.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(firstVehicleModelFromDB.getModifyDate()).isEqualTo(DEFAULT_MODIFY_DATE);
    }

    @Test
    @Transactional
    public void findAllVehicleModels() throws Exception {
        createGlobalTwoVehicleModels();

        int sizeBeforeTest = vehicleModelRepository.findAll().size();

        restVehicleModelMockMvc.perform(get(API_PATH + "/all")).andExpect(status().isOk());

        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        int sizeAfterTest = allVehicleModels.size();
        assertThat(sizeAfterTest).isEqualTo(sizeBeforeTest);
        VehicleModel firstVehicleModelFromDB = allVehicleModels.get(0);
        assertThat(firstVehicleModelFromDB.getId()).isEqualTo(vehicleModel.getId());
        assertThat(firstVehicleModelFromDB.getName()).isEqualTo(FIRST_DEFAULT_MODEL_NAME);
        assertThat(firstVehicleModelFromDB.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        VehicleModel secondVehicleModelFromDB = allVehicleModels.get(1);
        assertThat(secondVehicleModelFromDB.getId()).isEqualTo(secondVehicleModel.getId());
        assertThat(secondVehicleModelFromDB.getName()).isEqualTo(SECOND_DEFAULT_MODEL_NAME);
        assertThat(secondVehicleModelFromDB.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
    }

    @Test
    @Transactional
    public void findAllVehicleModelsWithNameFilter() throws Exception {
        createGlobalTwoVehicleModels();
        defaultVehicleModelShouldBeFound("name=" + FIRST_DEFAULT_MODEL_NAME);
        defaultVehicleModelShouldNotBeFound("name=" + FIRST_BAD_MODEL_NAME);
    }

    @Test
    @Transactional
    public void findUpdatedVehicleModelsWithNameFilter() throws Exception {
        createGlobalTwoUpdatedVehicleModels();
        defaultVehicleModelShouldBeFound("name=" + FIRST_UPDATED_MODEL_NAME);
        defaultVehicleModelShouldNotBeFound("name=" + FIRST_BAD_MODEL_NAME);
    }

    @Test
    @Transactional
    public void findVehicleModelWithIdFilter() throws Exception {
        createGlobalTwoVehicleModels();
        defaultVehicleModelShouldBeFound("id=" + vehicleModel.getId());
        defaultVehicleModelShouldNotBeFound("id=" + 100L);
    }
    @Test
    @Transactional
    public void findVehicleModelsWithCreateDateFilter() throws Exception {
        createGlobalTwoVehicleModels();
        defaultVehicleModelShouldBeFound("createDateStartWith=" + DEFAULT_CREATE_DATE.toString());
        defaultVehicleModelShouldNotBeFound("createDateStartWith=" + DEFAULT_REMOVE_DATE.toString());
    }

    @Test
    @Transactional
    public void findAllVehicleModelsWithBrandNameFilter() throws Exception {
        createGlobalTwoUpdatedVehicleModels();
        List<VehicleModel> allModels = vehicleModelRepository.findAll();
        defaultVehicleModelShouldBeFound("vehicleBrandName=" + FIRST_DEFAULT_BRAND_NAME );
        defaultVehicleModelShouldNotBeFound("vehicleBrandName=" + FIRST_BAD_BRAND_NAME);
    }

    @Test
    @Transactional
    public void findVehicleModelById() throws Exception {
        createGlobalTwoVehicleModels();

        restVehicleModelMockMvc.perform(get(API_PATH + "/getById/{id}", vehicleModel.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(vehicleModel.getId().intValue()))
                .andExpect(jsonPath("$.name").value(vehicleModel.getName()))
                .andExpect(jsonPath("$.createDate").value(DEFAULT_CREATE_DATE.toString()));
    }

    @Test
    @Transactional
    public void deleteVehicleModelById() throws Exception {
        createGlobalTwoVehicleModels();

        List<VehicleModel> allBeforeTest = vehicleModelRepository.findAll();
        int sizeBeforeTest = allBeforeTest.size();

        restVehicleModelMockMvc.perform(delete(API_PATH + "/delete/{id}", vehicleModel.getId()))
                .andExpect(status().isOk());
        List<VehicleModel> allAfterTest = vehicleModelRepository.findAll();
        int sizeAfterTest = allAfterTest.size();

        assertThat(sizeAfterTest).isEqualTo(sizeBeforeTest - 1);

    }


    private void createGlobalTwoVehicleModels() {
        em.persist(vehicleModel);
        em.flush();

        secondVehicleModel = createEntity(em);
        secondVehicleModel.setName(SECOND_DEFAULT_MODEL_NAME);
        secondVehicleModel.setCreateDate(DEFAULT_CREATE_DATE);
        em.persist(secondVehicleModel);
        em.flush();
    }

    private void createGlobalTwoUpdatedVehicleModels() {
        vehicleModel.setModifyDate(DEFAULT_MODIFY_DATE);
        vehicleModel.setName(FIRST_UPDATED_MODEL_NAME);
        em.persist(vehicleModel);
        em.flush();

        secondVehicleModel = createUpdatedEntity(em);
        secondVehicleModel.setName(SECOND_UPDATED_MODEL_NAME);
        em.persist(secondVehicleModel);
        em.flush();
    }

    private void defaultVehicleModelShouldBeFound(String filter) throws Exception {
        restVehicleModelMockMvc.perform(get(API_PATH + "/?sort=id,desc&" + filter)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.[*].id").value(hasItem(vehicleModel.getId().intValue())))
                .andExpect(jsonPath("$.[*].name").value(hasItem(vehicleModel.getName())))
                .andExpect(jsonPath("$.[*].vehicleBrandName").value(hasItem(vehicleModel.getVehicleBrand().getName())))
                .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())));
    }

    private void defaultUpdatedVehicleModelShouldBeFound(String filter) throws Exception {
        restVehicleModelMockMvc.perform(get(API_PATH + "/?sort=id,desc&" + filter)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.[*].id").value(hasItem(vehicleModel.getId().intValue())))
                .andExpect(jsonPath("$.[*].name").value(hasItem(vehicleModel.getName())))
                .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())))
                .andExpect(jsonPath("$.[*].modifyDate").value(hasItem(DEFAULT_MODIFY_DATE.toString())));
    }

    private void defaultVehicleModelShouldNotBeFound(String filter) throws Exception {
        restVehicleModelMockMvc.perform(get(API_PATH + "/?sort=id,desc&" + filter)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

}
