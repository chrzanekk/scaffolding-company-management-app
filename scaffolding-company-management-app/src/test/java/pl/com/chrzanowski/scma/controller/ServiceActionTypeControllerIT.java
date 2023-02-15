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
import pl.com.chrzanowski.scma.domain.ServiceActionType;
import pl.com.chrzanowski.scma.repository.ServiceActionTypeRepository;
import pl.com.chrzanowski.scma.service.ServiceActionTypeService;
import pl.com.chrzanowski.scma.service.dto.ServiceActionTypeDTO;
import pl.com.chrzanowski.scma.service.mapper.ServiceActionTypeMapper;

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
public class ServiceActionTypeControllerIT {

    private static final String API_PATH = "/api/serviceActionTypes";

    private static final String FIRST_DEFAULT_NAME = "firstDefaultServiceActionType";
    private static final String FIRST_UPDATED_NAME = "firstUpdatedServiceActionType";
    private static final String FIRST_BAD_NAME = "firstBadServiceActionType";
    private static final String SECOND_DEFAULT_NAME = "secondDefaultServiceActionType";
    private static final String SECOND_UPDATED_NAME = "secondUpdatedServiceActionType";
    private static final Instant DEFAULT_CREATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant DEFAULT_MODIFY_DATE = Instant.ofEpochMilli(36000L);
    private static final Instant DEFAULT_REMOVE_DATE = Instant.ofEpochMilli(720000L);

    @Autowired
    private ServiceActionTypeRepository serviceActionTypeRepository;
    @Autowired
    private ServiceActionTypeService serviceActionTypeService;
    @Autowired
    private ServiceActionTypeMapper serviceActionTypeMapper;
    @Autowired
    MockMvc restServiceActionTypeMockMvc;
    @Autowired
    private EntityManager em;
    private ServiceActionType serviceActionType;
    private ServiceActionType secondServiceActionType;

    public static ServiceActionType createEntity(EntityManager em) {
        return new ServiceActionType().name(FIRST_DEFAULT_NAME).createDate(DEFAULT_CREATE_DATE);
    }

    public static ServiceActionType createUpdatedEntity(EntityManager em) {
        return new ServiceActionType().name(FIRST_UPDATED_NAME).createDate(DEFAULT_CREATE_DATE)
                .modifyDate(DEFAULT_MODIFY_DATE);
    }

    @BeforeEach
    public void initTest() {
        serviceActionType = createEntity(em);
    }


    @Test
    @Transactional
    public void createServiceActionType() throws Exception {
        int sizeBeforeTest = serviceActionTypeRepository.findAll().size();

        ServiceActionTypeDTO fuelTypeDTO = serviceActionTypeMapper.toDto(serviceActionType);

        restServiceActionTypeMockMvc.perform(post(API_PATH + "/add").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(fuelTypeDTO))).andExpect(status().isOk());

        List<ServiceActionType> allServiceActionTypes = serviceActionTypeRepository.findAll();
        ServiceActionType firstServiceActionType = allServiceActionTypes.get(0);
        int sizeAfterTest = allServiceActionTypes.size();
        assertThat(sizeAfterTest).isEqualTo(sizeBeforeTest + 1);
        assertThat(firstServiceActionType.getName()).isEqualTo(FIRST_DEFAULT_NAME);
        assertThat(firstServiceActionType.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
    }

    @Test
    @Transactional
    public void updateServiceActionType() throws Exception {
        createGlobalTwoServiceActionTypes();
        int sizeBeforeTest = serviceActionTypeRepository.findAll().size();

        ServiceActionTypeDTO serviceActionTypeDTO = serviceActionTypeMapper.toDto(serviceActionType);
        ServiceActionTypeDTO serviceActionTypeDTO1 =
                ServiceActionTypeDTO.Builder.builder().id(serviceActionTypeDTO.getId()).name(FIRST_UPDATED_NAME)
                        .createDate(serviceActionTypeDTO.getCreateDate()).modifyDate(DEFAULT_MODIFY_DATE).build();

        restServiceActionTypeMockMvc.perform(put(API_PATH + "/update").contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(serviceActionTypeDTO1))).andExpect(status().isOk());

        List<ServiceActionType> serviceActionTypes = serviceActionTypeRepository.findAll();
        ServiceActionType firstServiceActionType = serviceActionTypes.get(0);
        int sizeAfterTest = serviceActionTypes.size();
        assertThat(sizeAfterTest).isEqualTo(sizeBeforeTest);
        assertThat(firstServiceActionType.getId()).isEqualTo(serviceActionTypeDTO.getId());
        assertThat(firstServiceActionType.getName()).isEqualTo(FIRST_UPDATED_NAME);
        assertThat(firstServiceActionType.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(firstServiceActionType.getModifyDate()).isEqualTo(DEFAULT_MODIFY_DATE);
    }

