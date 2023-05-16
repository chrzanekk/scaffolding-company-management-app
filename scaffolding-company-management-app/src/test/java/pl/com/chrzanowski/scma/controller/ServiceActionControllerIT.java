package pl.com.chrzanowski.scma.controller;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import pl.com.chrzanowski.scma.ScaffoldingCompanyManagementAppApplication;
import pl.com.chrzanowski.scma.domain.*;
import pl.com.chrzanowski.scma.repository.*;
import pl.com.chrzanowski.scma.service.ServiceActionService;
import pl.com.chrzanowski.scma.service.VehicleService;
import pl.com.chrzanowski.scma.service.WorkshopService;
import pl.com.chrzanowski.scma.service.mapper.ServiceActionTypeMapper;
import pl.com.chrzanowski.scma.service.mapper.VehicleMapper;
import pl.com.chrzanowski.scma.service.mapper.WorkshopMapper;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest(classes = ScaffoldingCompanyManagementAppApplication.class)
@AutoConfigureMockMvc
@WithMockUser
public class ServiceActionControllerIT {

    private static final String API_PATH = "/api/serviceActions";

    private static final Instant DEFAULT_CREATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant DEFAULT_MODIFY_DATE = Instant.ofEpochMilli(36000L);
    private static final Integer FIRST_CAR_MILEAGE = 111111;
    private static final Integer SECOND_CAR_MILEAGE = 222222;
    private static final String FIRST_INVOICE_NUMBER = "1/01/2022";
    private static final String SECOND_INVOICE_NUMBER = "365/12/2022";
    private static final BigDecimal FIRST_GROSS_VALUE = new BigDecimal(123);
    private static final BigDecimal SECOND_GROSS_VALUE = new BigDecimal(220);
    private static final BigDecimal FIRST_NET_VALUE = new BigDecimal(100);
    private static final BigDecimal SECOND_NET_VALUE = new BigDecimal(200);
    private static final BigDecimal FIRST_TAX_VALUE = new BigDecimal(23);
    private static final BigDecimal SECOND_TAX_VALUE = new BigDecimal(20);
    private static final BigDecimal FIRST_TAX_RATE = new BigDecimal("0.23");
    private static final BigDecimal SECOND_TAX_RATE = new BigDecimal("0.10");
    private static final LocalDate FIRST_SERVICE_DATE = LocalDate.of(2022,1,2);
    private static final LocalDate SECOND_SERVICE_DATE = LocalDate.of(2022,12,1);
    private static final String FIRST_DESCRIPTION = "FIRST_DESCRIPTION";
    private static final String SECOND_DESCRIPTION = "SECOND_DESCRIPTION";

    @Autowired
    MockMvc restServiceActionMvc;
    @Autowired
    EntityManager em;
    @Autowired
    ServiceActionRepository serviceActionRepository;
    @Autowired
    ServiceActionService serviceActionService;
    @Autowired
    ServiceActionTypeRepository serviceActionTypeRepository;
    @Autowired
    ServiceActionTypeMapper serviceActionTypeMapper;
    @Autowired
    WorkshopMapper workshopMapper;
    @Autowired
    WorkshopRepository workshopRepository;
    @Autowired
    WorkshopService workshopService;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleMapper vehicleMapper;
    @Autowired
    private FuelTypeRepository fuelTypeRepository;
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;
    @Autowired
    private VehicleModelRepository vehicleModelRepository;
    @Autowired
    private VehicleBrandRepository vehicleBrandRepository;

    private Workshop firstWorkshop;
    private Workshop secondWorkshop;
    private ServiceActionType firstServiceActionType;
    private ServiceActionType secondServiceActionType;
    private VehicleBrand firstVehicleBrand;
    private VehicleBrand secondVehicleBrand;
    private VehicleModel firstVehicleModel;
    private VehicleModel secondVehicleModel;
    private VehicleType firstVehicleType;
    private VehicleType secondVehicleType;
    private FuelType firstFuelType;
    private FuelType secondFuelType;
    private Vehicle firstVehicle;
    private Vehicle secondVehicle;
    private ServiceAction firstServiceAction;
    private ServiceAction secondServiceAction;
    private Set<ServiceActionType> firstSetOfActionTypes;
    private Set<ServiceActionType> secondSetOfActionTypes;

    public static ServiceAction createEntity(EntityManager em) {
        return new ServiceAction()
                .setCarMileage(FIRST_CAR_MILEAGE)
                .setInvoiceNumber(FIRST_INVOICE_NUMBER)
                .setGrossValue(FIRST_GROSS_VALUE)
                .setTaxValue(FIRST_TAX_VALUE)
                .setTaxRate(FIRST_TAX_RATE)
                .setNetValue(FIRST_NET_VALUE)
                .setServiceDate(FIRST_SERVICE_DATE)
                .setDescription(FIRST_DESCRIPTION)
                .setCreateDate(DEFAULT_CREATE_DATE);
    }
    public static ServiceAction createSecondEntity(EntityManager em) {
        return new ServiceAction()
                .setCarMileage(SECOND_CAR_MILEAGE)
                .setInvoiceNumber(SECOND_INVOICE_NUMBER)
                .setGrossValue(SECOND_GROSS_VALUE)
                .setTaxValue(SECOND_TAX_VALUE)
                .setTaxRate(SECOND_TAX_RATE)
                .setNetValue(SECOND_NET_VALUE)
                .setServiceDate(SECOND_SERVICE_DATE)
                .setDescription(SECOND_DESCRIPTION)
                .setCreateDate(DEFAULT_CREATE_DATE);
    }

