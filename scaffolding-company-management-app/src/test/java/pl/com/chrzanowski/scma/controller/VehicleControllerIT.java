package pl.com.chrzanowski.scma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import pl.com.chrzanowski.scma.ScaffoldingCompanyManagementAppApplication;
import pl.com.chrzanowski.scma.domain.*;
import pl.com.chrzanowski.scma.repository.VehicleRepository;
import pl.com.chrzanowski.scma.service.VehicleService;
import pl.com.chrzanowski.scma.service.mapper.VehicleMapper;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.LocalDate;

@SpringBootTest(classes = ScaffoldingCompanyManagementAppApplication.class)
@AutoConfigureMockMvc
@WithMockUser
public class VehicleControllerIT {

    private static final String API_PATH = "/api/vehicles";

    private static final LocalDate FIRST_FIRST_REGISTRATION_DATE = LocalDate.of(2002,1,1);
    private static final LocalDate SECOND_FIRST_REGISTRATION_DATE = LocalDate.of(2012,1,1);
    private static final LocalDate UPDATED_FIRST_REGISTRATION_DATE = LocalDate.of(2022,1,1);

    private static final String FIST_REGISTRATION_NUMBER = "AAA-1111";
    private static final String SECOND_REGISTRATION_NUMBER = "BBB-2222";
    private static final String UPDATED_REGISTRATION_NUMBER = "CCC-3333";

    private static final String FIRST_VIN = "111111111111111";
    private static final String SECOND_VIN = "222222222222222";
    private static final String UPDATED_VIN ="333333333333333";
    private static final Short FIRST_PRODUCTION_YEAR = 2021;
    private static final Short SECOND_PRODUCTION_YEAR = 2012;
    private static final Short UPDATED_PRODUCTION_YEAR = 2022;
    private static final Short FIRST_FREE_PLACES_FOR_TECH_INSPECTION = 3;
    private static final Short SECOND_FREE_PLACES_FOR_TECH_INSPECTION = 2;
    private static final Short UPDATED_FREE_PLACES_FOR_TECH_INSPECTION = 1;

    private static final Float FIRST_LENGTH = 2.2f;
    private static final Float SECOND_LENGTH = 2.3f;
    private static final Float UPDATED_LENGTH = 2.4f;
    private static final Float FIRST_WIDTH = 2.0f;
    private static final Float SECOND_WIDTH = 2.1f;
    private static final Float UPDATED_WIDTH = 2.2f;
    private static final Float FIRST_HEIGHT = 1.8f;
    private static final Float SECOND_HEIGHT = 1.9f;
    private static final Float UPDATED_HEIGHT = 2.0f;

    private static final Instant DEFAULT_CREATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant DEFAULT_MODIFY_DATE = Instant.ofEpochMilli(36000L);

    @Autowired
    MockMvc restVehicleMvc;
    @Autowired
    EntityManager em;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    VehicleMapper vehicleMapper;
    @Autowired
    ObjectMapper objectMapper;


    private VehicleBrand firstVehicleBrand;
    private VehicleBrand secondVehicleBrand;
    private VehicleBrand updatedVehicleBrand;
    private VehicleModel firstVehicleModel;
    private VehicleModel secondVehicleModel;
    private VehicleModel updatedVehicleModel;
    private VehicleType firstVehicleType;
    private VehicleType secondVehicleType;
    private VehicleType updatedVehicleType;
    private FuelType firstFuelType;
    private FuelType secondFuelType;
    private FuelType thirdFuelType;

    private Vehicle firstVehicle;
    private Vehicle secondVehicle;
    private Vehicle updatedVehicle;

