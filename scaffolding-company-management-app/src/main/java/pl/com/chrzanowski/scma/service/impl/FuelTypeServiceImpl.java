package pl.com.chrzanowski.scma.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.domain.FuelType;
import pl.com.chrzanowski.scma.exception.ObjectNotFoundException;
import pl.com.chrzanowski.scma.repository.FuelTypeRepository;
import pl.com.chrzanowski.scma.service.FuelTypeService;
import pl.com.chrzanowski.scma.service.dto.FuelTypeDTO;
import pl.com.chrzanowski.scma.service.filter.fueltype.FuelTypeFilter;
import pl.com.chrzanowski.scma.service.filter.fueltype.FuelTypeSpecification;
import pl.com.chrzanowski.scma.service.mapper.FuelTypeMapper;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FuelTypeServiceImpl implements FuelTypeService {

    private final Logger log = LoggerFactory.getLogger(FuelTypeServiceImpl.class);
    private final FuelTypeRepository fuelTypeRepository;
    private final FuelTypeMapper fuelTypeMapper;

    private final FuelTypeSpecification fuelTypeSpecification;

    public FuelTypeServiceImpl(FuelTypeRepository fuelTypeRepository,
                               FuelTypeMapper fuelTypeMapper,
                               FuelTypeSpecification fuelTypeSpecification) {
        this.fuelTypeRepository = fuelTypeRepository;
        this.fuelTypeMapper = fuelTypeMapper;
        this.fuelTypeSpecification = fuelTypeSpecification;
    }

    @Override
    public FuelTypeDTO save(FuelTypeDTO fuelTypeDTO) {
        log.debug("Save fuel type: {}", fuelTypeDTO);
        FuelTypeDTO fuelTypeToSave =
                FuelTypeDTO.Builder.builder()
                        .name(fuelTypeDTO.getName())
                        .createDate(setDateTimeIfNotExists(fuelTypeDTO.getCreateDate()))
                        .build();
        FuelType fuelType = fuelTypeRepository.save(fuelTypeMapper.toEntity(fuelTypeToSave));
        return fuelTypeMapper.toDto(fuelType);
    }

    @Override
    public FuelTypeDTO update(FuelTypeDTO fuelTypeDTO) {
        log.debug("Update fuel type: {}", fuelTypeDTO);
        FuelTypeDTO fuelTypeInDB = findById(fuelTypeDTO.getId());
        FuelTypeDTO fuelTypeToUpdate = FuelTypeDTO.Builder.builder()
                .id(fuelTypeDTO.getId())
                .name(fuelTypeDTO.getName())
                .createDate(setDateTimeIfNotExists(fuelTypeInDB.getCreateDate()))
                .modifyDate(setDateTimeIfNotExists(fuelTypeDTO.getModifyDate()))
                .build();
        FuelType fuelType = fuelTypeRepository.save(fuelTypeMapper.toEntity(fuelTypeToUpdate));
        return fuelTypeMapper.toDto(fuelType);
    }

    @Override
    public FuelTypeDTO findById(Long id) {
        log.debug("Find fuel type by id: {}", id);
        Optional<FuelType> fuelTypeOptional = fuelTypeRepository.findById(id);
        return fuelTypeMapper.toDto(fuelTypeOptional.orElseThrow(() -> new ObjectNotFoundException("Fuel type not " +
                "found")));
    }

    @Override
    public List<FuelTypeDTO> findAll() {
        log.debug("Find all fuel types.");
        List<FuelType> fuelTypeList = fuelTypeRepository.findAll();
        return fuelTypeMapper.toDto(fuelTypeList);
    }

    @Override
    public List<FuelTypeDTO> findByFilter(FuelTypeFilter fuelTypeFilter) {
        log.debug("Find all fuel types by filter: {}.", fuelTypeFilter);
        Specification<FuelType> spec = FuelTypeSpecification.builder()
                .fuelTypeFilterAdd(fuelTypeFilter)
                .build();
        return fuelTypeMapper.toDto(fuelTypeRepository.findAll(spec));
    }

    @Override
    public Page<FuelTypeDTO> findByFilterAndPage(FuelTypeFilter fuelTypeFilter, Pageable pageable) {
        log.debug("Find all pageable fuel types by filter: {}.", fuelTypeFilter);
        Specification<FuelType> spec = FuelTypeSpecification.builder()
                .fuelTypeFilterAdd(fuelTypeFilter)
                .build();
        return fuelTypeRepository.findAll(spec, pageable)
                .map(fuelTypeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Delete fuel typ of id: {}", id);
        fuelTypeRepository.deleteFuelTypeById(id);
    }

    private LocalDateTime setDateTimeIfNotExists(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            return localDateTime;
        }
        return LocalDateTime.now();
    }
}
