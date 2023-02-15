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
import pl.com.chrzanowski.scma.domain.FuelType;
import pl.com.chrzanowski.scma.repository.FuelTypeRepository;
import pl.com.chrzanowski.scma.service.dto.FuelTypeDTO;
import pl.com.chrzanowski.scma.service.impl.FuelTypeServiceImpl;
import pl.com.chrzanowski.scma.service.mapper.FuelTypeMapper;

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
public class FuelTypeControllerIT {

    private static final String API_PATH = "/api/fuelTypes";

    private static final String FIRST_DEFAULT_NAME = "firstDefaultFuelType";
    private static final String FIRST_UPDATED_NAME = "firstUpdatedFuelType";
    private static final String FIRST_BAD_NAME = "firstBadFuelType";
    private static final String SECOND_DEFAULT_NAME = "secondDefaultFuelType";
    private static final String SECOND_UPDATED_NAME = "secondUpdatedFuelType";
    private static final Instant DEFAULT_CREATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant DEFAULT_MODIFY_DATE = Instant.ofEpochMilli(36000L);
    private static final Instant DEFAULT_REMOVE_DATE = Instant.ofEpochMilli(720000L);

    @Autowired
    private FuelTypeRepository fuelTypeRepository;
    @Autowired
    private FuelTypeServiceImpl fuelTypeService;
    @Autowired
    private FuelTypeMapper fuelTypeMapper;
    @Autowired
    MockMvc restFuelTypeMockMvc;
    @Autowired
    private EntityManager em;
    private FuelType fuelType;
    private FuelType secondFuelType;

    public static FuelType createEntity(EntityManager em) {
        return new FuelType().name(FIRST_DEFAULT_NAME).createDate(DEFAULT_CREATE_DATE);
    }

    public static FuelType createUpdatedEntity(EntityManager em) {
        return new FuelType().name(FIRST_UPDATED_NAME).createDate(DEFAULT_CREATE_DATE).modifyDate(DEFAULT_MODIFY_DATE);
    }

    @BeforeEach
    public void initTest() {
        fuelType = createEntity(em);
    }

    @Test
    @Transactional
    public void createFuelType() throws Exception {
        int sizeBeforeTest = fuelTypeRepository.findAll().size();

        FuelTypeDTO fuelTypeDTO = fuelTypeMapper.toDto(fuelType);

        restFuelTypeMockMvc.perform(post(API_PATH + "/add").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(fuelTypeDTO))).andExpect(status().isOk());

        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        FuelType firstFuelType = allFuelTypes.get(0);
        int sizeAfterTest = allFuelTypes.size();
        assertThat(sizeAfterTest).isEqualTo(sizeBeforeTest + 1);
        assertThat(firstFuelType.getName()).isEqualTo(FIRST_DEFAULT_NAME);
        assertThat(firstFuelType.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
    }

    @Test
    @Transactional
    public void updateFuelType() throws Exception {
        createGlobalTwoFuelTypes();
        int sizeBeforeTest = fuelTypeRepository.findAll().size();

        FuelTypeDTO fuelTypeDTO = fuelTypeMapper.toDto(fuelType);
        FuelTypeDTO fuelTypeDTOtoUpdate = FuelTypeDTO.Builder.builder().id(fuelTypeDTO.getId()).name(FIRST_UPDATED_NAME)
                .createDate(fuelTypeDTO.getCreateDate()).modifyDate(DEFAULT_MODIFY_DATE).build();

        restFuelTypeMockMvc.perform(put(API_PATH + "/update").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(fuelTypeDTOtoUpdate))).andExpect(status().isOk());

        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        FuelType firstFuelType = allFuelTypes.get(0);
        int sizeAfterTest = allFuelTypes.size();
        assertThat(sizeAfterTest).isEqualTo(sizeBeforeTest);
        assertThat(firstFuelType.getId()).isEqualTo(fuelTypeDTO.getId());
        assertThat(firstFuelType.getName()).isEqualTo(FIRST_UPDATED_NAME);
        assertThat(firstFuelType.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(firstFuelType.getModifyDate()).isEqualTo(DEFAULT_MODIFY_DATE);
    }