    public static Vehicle createEntity(EntityManager em) {
        Vehicle vehicle = createFirstBasicVehicle();
        VehicleModel vehicleModel;
        if (TestUtil.findAll(em, VehicleModel.class).isEmpty()) {
            vehicleModel = VehicleModelControllerIT.createEntity(em);
            em.persist(vehicleModel);
            em.flush();
        } else {
            vehicleModel = TestUtil.findAll(em, VehicleModel.class).get(0);
        }
        vehicle.setVehicleModel(vehicleModel);

        VehicleType vehicleType;
        if (TestUtil.findAll(em, VehicleType.class).isEmpty()) {
            vehicleType = VehicleTypeControllerIT.createEntity(em);
            em.persist(vehicleType);
            em.flush();
        } else {
            vehicleType = TestUtil.findAll(em, VehicleType.class).get(0);
        }
        vehicle.setVehicleType(vehicleType);

        FuelType fuelType;
        if (TestUtil.findAll(em, FuelType.class).isEmpty()) {
            fuelType = FuelTypeControllerIT.createEntity(em);
            em.persist(fuelType);
            em.flush();
        } else {
            fuelType = TestUtil.findAll(em, FuelType.class).get(0);
        }
        return vehicle;
    }
    public static Vehicle createSecondEntity(EntityManager em) {
        Vehicle vehicle = createSecondBasicVehicle();
        VehicleModel vehicleModel;
        if (TestUtil.findAll(em, VehicleModel.class).isEmpty()) {
            vehicleModel = VehicleModelControllerIT.createSecondEntity(em);
            em.persist(vehicleModel);
            em.flush();
        } else {
            vehicleModel = TestUtil.findAll(em, VehicleModel.class).get(0);
        }
        vehicle.setVehicleModel(vehicleModel);

        VehicleType vehicleType;
        if (TestUtil.findAll(em, VehicleType.class).isEmpty()) {
            vehicleType = VehicleTypeControllerIT.createSecondEntity(em);
            em.persist(vehicleType);
            em.flush();
        } else {
            vehicleType = TestUtil.findAll(em, VehicleType.class).get(0);
        }
        vehicle.setVehicleType(vehicleType);

        FuelType fuelType;
        if (TestUtil.findAll(em, FuelType.class).isEmpty()) {
            fuelType = FuelTypeControllerIT.createSecondEntity(em);
            em.persist(fuelType);
            em.flush();
        } else {
            fuelType = TestUtil.findAll(em, FuelType.class).get(0);
        }
        return vehicle;
    }

        public static Vehicle createUpdatedEntity(EntityManager em) {
        Vehicle vehicle = createUpdatedBasicVehicle();
        VehicleModel vehicleModel;
        if (TestUtil.findAll(em, VehicleModel.class).isEmpty()) {
            vehicleModel = VehicleModelControllerIT.createUpdatedEntity(em);
            em.persist(vehicleModel);
            em.flush();
        } else {
            vehicleModel = TestUtil.findAll(em, VehicleModel.class).get(0);
        }
        vehicle.setVehicleModel(vehicleModel);

        VehicleType vehicleType;
        if (TestUtil.findAll(em, VehicleType.class).isEmpty()) {
            vehicleType = VehicleTypeControllerIT.createUpdatedEntity(em);
            em.persist(vehicleType);
            em.flush();
        } else {
            vehicleType = TestUtil.findAll(em, VehicleType.class).get(0);
        }
        vehicle.setVehicleType(vehicleType);

        FuelType fuelType;
        if (TestUtil.findAll(em, FuelType.class).isEmpty()) {
            fuelType = FuelTypeControllerIT.createUpdatedEntity(em);
            em.persist(fuelType);
            em.flush();
        } else {
            fuelType = TestUtil.findAll(em, FuelType.class).get(0);
        }
        return vehicle;
    }


    private static Vehicle createFirstBasicVehicle() {
        return new Vehicle()
                .setRegistrationNumber(FIST_REGISTRATION_NUMBER)
                .setVin(FIRST_VIN)
                .setProductionYear(FIRST_PRODUCTION_YEAR)
                .setFirstRegistrationDate(FIRST_FIRST_REGISTRATION_DATE)
                .setFreePlacesForTechInspection(FIRST_FREE_PLACES_FOR_TECH_INSPECTION)
                .setLength(FIRST_LENGTH)
                .setWidth(FIRST_WIDTH)
                .setHeight(FIRST_HEIGHT)
                .setCreateDate(DEFAULT_CREATE_DATE);
    }
    private static Vehicle createSecondBasicVehicle() {
        return new Vehicle()
                .setRegistrationNumber(SECOND_REGISTRATION_NUMBER)
                .setVin(SECOND_VIN)
                .setProductionYear(SECOND_PRODUCTION_YEAR)
                .setFirstRegistrationDate(SECOND_FIRST_REGISTRATION_DATE)
                .setFreePlacesForTechInspection(SECOND_FREE_PLACES_FOR_TECH_INSPECTION)
                .setLength(SECOND_LENGTH)
                .setWidth(SECOND_WIDTH)
                .setHeight(SECOND_HEIGHT)
                .setCreateDate(DEFAULT_CREATE_DATE);
    }
    private static Vehicle createUpdatedBasicVehicle() {
        return new Vehicle()
                .setRegistrationNumber(UPDATED_REGISTRATION_NUMBER)
                .setVin(UPDATED_VIN)
                .setProductionYear(UPDATED_PRODUCTION_YEAR)
                .setFirstRegistrationDate(UPDATED_FIRST_REGISTRATION_DATE)
                .setFreePlacesForTechInspection(UPDATED_FREE_PLACES_FOR_TECH_INSPECTION)
                .setLength(UPDATED_LENGTH)
                .setWidth(UPDATED_WIDTH)
                .setHeight(UPDATED_HEIGHT)
                .setCreateDate(DEFAULT_CREATE_DATE)
                .setModifyDate(DEFAULT_MODIFY_DATE);
    }



}