    @Test
    @Transactional
    public void findAllServiceActionTypes() throws Exception {
        createGlobalTwoServiceActionTypes();

        int sizeBeforeTest = serviceActionTypeRepository.findAll().size();

        restServiceActionTypeMockMvc.perform(get(API_PATH + "/all")).andExpect(status().isOk());

        List<ServiceActionType> allServiceActionTypes = serviceActionTypeRepository.findAll();
        int sizeAfterTest = allServiceActionTypes.size();
        assertThat(sizeAfterTest).isEqualTo(sizeBeforeTest);
        ServiceActionType firstServiceActionType = allServiceActionTypes.get(0);
        assertThat(firstServiceActionType.getId()).isEqualTo(serviceActionType.getId());
        assertThat(firstServiceActionType.getName()).isEqualTo(FIRST_DEFAULT_NAME);
        assertThat(firstServiceActionType.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        ServiceActionType secondServiceActionType = allServiceActionTypes.get(1);
        assertThat(secondServiceActionType.getId()).isEqualTo(secondServiceActionType.getId());
        assertThat(secondServiceActionType.getName()).isEqualTo(SECOND_DEFAULT_NAME);
        assertThat(secondServiceActionType.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
    }

    @Test
    @Transactional
    public void findAllServiceActionTypesWithFilter() throws Exception {
        createGlobalTwoServiceActionTypes();
        defaultServiceActionTypeShouldBeFound("name=" + FIRST_DEFAULT_NAME);
        defaultServiceActionTypeShouldNotBeFound("name=" + FIRST_BAD_NAME);
    }

    @Test
    @Transactional
    public void findAllUpdatedServiceActionTypesWithFilter() throws Exception {
        createGlobalTwoUpdatedServiceActionTypes();
        List<ServiceActionType> all = serviceActionTypeRepository.findAll();
        defaultUpdatedServiceActionTypeShouldBeFound("name=" + FIRST_UPDATED_NAME);
        defaultServiceActionTypeShouldNotBeFound("name=" + FIRST_BAD_NAME);
    }

    @Test
    @Transactional
    public void findFuelTypeById() throws Exception {
        createGlobalTwoServiceActionTypes();

        restServiceActionTypeMockMvc.perform(get(API_PATH + "/getById/{id}", serviceActionType.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(serviceActionType.getId().intValue()))
                .andExpect(jsonPath("$.name").value(serviceActionType.getName()))
                .andExpect(jsonPath("$.createDate").value(DEFAULT_CREATE_DATE.toString()));
    }


    private void createGlobalTwoServiceActionTypes() {
        em.persist(serviceActionType);
        em.flush();

        secondServiceActionType = createEntity(em);
        secondServiceActionType.setName(SECOND_DEFAULT_NAME);
        secondServiceActionType.setCreateDate(DEFAULT_CREATE_DATE);
        em.persist(secondServiceActionType);
        em.flush();
    }

    private void createGlobalTwoUpdatedServiceActionTypes() {
        serviceActionType.setModifyDate(DEFAULT_MODIFY_DATE);
        serviceActionType.setName(FIRST_UPDATED_NAME);
        em.persist(serviceActionType);
        em.flush();

        secondServiceActionType = createUpdatedEntity(em);
        secondServiceActionType.setName(SECOND_UPDATED_NAME);
        em.persist(secondServiceActionType);
        em.flush();
    }

    private void defaultServiceActionTypeShouldBeFound(String filter) throws Exception {
        restServiceActionTypeMockMvc.perform(get(API_PATH + "/?sort=id,desc&" + filter)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.[*].id").value(hasItem(serviceActionType.getId().intValue())))
                .andExpect(jsonPath("$.[*].name").value(hasItem(serviceActionType.getName())))
                .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())));
    }

    private void defaultUpdatedServiceActionTypeShouldBeFound(String filter) throws Exception {
        restServiceActionTypeMockMvc.perform(get(API_PATH + "/?sort=id,desc&" + filter)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.[*].id").value(hasItem(serviceActionType.getId().intValue())))
                .andExpect(jsonPath("$.[*].name").value(hasItem(serviceActionType.getName())))
                .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())))
                .andExpect(jsonPath("$.[*].modifyDate").value(hasItem(DEFAULT_MODIFY_DATE.toString())));
    }

    private void defaultServiceActionTypeShouldNotBeFound(String filter) throws Exception {
        restServiceActionTypeMockMvc.perform(get(API_PATH + "/?sort=id,desc&" + filter)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

}