    @Test
    @Transactional
    public void findAllFuelTypes() throws Exception {
        createGlobalTwoFuelTypes();

        int sizeBeforeTest = fuelTypeRepository.findAll().size();

        restFuelTypeMockMvc.perform(get(API_PATH + "/all")).andExpect(status().isOk());

        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        int sizeAfterTest = allFuelTypes.size();
        assertThat(sizeAfterTest).isEqualTo(sizeBeforeTest);
        FuelType firstFuelType = allFuelTypes.get(0);
        assertThat(firstFuelType.getId()).isEqualTo(fuelType.getId());
        assertThat(firstFuelType.getName()).isEqualTo(FIRST_DEFAULT_NAME);
        assertThat(firstFuelType.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        FuelType secondFuelType = allFuelTypes.get(1);
        assertThat(secondFuelType.getId()).isEqualTo(secondFuelType.getId());
        assertThat(secondFuelType.getName()).isEqualTo(SECOND_DEFAULT_NAME);
        assertThat(secondFuelType.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
    }

    @Test
    @Transactional
    public void findAllFuelTypesWithFilter() throws Exception {
        createGlobalTwoFuelTypes();
        defaultFuelTypeShouldBeFound("name=" + FIRST_DEFAULT_NAME);
        defaultFuelTypeShouldNotBeFound("name=" + FIRST_BAD_NAME);
    }

    @Test
    @Transactional
    public void findAllUpdatedFuelTypesWithFilter() throws Exception {
        createGlobalTwoUpdatedFuelTypes();
        defaultUpdatedFuelTypeShouldBeFound("name=" + FIRST_UPDATED_NAME);
        defaultFuelTypeShouldNotBeFound("name=" + FIRST_BAD_NAME);
    }

    @Test
    @Transactional
    public void findFuelTypeById() throws Exception {
        createGlobalTwoFuelTypes();

        List<FuelType> fuelTypeList = fuelTypeRepository.findAll();

        int sizeBeforeTest = fuelTypeList.size();

        restFuelTypeMockMvc.perform(get(API_PATH + "/getById/{id}", fuelType.getId())).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(fuelType.getId().intValue()))
                .andExpect(jsonPath("$.name").value(fuelType.getName()))
                .andExpect(jsonPath("$.createDate").value(DEFAULT_CREATE_DATE.toString()));


    }

    private void createGlobalTwoFuelTypes() {
        em.persist(fuelType);
        em.flush();

        secondFuelType = createEntity(em);
        secondFuelType.setName(SECOND_DEFAULT_NAME);
        secondFuelType.setCreateDate(DEFAULT_CREATE_DATE);
        em.persist(secondFuelType);
        em.flush();
    }

    private void createGlobalTwoUpdatedFuelTypes() {
        fuelType.setModifyDate(DEFAULT_MODIFY_DATE);
        fuelType.setName(FIRST_UPDATED_NAME);
        em.persist(fuelType);
        em.flush();

        secondFuelType = createUpdatedEntity(em);
        secondFuelType.setName(SECOND_DEFAULT_NAME);
        em.persist(secondFuelType);
        em.flush();
    }

    private void defaultFuelTypeShouldBeFound(String filter) throws Exception {
        restFuelTypeMockMvc.perform(get(API_PATH + "/?sort=id,desc&" + filter)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.[*].id").value(hasItem(fuelType.getId().intValue())))
                .andExpect(jsonPath("$.[*].name").value(hasItem(fuelType.getName())))
                .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())));
    }

    private void defaultUpdatedFuelTypeShouldBeFound(String filter) throws Exception {
        restFuelTypeMockMvc.perform(get(API_PATH + "/?sort=id,desc&" + filter)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.[*].id").value(hasItem(fuelType.getId().intValue())))
                .andExpect(jsonPath("$.[*].name").value(hasItem(fuelType.getName())))
                .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())))
                .andExpect(jsonPath("$.[*].modifyDate").value(hasItem(DEFAULT_MODIFY_DATE.toString())));
    }

    private void defaultFuelTypeShouldNotBeFound(String filter) throws Exception {
        restFuelTypeMockMvc.perform(get(API_PATH + "/?sort=id,desc&" + filter)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }


}
