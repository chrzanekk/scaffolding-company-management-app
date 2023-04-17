package pl.com.chrzanowski.scma.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.domain.VehicleTire;
import pl.com.chrzanowski.scma.exception.ObjectNotFoundException;
import pl.com.chrzanowski.scma.repository.VehicleTireRepository;
import pl.com.chrzanowski.scma.service.VehicleTireService;
import pl.com.chrzanowski.scma.service.dto.VehicleTireDTO;
import pl.com.chrzanowski.scma.service.filter.vehicletire.VehicleTireFilter;
import pl.com.chrzanowski.scma.service.filter.vehicletire.VehicleTireSpecification;
import pl.com.chrzanowski.scma.service.mapper.VehicleTireMapper;
import pl.com.chrzanowski.scma.util.DateTimeUtil;
import pl.com.chrzanowski.scma.util.FieldValidator;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTireServiceImpl implements VehicleTireService {
    private final Logger log = LoggerFactory.getLogger(VehicleTireServiceImpl.class);
    private final VehicleTireRepository vehicleTireRepository;
    private final VehicleTireMapper vehicleTireMapper;
    private final VehicleTireSpecification vehicleTireSpecification;

    public VehicleTireServiceImpl(VehicleTireRepository vehicleTireRepository,
                                  VehicleTireMapper vehicleTireMapper,
                                  VehicleTireSpecification vehicleTireSpecification) {
        this.vehicleTireRepository = vehicleTireRepository;
        this.vehicleTireMapper = vehicleTireMapper;
        this.vehicleTireSpecification = vehicleTireSpecification;
    }

    @Override
    public VehicleTireDTO save(VehicleTireDTO vehicleTireDTO) {
        log.debug("Save vehicle tire: {}", vehicleTireDTO);
        validateVehicleTireDTO(vehicleTireDTO);
        VehicleTireDTO vehicleTireDTOtoSave = VehicleTireDTO.builder()
                .brand(vehicleTireDTO.getBrand())
                .model(vehicleTireDTO.getModel())
                .width(vehicleTireDTO.getWidth())
                .profile(vehicleTireDTO.getProfile())
                .diameter(vehicleTireDTO.getDiameter())
                .tireReinforcedIndex(vehicleTireDTO.getTireReinforcedIndex())
                .speedIndex(vehicleTireDTO.getSpeedIndex())
                .capacityIndex(vehicleTireDTO.getCapacityIndex())
                .tireSeasonType(vehicleTireDTO.getTireSeasonType())
                .runOnFlat(vehicleTireDTO.getRunOnFlat())
                .vehicleId(vehicleTireDTO.getVehicleId())
                .vehicleBrandId(vehicleTireDTO.getVehicleBrandId())
                .vehicleModelId(vehicleTireDTO.getVehicleModelId())
                .vehicleBrandName(vehicleTireDTO.getVehicleBrandName())
                .vehicleModelName(vehicleTireDTO.getVehicleModelName())
                .purchaseDate(vehicleTireDTO.getPurchaseDate())
                .productionYear(vehicleTireDTO.getProductionYear())
                .createDate(DateTimeUtil.setDateTimeIfNotExists(vehicleTireDTO.getCreateDate())).build();
        VehicleTire vehicleTire = vehicleTireRepository.save(vehicleTireMapper.toEntity(vehicleTireDTOtoSave));
        return vehicleTireMapper.toDto(vehicleTire);
    }

    @Override
    public VehicleTireDTO update(VehicleTireDTO vehicleTireDTO) {
        log.debug("Update vehicle tire: {}", vehicleTireDTO);
        validateVehicleTireDTO(vehicleTireDTO);
        FieldValidator.validateObject(vehicleTireDTO.getId(), "id");
        VehicleTireDTO vehicleTireDTOtoUpdate = VehicleTireDTO.builder()
                .brand(vehicleTireDTO.getBrand())
                .model(vehicleTireDTO.getModel())
                .width(vehicleTireDTO.getWidth())
                .profile(vehicleTireDTO.getProfile())
                .diameter(vehicleTireDTO.getDiameter())
                .tireReinforcedIndex(vehicleTireDTO.getTireReinforcedIndex())
                .speedIndex(vehicleTireDTO.getSpeedIndex())
                .capacityIndex(vehicleTireDTO.getCapacityIndex())
                .tireSeasonType(vehicleTireDTO.getTireSeasonType())
                .runOnFlat(vehicleTireDTO.getRunOnFlat())
                .vehicleId(vehicleTireDTO.getVehicleId())
                .vehicleBrandId(vehicleTireDTO.getVehicleBrandId())
                .vehicleModelId(vehicleTireDTO.getVehicleModelId())
                .vehicleBrandName(vehicleTireDTO.getVehicleBrandName())
                .vehicleModelName(vehicleTireDTO.getVehicleModelName())
                .purchaseDate(vehicleTireDTO.getPurchaseDate())
                .productionYear(vehicleTireDTO.getProductionYear())
                .createDate(vehicleTireDTO.getCreateDate())
                .modifyDate(DateTimeUtil.setDateTimeIfNotExists(vehicleTireDTO.getModifyDate())).build();
        VehicleTire vehicleTire = vehicleTireRepository.save(vehicleTireMapper.toEntity(vehicleTireDTOtoUpdate));
        return vehicleTireMapper.toDto(vehicleTire);
    }

    @Override
    public List<VehicleTireDTO> findByFilter(VehicleTireFilter filter) {
        log.debug("Find all vehicle tires by filter: {}", filter);
        Specification<VehicleTire> spec = VehicleTireSpecification.create(filter);
        return vehicleTireMapper.toDto(vehicleTireRepository.findAll(spec));
    }

    @Override
    public Page<VehicleTireDTO> findByFilterAndPage(VehicleTireFilter filter, Pageable pageable) {
        log.debug("Find all vehicle tires by filter and page: {}", filter);
        Specification<VehicleTire> spec = VehicleTireSpecification.create(filter);
        return vehicleTireRepository.findAll(spec,pageable).map(vehicleTireMapper::toDto);
    }

    @Override
    public VehicleTireDTO findById(Long id) {
        log.debug("Find vehicle tire by id: {}",id);
        FieldValidator.validateObject(id, "id");
        Optional<VehicleTire> vehicleTireOptional = vehicleTireRepository.findById(id);
        return vehicleTireMapper.toDto(vehicleTireOptional.orElseThrow(() -> new ObjectNotFoundException("Tire not " +
                "found")));
    }

    @Override
    public List<VehicleTireDTO> findAll() {
        log.debug("Find all vehicle tires.");
        List<VehicleTire> vehicleTireList = vehicleTireRepository.findAll();
        return vehicleTireMapper.toDto(vehicleTireList);
    }

    @Override
    public void delete(Long id) {
        log.debug("De;ete vehicle tire by id: {}", id);
        FieldValidator.validateObject(id, "id");
        vehicleTireRepository.deleteByVehicleTireId(id);
    }


    private void validateVehicleTireDTO(VehicleTireDTO vehicleTireDTO) {
        FieldValidator.validateObject(vehicleTireDTO, "vehicleTireDTO");
        FieldValidator.validateObject(vehicleTireDTO.getVehicleId(), "vehicleId");
        FieldValidator.validateObject(vehicleTireDTO.getVehicleBrandId(), "vehicleBrandId");
        FieldValidator.validateObject(vehicleTireDTO.getVehicleModelId(), "vehicleModelId");
        FieldValidator.validateString(vehicleTireDTO.getBrand(), "brand");
        FieldValidator.validateString(vehicleTireDTO.getModel(), "model");
        FieldValidator.validateObject(vehicleTireDTO.getWidth(), "width");
        FieldValidator.validateObject(vehicleTireDTO.getProfile(), "profile");
        FieldValidator.validateObject(vehicleTireDTO.getDiameter(), "diameter");
        FieldValidator.validateObject(vehicleTireDTO.getType(), "type");
        FieldValidator.validateObject(vehicleTireDTO.getTireReinforcedIndex(), "tireReinforcedIndex");
        FieldValidator.validateObject(vehicleTireDTO.getSpeedIndex(), "speedIndex");
        FieldValidator.validateObject(vehicleTireDTO.getCapacityIndex(), "capacityIndex");
        FieldValidator.validateObject(vehicleTireDTO.getTireSeasonType(), "tireSeasonType");
        FieldValidator.validateObject(vehicleTireDTO.getRunOnFlat(), "runOnFlat");
    }
}
