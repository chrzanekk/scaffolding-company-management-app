package pl.com.chrzanowski.scma.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.domain.FuelType;
import pl.com.chrzanowski.scma.model.FuelTypeDTO;
import pl.com.chrzanowski.scma.repository.FuelTypeRepository;
import pl.com.chrzanowski.scma.service.FuelTypeService;
import pl.com.chrzanowski.scma.service.filter.FuelTypeFilter;
import pl.com.chrzanowski.scma.service.filter.FuelTypeSpecification;
import pl.com.chrzanowski.scma.service.mapper.FuelTypeMapper;

import javax.transaction.Transactional;
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
        FuelType fuelType = fuelTypeRepository.save(fuelTypeMapper.toEntity(fuelTypeDTO));
        return fuelTypeMapper.toDto(fuelType);
    }

    @Override
    public FuelTypeDTO update(FuelTypeDTO fuelTypeDTO) {
        log.debug("Update fuel type: {}", fuelTypeDTO);
        FuelType fuelType = fuelTypeRepository.save(fuelTypeMapper.toEntity(fuelTypeDTO));
        return fuelTypeMapper.toDto(fuelType);
    }

    @Override
    public FuelTypeDTO findById(Long id) {
        log.debug("Find fuel type by id: {}", id);
        Optional<FuelType> fuelTypeOptional = fuelTypeRepository.findById(id);
        return fuelTypeMapper.toDto(fuelTypeOptional.orElseThrow(() -> new IllegalArgumentException("Fuel type not " +
                "found")));
    }

    @Override
    public List<FuelTypeDTO> findAll() {
        log.debug("Find all fuel types.");
        List<FuelType> fuelTypeList = fuelTypeRepository.findAll();
        return fuelTypeMapper.toDto(fuelTypeList);
    }

    @Override
    public List<FuelTypeDTO> find(FuelTypeFilter fuelTypeFilter) {
        log.debug("Find all fuel types by filter {}.", fuelTypeFilter);
        Specification<FuelType> spec = FuelTypeSpecification.builder().fuelTypeFilterAdd(fuelTypeFilter).build();
        return fuelTypeMapper.toDto(fuelTypeRepository.findAll(spec));
    }

    @Override
    public void delete(Long id) {
        log.debug("Delete fuel typ of id: {}", id);
        fuelTypeRepository.deleteFuelTypeById(id);
    }
}