    @BeforeEach
    public void initTest() {
        deleteAllExistingData();
        createServiceActions();
    }













    private void deleteAllExistingData() {
        fuelTypeRepository.deleteAll();
        vehicleTypeRepository.deleteAll();
        vehicleBrandRepository.deleteAll();
        vehicleModelRepository.deleteAll();
        vehicleRepository.deleteAll();
        serviceActionTypeRepository.deleteAll();
        workshopRepository.deleteAll();
        serviceActionRepository.deleteAll();
    }

    private void createServiceActions() {
        createAllDefaultData();
        firstServiceAction = createEntity(em);
        firstServiceAction.setVehicle(firstVehicle);
        firstServiceAction.setServiceActionTypes(firstSetOfActionTypes);
        firstServiceAction.setWorkshop(firstWorkshop);

        secondServiceAction = createSecondEntity(em);
        secondServiceAction.setVehicle(secondVehicle);
        secondServiceAction.setServiceActionTypes(secondSetOfActionTypes);
        secondServiceAction.setWorkshop(secondWorkshop);
    }

    private void createAllDefaultData() {
        createGlobalVehicleBrands();
        createGlobalVehicleTypes();
        createGlobalFuelTypes();
        createGlobalVehicleModels();
        createGlobalVehicles();
        createGlobalActionTypes();
        createSetOfTwoActionTypes();
        createSetOfOneActionType();
        createGlobalWorkshopInDB();
        createSecondGlobalWorkshopInDB();
    }

    private void createGlobalActionTypes() {
        firstServiceActionType = ServiceActionTypeControllerIT.createEntity(em);
        em.persist(firstServiceActionType);
        em.flush();
        secondServiceActionType = ServiceActionTypeControllerIT.createSecondEntity(em);
        em.persist(secondServiceActionType);
        em.flush();
    }

    private void createGlobalWorkshopInDB() {
        firstWorkshop.setServiceActionTypes(firstSetOfActionTypes);
        em.persist(firstWorkshop);
        em.flush();
    }

    private void createSetOfTwoActionTypes() {
        List<ServiceActionType> serviceActionTypes = serviceActionTypeRepository.findAll();
        firstSetOfActionTypes = new HashSet<>(serviceActionTypes);
    }

    private void createSetOfOneActionType() {
        List<ServiceActionType> serviceActionTypes = new ArrayList<>();
        serviceActionTypes.add(firstServiceActionType);
        secondSetOfActionTypes = new HashSet<>(serviceActionTypes);
    }


    private void createSecondGlobalWorkshopInDB() {
        List<ServiceActionType> serviceActionTypes = serviceActionTypeRepository.findAll();
        Set<ServiceActionType> serviceActionTypeSet = new HashSet<>();
        serviceActionTypeSet.add(serviceActionTypes.get(0));
        secondWorkshop.setServiceActionTypes(serviceActionTypeSet);
        em.persist(secondWorkshop);
        em.flush();
    }

    private void createGlobalFuelTypes() {
        firstFuelType = FuelTypeControllerIT.createEntity(em);
        fuelTypeRepository.saveAndFlush(firstFuelType);

        secondFuelType = FuelTypeControllerIT.createSecondEntity(em);
        fuelTypeRepository.saveAndFlush(secondFuelType);
    }

    private void createGlobalVehicleTypes() {
        firstVehicleType = VehicleTypeControllerIT.createEntity(em);
        vehicleTypeRepository.saveAndFlush(firstVehicleType);
        secondVehicleType = VehicleTypeControllerIT.createSecondEntity(em);
        vehicleTypeRepository.saveAndFlush(secondVehicleType);
    }

    private void createGlobalVehicleModels() {
        firstVehicleModel = VehicleModelControllerIT.createEntity(em);
        firstVehicleModel.setVehicleBrand(firstVehicleBrand);
        em.persist(firstVehicleModel);
        em.flush();
        secondVehicleModel = VehicleModelControllerIT.createSecondEntity(em);
        secondVehicleModel.setVehicleBrand(secondVehicleBrand);
        em.persist(secondVehicleModel);
        em.flush();
    }

    private void createGlobalVehicleBrands() {
        firstVehicleBrand = VehicleBrandControllerIT.createEntity(em);
        em.persist(firstVehicleBrand);
        em.flush();
        secondVehicleBrand = VehicleBrandControllerIT.createSecondEntity(em);
        em.persist(secondVehicleBrand);
        em.flush();
    }

    private void createGlobalVehicles() {
        firstVehicle = VehicleControllerIT.createEntity(em);
        firstVehicle.setFuelType(firstFuelType);
        firstVehicle.setVehicleType(firstVehicleType);
        firstVehicle.setVehicleModel(firstVehicleModel);
        vehicleRepository.saveAndFlush(firstVehicle);
        secondVehicle = VehicleControllerIT.createSecondEntity(em);
        secondVehicle.setFuelType(secondFuelType);
        secondVehicle.setVehicleType(secondVehicleType);
        secondVehicle.setVehicleModel(secondVehicleModel);
        vehicleRepository.saveAndFlush(secondVehicle);
    }
}
