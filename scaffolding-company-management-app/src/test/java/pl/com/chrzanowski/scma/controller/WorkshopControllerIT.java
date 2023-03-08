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
import pl.com.chrzanowski.scma.service.dto.WorkshopDTO;
import pl.com.chrzanowski.scma.service.mapper.WorkshopMapper;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    WorkshopMapper workshopMapper;

    private Workshop workshop;
    private Workshop secondWorkshop;


    public static Workshop createEntity(EntityManager em) {
        Workshop workshop = new Workshop()
                .name(WorkshopTestConstans.FIRST_NAME.getField())
                .taxNumber(WorkshopTestConstans.FIRST_TAX_NUMBER.getField())
                .street(WorkshopTestConstans.FIRST_STREET.getField())
                .buildingNo(WorkshopTestConstans.FIRST_BUILDING_NO.getField())
                .apartmentNo(WorkshopTestConstans.FIRST_APARTMENT_NO.getField())
                .postalCode(WorkshopTestConstans.FIRST_POSTAL_CODE.getField())
                .city(WorkshopTestConstans.FIRST_CITY.getField())
                .country(Country.POLAND)
                .createDate(DEFAULT_CREATE_DATE);
        ServiceActionType firstServiceActionType;
        ServiceActionType secondServiceActionType;
        if (TestUtil.findAll(em, ServiceActionType.class).isEmpty()) {
            firstServiceActionType = ServiceActionTypeControllerIT.createEntity(em);
            em.persist(firstServiceActionType);
            em.flush();
            secondServiceActionType = ServiceActionTypeControllerIT.createEntity(em);
            secondServiceActionType.setName(SECOND_SERVICE_ACTION_TYPE_NAME);
            em.persist(secondServiceActionType);
            em.flush();
        } else {
            firstServiceActionType = TestUtil.findAll(em, ServiceActionType.class).get(0);
            secondServiceActionType = TestUtil.findAll(em, ServiceActionType.class).get(1);
        }
        Set<ServiceActionType> actionTypes = new HashSet<>();
        actionTypes.add(firstServiceActionType);
        actionTypes.add(secondServiceActionType);
        workshop.setServiceActionTypeSet(actionTypes);
        return workshop;
    }

    public static Workshop createSecondEntity(EntityManager em) {
        Workshop workshop = new Workshop()
                .name(WorkshopTestConstans.SECOND_NAME.getField())
                .taxNumber(WorkshopTestConstans.SECOND_TAX_NUMBER.getField())
                .street(WorkshopTestConstans.SECOND_STREET.getField())
                .buildingNo(WorkshopTestConstans.SECOND_BUILDING_NO.getField())
                .apartmentNo(WorkshopTestConstans.SECOND_APARTMENT_NO.getField())
                .postalCode(WorkshopTestConstans.SECOND_POSTAL_CODE.getField())
                .city(WorkshopTestConstans.SECOND_CITY.getField())
                .country(Country.POLAND)
                .createDate(DEFAULT_CREATE_DATE);
        ServiceActionType firstServiceActionType;
        ServiceActionType secondServiceActionType;
        if (TestUtil.findAll(em, ServiceActionType.class).isEmpty()) {
            firstServiceActionType = ServiceActionTypeControllerIT.createEntity(em);
            em.persist(firstServiceActionType);
            em.flush();
            secondServiceActionType = ServiceActionTypeControllerIT.createEntity(em);
            secondServiceActionType.setName(SECOND_SERVICE_ACTION_TYPE_NAME);
            em.persist(secondServiceActionType);
            em.flush();
        } else {
            firstServiceActionType = TestUtil.findAll(em, ServiceActionType.class).get(0);
            secondServiceActionType = TestUtil.findAll(em, ServiceActionType.class).get(1);
        }
        Set<ServiceActionType> actionTypes = new HashSet<>();
        actionTypes.add(firstServiceActionType);
        actionTypes.add(secondServiceActionType);
        workshop.setServiceActionTypeSet(actionTypes);
        return workshop;
    }

    public static Workshop createUpdatedEntity(EntityManager em) {
        Workshop workshop = new Workshop()
                .name(WorkshopTestConstans.UPDATED_NAME.getField())
                .taxNumber(WorkshopTestConstans.UPDATED_TAX_NUMBER.getField())
                .street(WorkshopTestConstans.UPDATED_STREET.getField())
                .buildingNo(WorkshopTestConstans.UPDATED_BUILDING_NO.getField())
                .apartmentNo(WorkshopTestConstans.UPDATED_APARTMENT_NO.getField())
                .city(WorkshopTestConstans.UPDATED_CITY.getField())
                .country(Country.POLAND)
                .createDate(DEFAULT_CREATE_DATE)
                .modifyDate(DEFAULT_MODIFY_DATE);
        ServiceActionType firstServiceActionType;

        if (TestUtil.findAll(em, ServiceActionType.class).isEmpty()) {
            firstServiceActionType = ServiceActionTypeControllerIT.createEntity(em);
            em.persist(firstServiceActionType);
            em.flush();
        } else {
            firstServiceActionType = TestUtil.findAll(em, ServiceActionType.class).get(0);
        }
        Set<ServiceActionType> actionTypes = new HashSet<>();
        actionTypes.add(firstServiceActionType);
        workshop.setServiceActionTypeSet(actionTypes);
        return workshop;
    }

    @BeforeEach
    public void initTest() {
        workshop = createEntity(em);
        secondWorkshop = createSecondEntity(em);
    }

    @Test
    @Transactional
    public void createWorkshop() throws Exception {
        serviceActionTypeRepository.deleteAll();
        List<Workshop> workshopListBeforeTest = workshopRepository.findAll();
        List<ServiceActionType> serviceActionTypeListBeforeTest = serviceActionTypeRepository.findAll();

        ServiceActionType firstServiceActionType = ServiceActionTypeControllerIT.createEntity(em);

        ServiceActionType secondServiceActionType = ServiceActionTypeControllerIT.createEntity(em);
        secondServiceActionType.setName(SECOND_SERVICE_ACTION_TYPE_NAME);


        Set<ServiceActionType> actionTypes = new HashSet<>();
        actionTypes.add(firstServiceActionType);
        actionTypes.add(secondServiceActionType);
        workshop.setServiceActionTypeSet(actionTypes);

        int sizeBeforeTest = workshopListBeforeTest.size();

        WorkshopDTO workshopDTO = workshopMapper.toDto(workshop);

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
        assertThat(firstWorkshopFromDB.getServiceActionTypeSet().size()).isEqualTo(2);
    }

}
