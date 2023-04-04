package pl.com.chrzanowski.scma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import pl.com.chrzanowski.scma.ScaffoldingCompanyManagementAppApplication;
import pl.com.chrzanowski.scma.domain.*;
import pl.com.chrzanowski.scma.repository.*;
import pl.com.chrzanowski.scma.service.VehicleService;
import pl.com.chrzanowski.scma.service.dto.VehicleDTO;
import pl.com.chrzanowski.scma.service.mapper.VehicleMapper;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = ScaffoldingCompanyManagementAppApplication.class)
@AutoConfigureMockMvc
@WithMockUser
public class VehicleControllerIT {

    private static final String API_PATH = "/api/vehicles";

    private static final LocalDate FIRST_FIRST_REGISTRATION_DATE = LocalDate.of(2002, 1, 1);
    private static final LocalDate SECOND_FIRST_REGISTRATION_DATE = LocalDate.of(2012, 1, 1);
    private static final LocalDate UPDATED_FIRST_REGISTRATION_DATE = LocalDate.of(2022, 1, 1);

    private static final String FIST_REGISTRATION_NUMBER = "AAA-1111";
    private static final String SECOND_REGISTRATION_NUMBER = "BBB-2222";
    private static final String UPDATED_REGISTRATION_NUMBER = "CCC-3333";

    private static final String FIRST_VIN = "111111111111111";
    private static final String SECOND_VIN = "222222222222222";
    private static final String UPDATED_VIN = "333333333333333";
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
    @Autowired
    FuelTypeRepository fuelTypeRepository;
    @Autowired
    VehicleTypeRepository vehicleTypeRepository;
    @Autowired
    VehicleModelRepository vehicleModelRepository;
    @Autowired
    VehicleBrandRepository vehicleBrandRepository;


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
        vehicle.setFuelType(fuelType);
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

    @BeforeEach
    public void initTest() {
        vehicleModelRepository.deleteAll();
        vehicleBrandRepository.deleteAll();
        fuelTypeRepository.deleteAll();
        vehicleTypeRepository.deleteAll();
        firstVehicle = createEntity(em);
        secondVehicle = createSecondEntity(em);
        updatedVehicle = createUpdatedEntity(em);
    }


    @Test
    @Transactional
    public void createVehicle() throws Exception {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();

        FuelType fuelType = allFuelTypes.get(0);
        VehicleModel vehicleModel = allVehicleModels.get(0);
        VehicleType vehicleType = allVehicleTypes.get(0);

        int sizeBeforeTest = allVehicles.size();

        VehicleDTO vehicleDTO = vehicleMapper.toDto(firstVehicle);

        restVehicleMvc.perform(post(API_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(vehicleDTO)))
                .andExpect(status().isOk());

        List<Vehicle> listAfterTest = vehicleRepository.findAll();
        int sizeAfterTest = listAfterTest.size();
        Vehicle savedVehicle = listAfterTest.get(0);
        assertThat(sizeAfterTest).isEqualTo(sizeBeforeTest + 1);
        assertThat(savedVehicle.getVehicleModel().getName()).isEqualTo(vehicleModel.getName());
        assertThat(savedVehicle.getVehicleModel().getVehicleBrand().getName()).isEqualTo(vehicleModel.getVehicleBrand()
                .getName());
        assertThat(savedVehicle.getFuelType().getName()).isEqualTo(fuelType.getName());
        assertThat(savedVehicle.getVehicleType().getName()).isEqualTo(vehicleType.getName());
        assertThat(savedVehicle.getFirstRegistrationDate()).isEqualTo(FIRST_FIRST_REGISTRATION_DATE);
        assertThat(savedVehicle.getFreePlacesForTechInspection()).isEqualTo(FIRST_FREE_PLACES_FOR_TECH_INSPECTION);
        assertThat(savedVehicle.getRegistrationNumber()).isEqualTo(FIST_REGISTRATION_NUMBER);
        assertThat(savedVehicle.getProductionYear()).isEqualTo(FIRST_PRODUCTION_YEAR);
        assertThat(savedVehicle.getHeight()).isEqualTo(FIRST_HEIGHT);
        assertThat(savedVehicle.getVin()).isEqualTo(FIRST_VIN);
        assertThat(savedVehicle.getWidth()).isEqualTo(FIRST_WIDTH);
        assertThat(savedVehicle.getLength()).isEqualTo(FIRST_LENGTH);
    }

