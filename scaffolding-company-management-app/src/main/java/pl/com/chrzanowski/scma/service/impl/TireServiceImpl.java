package pl.com.chrzanowski.scma.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.domain.Tire;
import pl.com.chrzanowski.scma.exception.ObjectNotFoundException;
import pl.com.chrzanowski.scma.repository.TireRepository;
import pl.com.chrzanowski.scma.service.TireService;
import pl.com.chrzanowski.scma.service.dto.TireDTO;
import pl.com.chrzanowski.scma.service.filter.tire.TireFilter;
import pl.com.chrzanowski.scma.service.filter.tire.TireSpecification;
import pl.com.chrzanowski.scma.service.mapper.TireMapper;
import pl.com.chrzanowski.scma.util.DateTimeUtil;
import pl.com.chrzanowski.scma.util.FieldValidator;

import java.util.List;
import java.util.Optional;

@Service
public class TireServiceImpl implements TireService {
    private final Logger log = LoggerFactory.getLogger(TireServiceImpl.class);
    private final TireRepository tireRepository;
    private final TireMapper tireMapper;
    private final TireSpecification tireSpecification;

    public TireServiceImpl(TireRepository tireRepository,
                           TireMapper tireMapper,
                           TireSpecification tireSpecification) {
        this.tireRepository = tireRepository;
        this.tireMapper = tireMapper;
        this.tireSpecification = tireSpecification;
    }

    @Override
    public TireDTO save(TireDTO tireDTO) {
        log.debug("Save tire: {}", tireDTO);
        validateTireDTO(tireDTO);
        TireDTO tireDTOtoSave = TireDTO.builder()
                .brand(tireDTO.getBrand())
                .model(tireDTO.getModel())
                .width(tireDTO.getWidth())
                .profile(tireDTO.getProfile())
                .diameter(tireDTO.getDiameter())
                .tireReinforcedIndex(tireDTO.getTireReinforcedIndex())
                .speedIndex(tireDTO.getSpeedIndex())
                .capacityIndex(tireDTO.getCapacityIndex())
                .tireSeasonType(tireDTO.getTireSeasonType())
                .type(tireDTO.getType())
                .runOnFlat(tireDTO.getRunOnFlat())
                .productionYear(tireDTO.getProductionYear())
                .purchaseDate(tireDTO.getPurchaseDate())
                .tireStatus(tireDTO.getTireStatus())
                .vehicleId(tireDTO.getVehicleId())
                .createDate(DateTimeUtil.setDateTimeIfNotExists(tireDTO.getCreateDate())).build();
        Tire tireToSave = tireMapper.toEntity(tireDTOtoSave);
        Tire tire = tireRepository.save(tireToSave);
        return tireMapper.toDto(tire);
    }

    @Override
    public TireDTO update(TireDTO tireDTO) {
        log.debug("Update tire: {}", tireDTO);
        validateTireDTO(tireDTO);
        FieldValidator.validateObject(tireDTO.getId(), "id");
        TireDTO tireDTOtoUpdate = TireDTO.builder()
                .id(tireDTO.getId())
                .brand(tireDTO.getBrand())
                .model(tireDTO.getModel())
                .width(tireDTO.getWidth())
                .profile(tireDTO.getProfile())
                .diameter(tireDTO.getDiameter())
                .tireReinforcedIndex(tireDTO.getTireReinforcedIndex())
                .speedIndex(tireDTO.getSpeedIndex())
                .capacityIndex(tireDTO.getCapacityIndex())
                .tireSeasonType(tireDTO.getTireSeasonType())
                .type(tireDTO.getType())
                .runOnFlat(tireDTO.getRunOnFlat())
                .productionYear(tireDTO.getProductionYear())
                .purchaseDate(tireDTO.getPurchaseDate())
                .tireStatus(tireDTO.getTireStatus())
                .vehicleId(tireDTO.getVehicleId())
                .createDate(tireDTO.getCreateDate())
                .modifyDate(DateTimeUtil.setDateTimeIfNotExists(tireDTO.getModifyDate())).build();
        Tire tire = tireRepository.save(tireMapper.toEntity(tireDTOtoUpdate));
        return tireMapper.toDto(tire);
    }

    @Override
    public List<TireDTO> findByFilter(TireFilter filter) {
        log.debug("Find all tires by filter: {}", filter);
        Specification<Tire> spec = TireSpecification.create(filter);
        return tireMapper.toDto(tireRepository.findAll(spec));
    }

    @Override
    public Page<TireDTO> findByFilterAndPage(TireFilter filter, Pageable pageable) {
        log.debug("Find all tires by filter and page: {}", filter);
        Specification<Tire> spec = TireSpecification.create(filter);
        return tireRepository.findAll(spec,pageable).map(tireMapper::toDto);
    }

    @Override
    public TireDTO findById(Long id) {
        log.debug("Find tire by id: {}",id);
        FieldValidator.validateObject(id, "id");
        Optional<Tire> vehicleTireOptional = tireRepository.findById(id);
        return tireMapper.toDto(vehicleTireOptional.orElseThrow(() -> new ObjectNotFoundException("Tire not " +
                "found")));
    }

    @Override
    public List<TireDTO> findAll() {
        log.debug("Find all tires.");
        List<Tire> tireList = tireRepository.findAll();
        return tireMapper.toDto(tireList);
    }

    @Override
    public void delete(Long id) {
        log.debug("De;ete tire by id: {}", id);
        FieldValidator.validateObject(id, "id");
        tireRepository.deleteTireById(id);
    }


    private void validateTireDTO(TireDTO tireDTO) {
        FieldValidator.validateObject(tireDTO, "vehicleTireDTO");
        FieldValidator.validateString(tireDTO.getBrand(), "brand");
        FieldValidator.validateString(tireDTO.getModel(), "model");
        FieldValidator.validateObject(tireDTO.getWidth(), "width");
        FieldValidator.validateObject(tireDTO.getProfile(), "profile");
        FieldValidator.validateObject(tireDTO.getDiameter(), "diameter");
        FieldValidator.validateObject(tireDTO.getType(), "type");
        FieldValidator.validateObject(tireDTO.getTireReinforcedIndex(), "tireReinforcedIndex");
        FieldValidator.validateObject(tireDTO.getSpeedIndex(), "speedIndex");
        FieldValidator.validateObject(tireDTO.getCapacityIndex(), "capacityIndex");
        FieldValidator.validateObject(tireDTO.getTireSeasonType(), "tireSeasonType");
        FieldValidator.validateObject(tireDTO.getRunOnFlat(), "runOnFlat");
        FieldValidator.validateObject(tireDTO.getProductionYear(), "productionYear");
        FieldValidator.validateObject(tireDTO.getPurchaseDate(), "purchaseDate");
        FieldValidator.validateObject(tireDTO.getTireStatus(), "tireStatus");
        FieldValidator.validateObject(tireDTO.getVehicleId(), "vehicleId");
    }
}
