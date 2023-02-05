package pl.com.chrzanowski.scma.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.com.chrzanowski.scma.ScaffoldingCompanyManagementAppApplication;
import pl.com.chrzanowski.scma.domain.FuelType;
import pl.com.chrzanowski.scma.model.FuelTypeDTO;
import pl.com.chrzanowski.scma.repository.FuelTypeRepository;
import pl.com.chrzanowski.scma.service.impl.FuelTypeServiceImpl;
import pl.com.chrzanowski.scma.service.mapper.FuelTypeMapper;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootTest(classes = ScaffoldingCompanyManagementAppApplication.class)
@AutoConfigureMockMvc
public class FuelTypeControllerIT {

    private static final String DEFAULT_NAME = "firstDefaultFuelType";
    private static final String UPDATED_NAME = "firstUpdatedFuelType";

    private static final LocalDateTime DEFAULT_CREATE_DATE = LocalDateTime.now();
    private static final LocalDateTime DEFAULT_MODIFY_DATE = LocalDateTime.now().plus(2L, ChronoUnit.DAYS);
    private static final LocalDateTime DEFAULT_REMOVE_DATE = LocalDateTime.now().plus(7L, ChronoUnit.DAYS);

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

    public static FuelType createEntity(EntityManager em) {
        FuelType fuelType = FuelType.builder()
                .name(DEFAULT_NAME)
                .createDate(DEFAULT_CREATE_DATE).build();
        em.persist(fuelType);
        em.flush();
        return fuelType;
    }

    public static FuelType createUpdatedEntity(EntityManager em) {
        FuelType fuelType = FuelType.builder()
                .name(UPDATED_NAME)
                .createDate(DEFAULT_CREATE_DATE)
                .modifyDate(DEFAULT_MODIFY_DATE).build();
        em.persist(fuelType);
        em.flush();
        return fuelType;
    }

    @BeforeEach
    public void initTest() {
        fuelType = createEntity(em);
    }

    @Test
    @Transactional
    public void createFuelType() {
        int sizeBeforeTest = fuelTypeRepository.findAll().size();

        FuelTypeDTO fuelTypeDTO = fuelTypeMapper.toDto(fuelType);



    }

}