    @Test
    @Transactional
    public void createVehicleShouldThrowExceptionForMissingBrandId() throws Exception {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();

        FuelType fuelType = allFuelTypes.get(0);
        VehicleModel vehicleModel = allVehicleModels.get(0);
        VehicleType vehicleType = allVehicleTypes.get(0);

        int sizeBeforeTest = allVehicles.size();

        VehicleDTO vehicleDTO = vehicleMapper.toDto(firstVehicle);
        VehicleDTO vehicleDTOtoSave = VehicleDTO.builder()
                .brandId(null)
                .brandName(vehicleModel.getVehicleBrand().getName())
                .modelId(vehicleModel.getId())
                .modelName(vehicleModel.getName())
                .fuelTypeId(fuelType.getId())
                .fuelTypeName(fuelType.getName())
                .vehicleTypeId(vehicleType.getId())
                .vehicleTypeName(vehicleType.getName())
                .registrationNumber(FIST_REGISTRATION_NUMBER)
                .vin(FIRST_VIN)
                .productionYear(FIRST_PRODUCTION_YEAR)
                .firstRegistrationDate(FIRST_FIRST_REGISTRATION_DATE)
                .freePlacesForTechInspection(FIRST_FREE_PLACES_FOR_TECH_INSPECTION)
                .length(FIRST_LENGTH)
                .width(FIRST_WIDTH)
                .height(FIRST_HEIGHT)
                .createDate(DEFAULT_CREATE_DATE).build();

        restVehicleMvc.perform(post(API_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(vehicleDTOtoSave)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void createVehicleShouldThrowExceptionForMissingBrandName() throws Exception {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();

        FuelType fuelType = allFuelTypes.get(0);
        VehicleModel vehicleModel = allVehicleModels.get(0);
        VehicleType vehicleType = allVehicleTypes.get(0);

        int sizeBeforeTest = allVehicles.size();

        VehicleDTO vehicleDTO = vehicleMapper.toDto(firstVehicle);
        VehicleDTO vehicleDTOtoSave = VehicleDTO.builder()
                .brandId(vehicleModel.getVehicleBrand().getId())
                .brandName(null)
                .modelId(vehicleModel.getId())
                .modelName(vehicleModel.getName())
                .fuelTypeId(fuelType.getId())
                .fuelTypeName(fuelType.getName())
                .vehicleTypeId(vehicleType.getId())
                .vehicleTypeName(vehicleType.getName())
                .registrationNumber(FIST_REGISTRATION_NUMBER)
                .vin(FIRST_VIN)
                .productionYear(FIRST_PRODUCTION_YEAR)
                .firstRegistrationDate(FIRST_FIRST_REGISTRATION_DATE)
                .freePlacesForTechInspection(FIRST_FREE_PLACES_FOR_TECH_INSPECTION)
                .length(FIRST_LENGTH)
                .width(FIRST_WIDTH)
                .height(FIRST_HEIGHT)
                .createDate(DEFAULT_CREATE_DATE).build();

        restVehicleMvc.perform(post(API_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(vehicleDTOtoSave)))
                .andExpect(status().isBadRequest());
    }
    @Test
    @Transactional
    public void createVehicleShouldThrowExceptionForMissingModelId() throws Exception {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();

        FuelType fuelType = allFuelTypes.get(0);
        VehicleModel vehicleModel = allVehicleModels.get(0);
        VehicleType vehicleType = allVehicleTypes.get(0);

        int sizeBeforeTest = allVehicles.size();

        VehicleDTO vehicleDTO = vehicleMapper.toDto(firstVehicle);
        VehicleDTO vehicleDTOtoSave = VehicleDTO.builder()
                .brandId(vehicleModel.getVehicleBrand().getId())
                .brandName(vehicleModel.getVehicleBrand().getName())
                .modelId(null)
                .modelName(vehicleModel.getName())
                .fuelTypeId(fuelType.getId())
                .fuelTypeName(fuelType.getName())
                .vehicleTypeId(vehicleType.getId())
                .vehicleTypeName(vehicleType.getName())
                .registrationNumber(FIST_REGISTRATION_NUMBER)
                .vin(FIRST_VIN)
                .productionYear(FIRST_PRODUCTION_YEAR)
                .firstRegistrationDate(FIRST_FIRST_REGISTRATION_DATE)
                .freePlacesForTechInspection(FIRST_FREE_PLACES_FOR_TECH_INSPECTION)
                .length(FIRST_LENGTH)
                .width(FIRST_WIDTH)
                .height(FIRST_HEIGHT)
                .createDate(DEFAULT_CREATE_DATE).build();

        restVehicleMvc.perform(post(API_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(vehicleDTOtoSave)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    public void createVehicleShouldThrowExceptionForMissingModelName() throws Exception {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();

        FuelType fuelType = allFuelTypes.get(0);
        VehicleModel vehicleModel = allVehicleModels.get(0);
        VehicleType vehicleType = allVehicleTypes.get(0);

        int sizeBeforeTest = allVehicles.size();

        VehicleDTO vehicleDTO = vehicleMapper.toDto(firstVehicle);
        VehicleDTO vehicleDTOtoSave = VehicleDTO.builder()
                .brandId(vehicleModel.getVehicleBrand().getId())
                .brandName(vehicleModel.getVehicleBrand().getName())
                .modelId(vehicleModel.getId())
                .modelName(null)
                .fuelTypeId(fuelType.getId())
                .fuelTypeName(fuelType.getName())
                .vehicleTypeId(vehicleType.getId())
                .vehicleTypeName(vehicleType.getName())
                .registrationNumber(FIST_REGISTRATION_NUMBER)
                .vin(FIRST_VIN)
                .productionYear(FIRST_PRODUCTION_YEAR)
                .firstRegistrationDate(FIRST_FIRST_REGISTRATION_DATE)
                .freePlacesForTechInspection(FIRST_FREE_PLACES_FOR_TECH_INSPECTION)
                .length(FIRST_LENGTH)
                .width(FIRST_WIDTH)
                .height(FIRST_HEIGHT)
                .createDate(DEFAULT_CREATE_DATE).build();

        restVehicleMvc.perform(post(API_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(vehicleDTOtoSave)))
                .andExpect(status().isBadRequest());
    }


    @Test
    @Transactional
    public void createVehicleShouldThrowExceptionForMissingFuelTypeId() throws Exception {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();

        FuelType fuelType = allFuelTypes.get(0);
        VehicleModel vehicleModel = allVehicleModels.get(0);
        VehicleType vehicleType = allVehicleTypes.get(0);

        int sizeBeforeTest = allVehicles.size();

        VehicleDTO vehicleDTO = vehicleMapper.toDto(firstVehicle);
        VehicleDTO vehicleDTOtoSave = VehicleDTO.builder()
                .brandId(vehicleModel.getVehicleBrand().getId())
                .brandName(vehicleModel.getVehicleBrand().getName())
                .modelId(vehicleModel.getId())
                .modelName(vehicleModel.getName())
                .fuelTypeId(null)
                .fuelTypeName(fuelType.getName())
                .vehicleTypeId(vehicleType.getId())
                .vehicleTypeName(vehicleType.getName())
                .registrationNumber(FIST_REGISTRATION_NUMBER)
                .vin(FIRST_VIN)
                .productionYear(FIRST_PRODUCTION_YEAR)
                .firstRegistrationDate(FIRST_FIRST_REGISTRATION_DATE)
                .freePlacesForTechInspection(FIRST_FREE_PLACES_FOR_TECH_INSPECTION)
                .length(FIRST_LENGTH)
                .width(FIRST_WIDTH)
                .height(FIRST_HEIGHT)
                .createDate(DEFAULT_CREATE_DATE).build();

        restVehicleMvc.perform(post(API_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(vehicleDTOtoSave)))
                .andExpect(status().isBadRequest());
    }


    @Test
    @Transactional
    public void createVehicleShouldThrowExceptionForMissingFuelTypeName() throws Exception {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();

        FuelType fuelType = allFuelTypes.get(0);
        VehicleModel vehicleModel = allVehicleModels.get(0);
        VehicleType vehicleType = allVehicleTypes.get(0);

        int sizeBeforeTest = allVehicles.size();

        VehicleDTO vehicleDTO = vehicleMapper.toDto(firstVehicle);
        VehicleDTO vehicleDTOtoSave = VehicleDTO.builder()
                .brandId(vehicleModel.getVehicleBrand().getId())
                .brandName(vehicleModel.getVehicleBrand().getName())
                .modelId(vehicleModel.getId())
                .modelName(vehicleModel.getName())
                .fuelTypeId(fuelType.getId())
                .fuelTypeName(null)
                .vehicleTypeId(vehicleType.getId())
                .vehicleTypeName(vehicleType.getName())
                .registrationNumber(FIST_REGISTRATION_NUMBER)
                .vin(FIRST_VIN)
                .productionYear(FIRST_PRODUCTION_YEAR)
                .firstRegistrationDate(FIRST_FIRST_REGISTRATION_DATE)
                .freePlacesForTechInspection(FIRST_FREE_PLACES_FOR_TECH_INSPECTION)
                .length(FIRST_LENGTH)
                .width(FIRST_WIDTH)
                .height(FIRST_HEIGHT)
                .createDate(DEFAULT_CREATE_DATE).build();

        restVehicleMvc.perform(post(API_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(vehicleDTOtoSave)))
                .andExpect(status().isBadRequest());
    }


    @Test
    @Transactional
    public void createVehicleShouldThrowExceptionForMissingVehicleTypeId() throws Exception {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();

        FuelType fuelType = allFuelTypes.get(0);
        VehicleModel vehicleModel = allVehicleModels.get(0);
        VehicleType vehicleType = allVehicleTypes.get(0);

        int sizeBeforeTest = allVehicles.size();

        VehicleDTO vehicleDTO = vehicleMapper.toDto(firstVehicle);
        VehicleDTO vehicleDTOtoSave = VehicleDTO.builder()
                .brandId(vehicleModel.getVehicleBrand().getId())
                .brandName(vehicleModel.getVehicleBrand().getName())
                .modelId(vehicleModel.getId())
                .modelName(vehicleModel.getName())
                .fuelTypeId(fuelType.getId())
                .fuelTypeName(fuelType.getName())
                .vehicleTypeId(null)
                .vehicleTypeName(vehicleType.getName())
                .registrationNumber(FIST_REGISTRATION_NUMBER)
                .vin(FIRST_VIN)
                .productionYear(FIRST_PRODUCTION_YEAR)
                .firstRegistrationDate(FIRST_FIRST_REGISTRATION_DATE)
                .freePlacesForTechInspection(FIRST_FREE_PLACES_FOR_TECH_INSPECTION)
                .length(FIRST_LENGTH)
                .width(FIRST_WIDTH)
                .height(FIRST_HEIGHT)
                .createDate(DEFAULT_CREATE_DATE).build();

        restVehicleMvc.perform(post(API_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(vehicleDTOtoSave)))
                .andExpect(status().isBadRequest());
    }



    @Test
    @Transactional
    public void createVehicleShouldThrowExceptionForMissingVehicleTypeName() throws Exception {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();

        FuelType fuelType = allFuelTypes.get(0);
        VehicleModel vehicleModel = allVehicleModels.get(0);
        VehicleType vehicleType = allVehicleTypes.get(0);

        int sizeBeforeTest = allVehicles.size();

        VehicleDTO vehicleDTO = vehicleMapper.toDto(firstVehicle);
        VehicleDTO vehicleDTOtoSave = VehicleDTO.builder()
                .brandId(vehicleModel.getVehicleBrand().getId())
                .brandName(vehicleModel.getVehicleBrand().getName())
                .modelId(vehicleModel.getId())
                .modelName(vehicleModel.getName())
                .fuelTypeId(fuelType.getId())
                .fuelTypeName(fuelType.getName())
                .vehicleTypeId(vehicleType.getId())
                .vehicleTypeName(null)
                .registrationNumber(FIST_REGISTRATION_NUMBER)
                .vin(FIRST_VIN)
                .productionYear(FIRST_PRODUCTION_YEAR)
                .firstRegistrationDate(FIRST_FIRST_REGISTRATION_DATE)
                .freePlacesForTechInspection(FIRST_FREE_PLACES_FOR_TECH_INSPECTION)
                .length(FIRST_LENGTH)
                .width(FIRST_WIDTH)
                .height(FIRST_HEIGHT)
                .createDate(DEFAULT_CREATE_DATE).build();

        restVehicleMvc.perform(post(API_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(vehicleDTOtoSave)))
                .andExpect(status().isBadRequest());
    }



    @Test
    @Transactional
    public void createVehicleShouldThrowExceptionForMissingRegistrationNumber() throws Exception {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();

        FuelType fuelType = allFuelTypes.get(0);
        VehicleModel vehicleModel = allVehicleModels.get(0);
        VehicleType vehicleType = allVehicleTypes.get(0);

        int sizeBeforeTest = allVehicles.size();

        VehicleDTO vehicleDTO = vehicleMapper.toDto(firstVehicle);
        VehicleDTO vehicleDTOtoSave = VehicleDTO.builder()
                .brandId(vehicleModel.getVehicleBrand().getId())
                .brandName(vehicleModel.getVehicleBrand().getName())
                .modelId(vehicleModel.getId())
                .modelName(vehicleModel.getName())
                .fuelTypeId(fuelType.getId())
                .fuelTypeName(fuelType.getName())
                .vehicleTypeId(vehicleType.getId())
                .vehicleTypeName(vehicleType.getName())
                .registrationNumber(null)
                .vin(FIRST_VIN)
                .productionYear(FIRST_PRODUCTION_YEAR)
                .firstRegistrationDate(FIRST_FIRST_REGISTRATION_DATE)
                .freePlacesForTechInspection(FIRST_FREE_PLACES_FOR_TECH_INSPECTION)
                .length(FIRST_LENGTH)
                .width(FIRST_WIDTH)
                .height(FIRST_HEIGHT)
                .createDate(DEFAULT_CREATE_DATE).build();

        restVehicleMvc.perform(post(API_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(vehicleDTOtoSave)))
                .andExpect(status().isBadRequest());
    }


    @Test
    @Transactional
    public void createVehicleShouldThrowExceptionForMissingVIN() throws Exception {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();

        FuelType fuelType = allFuelTypes.get(0);
        VehicleModel vehicleModel = allVehicleModels.get(0);
        VehicleType vehicleType = allVehicleTypes.get(0);

        int sizeBeforeTest = allVehicles.size();

        VehicleDTO vehicleDTO = vehicleMapper.toDto(firstVehicle);
        VehicleDTO vehicleDTOtoSave = VehicleDTO.builder()
                .brandId(vehicleModel.getVehicleBrand().getId())
                .brandName(vehicleModel.getVehicleBrand().getName())
                .modelId(vehicleModel.getId())
                .modelName(vehicleModel.getName())
                .fuelTypeId(fuelType.getId())
                .fuelTypeName(fuelType.getName())
                .vehicleTypeId(vehicleType.getId())
                .vehicleTypeName(vehicleType.getName())
                .registrationNumber(FIST_REGISTRATION_NUMBER)
                .vin(null)
                .productionYear(FIRST_PRODUCTION_YEAR)
                .firstRegistrationDate(FIRST_FIRST_REGISTRATION_DATE)
                .freePlacesForTechInspection(FIRST_FREE_PLACES_FOR_TECH_INSPECTION)
                .length(FIRST_LENGTH)
                .width(FIRST_WIDTH)
                .height(FIRST_HEIGHT)
                .createDate(DEFAULT_CREATE_DATE).build();

        restVehicleMvc.perform(post(API_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(vehicleDTOtoSave)))
                .andExpect(status().isBadRequest());
    }



    @Test
    @Transactional
    public void createVehicleShouldThrowExceptionForMissingProductionYear() throws Exception {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();

        FuelType fuelType = allFuelTypes.get(0);
        VehicleModel vehicleModel = allVehicleModels.get(0);
        VehicleType vehicleType = allVehicleTypes.get(0);

        int sizeBeforeTest = allVehicles.size();

        VehicleDTO vehicleDTO = vehicleMapper.toDto(firstVehicle);
        VehicleDTO vehicleDTOtoSave = VehicleDTO.builder()
                .brandId(vehicleModel.getVehicleBrand().getId())
                .brandName(vehicleModel.getVehicleBrand().getName())
                .modelId(vehicleModel.getId())
                .modelName(vehicleModel.getName())
                .fuelTypeId(fuelType.getId())
                .fuelTypeName(fuelType.getName())
                .vehicleTypeId(vehicleType.getId())
                .vehicleTypeName(vehicleType.getName())
                .registrationNumber(FIST_REGISTRATION_NUMBER)
                .vin(FIRST_VIN)
                .productionYear(null)
                .firstRegistrationDate(FIRST_FIRST_REGISTRATION_DATE)
                .freePlacesForTechInspection(FIRST_FREE_PLACES_FOR_TECH_INSPECTION)
                .length(FIRST_LENGTH)
                .width(FIRST_WIDTH)
                .height(FIRST_HEIGHT)
                .createDate(DEFAULT_CREATE_DATE).build();

        restVehicleMvc.perform(post(API_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(vehicleDTOtoSave)))
                .andExpect(status().isBadRequest());
    }


    @Test
    @Transactional
    public void createVehicleShouldThrowExceptionForMissingRegistrationDate() throws Exception {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();

        FuelType fuelType = allFuelTypes.get(0);
        VehicleModel vehicleModel = allVehicleModels.get(0);
        VehicleType vehicleType = allVehicleTypes.get(0);

        int sizeBeforeTest = allVehicles.size();

        VehicleDTO vehicleDTO = vehicleMapper.toDto(firstVehicle);
        VehicleDTO vehicleDTOtoSave = VehicleDTO.builder()
                .brandId(vehicleModel.getVehicleBrand().getId())
                .brandName(vehicleModel.getVehicleBrand().getName())
                .modelId(vehicleModel.getId())
                .modelName(vehicleModel.getName())
                .fuelTypeId(fuelType.getId())
                .fuelTypeName(fuelType.getName())
                .vehicleTypeId(vehicleType.getId())
                .vehicleTypeName(vehicleType.getName())
                .registrationNumber(FIST_REGISTRATION_NUMBER)
                .vin(FIRST_VIN)
                .productionYear(FIRST_PRODUCTION_YEAR)
                .firstRegistrationDate(null)
                .freePlacesForTechInspection(FIRST_FREE_PLACES_FOR_TECH_INSPECTION)
                .length(FIRST_LENGTH)
                .width(FIRST_WIDTH)
                .height(FIRST_HEIGHT)
                .createDate(DEFAULT_CREATE_DATE).build();

        restVehicleMvc.perform(post(API_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(vehicleDTOtoSave)))
                .andExpect(status().isBadRequest());
    }


    @Test
    @Transactional
    public void createVehicleShouldThrowExceptionForMissingFreePlacecForTechInspection() throws Exception {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();

        FuelType fuelType = allFuelTypes.get(0);
        VehicleModel vehicleModel = allVehicleModels.get(0);
        VehicleType vehicleType = allVehicleTypes.get(0);

        int sizeBeforeTest = allVehicles.size();

        VehicleDTO vehicleDTO = vehicleMapper.toDto(firstVehicle);
        VehicleDTO vehicleDTOtoSave = VehicleDTO.builder()
                .brandId(vehicleModel.getVehicleBrand().getId())
                .brandName(vehicleModel.getVehicleBrand().getName())
                .modelId(vehicleModel.getId())
                .modelName(vehicleModel.getName())
                .fuelTypeId(fuelType.getId())
                .fuelTypeName(fuelType.getName())
                .vehicleTypeId(vehicleType.getId())
                .vehicleTypeName(vehicleType.getName())
                .registrationNumber(FIST_REGISTRATION_NUMBER)
                .vin(FIRST_VIN)
                .productionYear(FIRST_PRODUCTION_YEAR)
                .firstRegistrationDate(FIRST_FIRST_REGISTRATION_DATE)
                .freePlacesForTechInspection(null)
                .length(FIRST_LENGTH)
                .width(FIRST_WIDTH)
                .height(FIRST_HEIGHT)
                .createDate(DEFAULT_CREATE_DATE).build();

        restVehicleMvc.perform(post(API_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(vehicleDTOtoSave)))
                .andExpect(status().isBadRequest());
    }


    @Test
    @Transactional
    public void createVehicleShouldThrowExceptionForMissingLength() throws Exception {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();

        FuelType fuelType = allFuelTypes.get(0);
        VehicleModel vehicleModel = allVehicleModels.get(0);
        VehicleType vehicleType = allVehicleTypes.get(0);

        int sizeBeforeTest = allVehicles.size();

        VehicleDTO vehicleDTO = vehicleMapper.toDto(firstVehicle);
        VehicleDTO vehicleDTOtoSave = VehicleDTO.builder()
                .brandId(vehicleModel.getVehicleBrand().getId())
                .brandName(vehicleModel.getVehicleBrand().getName())
                .modelId(vehicleModel.getId())
                .modelName(vehicleModel.getName())
                .fuelTypeId(fuelType.getId())
                .fuelTypeName(fuelType.getName())
                .vehicleTypeId(vehicleType.getId())
                .vehicleTypeName(vehicleType.getName())
                .registrationNumber(FIST_REGISTRATION_NUMBER)
                .vin(FIRST_VIN)
                .productionYear(FIRST_PRODUCTION_YEAR)
                .firstRegistrationDate(FIRST_FIRST_REGISTRATION_DATE)
                .freePlacesForTechInspection(FIRST_FREE_PLACES_FOR_TECH_INSPECTION)
                .length(null)
                .width(FIRST_WIDTH)
                .height(FIRST_HEIGHT)
                .createDate(DEFAULT_CREATE_DATE).build();

        restVehicleMvc.perform(post(API_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(vehicleDTOtoSave)))
                .andExpect(status().isBadRequest());
    }


    @Test
    @Transactional
    public void createVehicleShouldThrowExceptionForMissingHeight() throws Exception {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();

        FuelType fuelType = allFuelTypes.get(0);
        VehicleModel vehicleModel = allVehicleModels.get(0);
        VehicleType vehicleType = allVehicleTypes.get(0);

        int sizeBeforeTest = allVehicles.size();

        VehicleDTO vehicleDTO = vehicleMapper.toDto(firstVehicle);
        VehicleDTO vehicleDTOtoSave = VehicleDTO.builder()
                .brandId(vehicleModel.getVehicleBrand().getId())
                .brandName(vehicleModel.getVehicleBrand().getName())
                .modelId(vehicleModel.getId())
                .modelName(vehicleModel.getName())
                .fuelTypeId(fuelType.getId())
                .fuelTypeName(fuelType.getName())
                .vehicleTypeId(vehicleType.getId())
                .vehicleTypeName(vehicleType.getName())
                .registrationNumber(FIST_REGISTRATION_NUMBER)
                .vin(FIRST_VIN)
                .productionYear(FIRST_PRODUCTION_YEAR)
                .firstRegistrationDate(FIRST_FIRST_REGISTRATION_DATE)
                .freePlacesForTechInspection(FIRST_FREE_PLACES_FOR_TECH_INSPECTION)
                .length(FIRST_LENGTH)
                .width(FIRST_WIDTH)
                .height(null)
                .createDate(DEFAULT_CREATE_DATE).build();

        restVehicleMvc.perform(post(API_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(vehicleDTOtoSave)))
                .andExpect(status().isBadRequest());
    }


    @Test
    @Transactional
    public void createVehicleShouldThrowExceptionForMissingWidth() throws Exception {

        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<FuelType> allFuelTypes = fuelTypeRepository.findAll();
        List<VehicleModel> allVehicleModels = vehicleModelRepository.findAll();
        List<VehicleType> allVehicleTypes = vehicleTypeRepository.findAll();

        FuelType fuelType = allFuelTypes.get(0);
        VehicleModel vehicleModel = allVehicleModels.get(0);
        VehicleType vehicleType = allVehicleTypes.get(0);

        int sizeBeforeTest = allVehicles.size();

        VehicleDTO vehicleDTO = vehicleMapper.toDto(firstVehicle);
        VehicleDTO vehicleDTOtoSave = VehicleDTO.builder()
                .brandId(vehicleModel.getVehicleBrand().getId())
                .brandName(vehicleModel.getVehicleBrand().getName())
                .modelId(vehicleModel.getId())
                .modelName(vehicleModel.getName())
                .fuelTypeId(fuelType.getId())
                .fuelTypeName(fuelType.getName())
                .vehicleTypeId(vehicleType.getId())
                .vehicleTypeName(vehicleType.getName())
                .registrationNumber(FIST_REGISTRATION_NUMBER)
                .vin(FIRST_VIN)
                .productionYear(FIRST_PRODUCTION_YEAR)
                .firstRegistrationDate(FIRST_FIRST_REGISTRATION_DATE)
                .freePlacesForTechInspection(FIRST_FREE_PLACES_FOR_TECH_INSPECTION)
                .length(FIRST_LENGTH)
                .width(null)
                .height(FIRST_HEIGHT)
                .createDate(DEFAULT_CREATE_DATE).build();

        restVehicleMvc.perform(post(API_PATH + "/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.convertObjectToJsonBytes(vehicleDTOtoSave)))
                .andExpect(status().isBadRequest());
    }


    @Test
    @Transactional
    public void createVehicleShouldThrowBadRequestForNull() throws Exception {
        restVehicleMvc.perform(post(API_PATH + "/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(null))).andExpect(status().isBadRequest());
    }

    private void defaultWorkshopShouldBeFound(String filter) throws Exception {
        restVehicleMvc.perform(get(API_PATH + "/?sort=id,desc&" + filter)).andExpect(status().isOk())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.[*].id").value(firstVehicle.getId().intValue()))
                .andExpect(jsonPath("$.[*].registrationNumber").value(firstVehicle.getRegistrationNumber()))
                .andExpect(jsonPath("$.[*].vin").value(firstVehicle.getVin()))
                .andExpect(jsonPath("$.[*].productionYear").value(firstVehicle.getProductionYear().toString()))
                .andExpect(jsonPath("$.[*].firstRegistrationDate").value(firstVehicle.getFirstRegistrationDate()
                        .toString()))
                .andExpect(jsonPath("$.[*].freePlacesForTechInspection").value(firstVehicle.getFreePlacesForTechInspection()
                        .toString()))
                .andExpect(jsonPath("$.[*].length").value(firstVehicle.getLength().toString()))
                .andExpect(jsonPath("$.[*].width").value(firstVehicle.getWidth().toString()))
                .andExpect(jsonPath("$.[*].height").value(firstVehicle.getHeight().toString()))
                .andExpect(jsonPath("$.[*].brandId").value(firstVehicle.getVehicleModel().getVehicleBrand().getId()))
                .andExpect(jsonPath("$.[*].brandName").value(firstVehicle.getVehicleModel().getVehicleBrand()
                        .getName()))
                .andExpect(jsonPath("$.[*].modelId").value(firstVehicle.getVehicleModel().getId()))
                .andExpect(jsonPath("$.[*].modelName").value(firstVehicle.getVehicleModel().getName()))
                .andExpect(jsonPath("$.[*].fuelTypeId").value(firstVehicle.getFuelType().getId()))
                .andExpect(jsonPath("$.[*].fuelTypeName").value(firstVehicle.getFuelType().getName()))
                .andExpect(jsonPath("$.[*].vehicleTypeId").value(firstVehicle.getVehicleType().getId()))
                .andExpect(jsonPath("$.[*].vehicleTypeName").value(firstVehicle.getVehicleType().getName()))
                .andExpect(jsonPath("$.[*].createDate").value(DEFAULT_CREATE_DATE.toString()));
    }

    private void defaultWorkshopShouldNotBeFound(String filter) throws Exception {
        restVehicleMvc.perform(get(API_PATH + "/?sort=id,desc&" + filter)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    private void createGlobalFuelTypes() {
        firstFuelType = FuelTypeControllerIT.createEntity(em);
        em.persist(firstFuelType);
        em.flush();

        secondFuelType = FuelTypeControllerIT.createSecondEntity(em);
        em.persist(secondFuelType);
        em.flush();
    }

    private void createGlobalVehicleTypes() {
        firstVehicleType = VehicleTypeControllerIT.createEntity(em);
        em.persist(firstVehicleType);
        em.flush();
        secondVehicleType = VehicleTypeControllerIT.createSecondEntity(em);
        em.persist(secondVehicleType);
        em.flush();
    }

    private void createGlobalVehicleModels() {
        firstVehicleModel = VehicleModelControllerIT.createEntity(em);
        firstVehicleModel.setId(null);
        em.persist(firstVehicleModel);
        em.flush();
        secondVehicleModel = VehicleModelControllerIT.createSecondEntity(em);
        secondVehicleModel.setId(null);
        em.persist(secondVehicleModel);
        em.flush();
    }

    private void createAllDefaultData() {
        createGlobalVehicleModels();
        createGlobalVehicleTypes();
        createGlobalFuelTypes();
    }


}
