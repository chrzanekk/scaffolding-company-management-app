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
import pl.com.chrzanowski.scma.controller.enumeration.WorkshopTestConstans;
import pl.com.chrzanowski.scma.domain.ServiceActionType;
import pl.com.chrzanowski.scma.domain.Workshop;
import pl.com.chrzanowski.scma.domain.enumeration.Country;
import pl.com.chrzanowski.scma.repository.ServiceActionTypeRepository;
import pl.com.chrzanowski.scma.repository.WorkshopRepository;
import pl.com.chrzanowski.scma.service.WorkshopService;
import pl.com.chrzanowski.scma.service.dto.ServiceActionTypeDTO;
import pl.com.chrzanowski.scma.service.dto.WorkshopDTO;
import pl.com.chrzanowski.scma.service.mapper.ServiceActionTypeMapper;
import pl.com.chrzanowski.scma.service.mapper.WorkshopMapper;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ScaffoldingCompanyManagementAppApplication.class)
@AutoConfigureMockMvc
@WithMockUser
public class WorkshopControllerIT {
    private static final String API_PATH = "/api/workshops";

    private static final String FIRST_SERVICE_ACTION_TYPE_NAME = "firstServiceActionType";
    private static final String SECOND_SERVICE_ACTION_TYPE_NAME = "secondServiceActionType";
    private static final Instant DEFAULT_CREATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant DEFAULT_MODIFY_DATE = Instant.ofEpochMilli(36000L);

    @Autowired
    MockMvc restWorkshopMvc;
    @Autowired
    EntityManager em;
    @Autowired
    WorkshopRepository workshopRepository;
    @Autowired
    WorkshopService workshopService;
    @Autowired
    ServiceActionTypeRepository serviceActionTypeRepository;
    @Autowired
    ServiceActionTypeMapper serviceActionTypeMapper;
    @Autowired
    WorkshopMapper workshopMapper;

    private Workshop workshop;
    private Workshop secondWorkshop;
    private ServiceActionType firstServiceActionType;
    private ServiceActionType secondServiceActionType;


    public static Workshop createEntity(EntityManager em) {

        return new Workshop()
                .setName(WorkshopTestConstans.FIRST_NAME.getField())
                .setTaxNumber(WorkshopTestConstans.FIRST_TAX_NUMBER.getField())
                .setStreet(WorkshopTestConstans.FIRST_STREET.getField())
                .setBuildingNo(WorkshopTestConstans.FIRST_BUILDING_NO.getField())
                .setApartmentNo(WorkshopTestConstans.FIRST_APARTMENT_NO.getField())
                .setPostalCode(WorkshopTestConstans.FIRST_POSTAL_CODE.getField())
                .setCity(WorkshopTestConstans.FIRST_CITY.getField())
                .setCountry(Country.POLAND)
                .setCreateDate(DEFAULT_CREATE_DATE);
    }

    public static Workshop createSecondEntity(EntityManager em) {

        return new Workshop()
                .setName(WorkshopTestConstans.SECOND_NAME.getField())
                .setTaxNumber(WorkshopTestConstans.SECOND_TAX_NUMBER.getField())
                .setStreet(WorkshopTestConstans.SECOND_STREET.getField())
                .setBuildingNo(WorkshopTestConstans.SECOND_BUILDING_NO.getField())
                .setApartmentNo(WorkshopTestConstans.SECOND_APARTMENT_NO.getField())
                .setPostalCode(WorkshopTestConstans.SECOND_POSTAL_CODE.getField())
                .setCity(WorkshopTestConstans.SECOND_CITY.getField())
                .setCountry(Country.POLAND)
                .setCreateDate(DEFAULT_CREATE_DATE);
    }

    public static Workshop createUpdatedEntity(EntityManager em) {

        return new Workshop()
                .setName(WorkshopTestConstans.UPDATED_NAME.getField())
                .setTaxNumber(WorkshopTestConstans.UPDATED_TAX_NUMBER.getField())
                .setStreet(WorkshopTestConstans.UPDATED_STREET.getField())
                .setBuildingNo(WorkshopTestConstans.UPDATED_BUILDING_NO.getField())
                .setApartmentNo(WorkshopTestConstans.UPDATED_APARTMENT_NO.getField())
                .setCity(WorkshopTestConstans.UPDATED_CITY.getField())
                .setCountry(Country.POLAND)
                .setCreateDate(DEFAULT_CREATE_DATE)
                .setModifyDate(DEFAULT_MODIFY_DATE);
    }

    @BeforeEach
    public void initTest() {
        workshop = createEntity(em);
        secondWorkshop = createSecondEntity(em);

    }

    @Test
    @Transactional
    public void createWorkshop() throws Exception {
        createGlobalActionTypes();
        List<Workshop> workshopListBeforeTest = workshopRepository.findAll();
        List<ServiceActionTypeDTO> serviceActionTypeListBeforeTest =
                serviceActionTypeMapper.toDto(serviceActionTypeRepository.findAll());

        int sizeBeforeTest = workshopListBeforeTest.size();

        WorkshopDTO workshopDTO = workshopMapper.toDto(workshop);

        serviceActionTypeListBeforeTest.get(0);

        restWorkshopMvc.perform(post(API_PATH + "/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(workshopDTO))).andExpect(status().isOk());

        List<Workshop> workshopList = workshopRepository.findAll();
        List<ServiceActionType> serviceActionTypeList = serviceActionTypeRepository.findAll();
        Workshop firstWorkshopFromDB = workshopList.get(0);
        int sizeAfterTest = workshopList.size();
        assertThat(sizeAfterTest).isEqualTo(sizeBeforeTest + 1);
        assertThat(firstWorkshopFromDB.getName()).isEqualTo(WorkshopTestConstans.FIRST_NAME.getField());
        assertThat(firstWorkshopFromDB.getStreet()).isEqualTo(WorkshopTestConstans.FIRST_STREET.getField());
        assertThat(firstWorkshopFromDB.getBuildingNo()).isEqualTo(WorkshopTestConstans.FIRST_BUILDING_NO.getField());
        assertThat(firstWorkshopFromDB.getApartmentNo()).isEqualTo(WorkshopTestConstans.FIRST_APARTMENT_NO.getField());
        assertThat(firstWorkshopFromDB.getTaxNumber()).isEqualTo(WorkshopTestConstans.FIRST_TAX_NUMBER.getField());
        assertThat(firstWorkshopFromDB.getPostalCode()).isEqualTo(WorkshopTestConstans.FIRST_POSTAL_CODE.getField());
        assertThat(firstWorkshopFromDB.getCity()).isEqualTo(WorkshopTestConstans.FIRST_CITY.getField());
        assertThat(firstWorkshopFromDB.getCountry()).isEqualTo(Country.POLAND);
        assertThat(firstWorkshopFromDB.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(firstWorkshopFromDB.getServiceActionTypes().size()).isEqualTo(2);
    }

    private void createGlobalActionTypes() {
        firstServiceActionType = ServiceActionTypeControllerIT.createEntity(em);
        em.persist(firstServiceActionType);
        em.flush();
        secondServiceActionType = ServiceActionTypeControllerIT.createSecondEntity(em);
        em.persist(secondServiceActionType);
        em.flush();
    }

}
