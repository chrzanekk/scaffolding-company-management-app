package pl.com.chrzanowski.scma.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.domain.FuelType;
import pl.com.chrzanowski.scma.model.FuelTypeDTO;
import pl.com.chrzanowski.scma.repository.FuelTypeRepository;
import pl.com.chrzanowski.scma.service.FuelTypeService;
import pl.com.chrzanowski.scma.service.filter.FuelTypeCriteria;
import pl.com.chrzanowski.scma.service.filter.basic.QueryService;
import pl.com.chrzanowski.scma.service.mapper.FuelTypeMapper;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FuelTypeServiceImpl extends QueryService<FuelType> implements FuelTypeService{

    private final Logger log = LoggerFactory.getLogger(FuelTypeServiceImpl.class);

    private final FuelTypeRepository fuelTypeRepository;

    private final FuelTypeMapper fuelTypeMapper;

    public FuelTypeServiceImpl(FuelTypeRepository fuelTypeRepository, FuelTypeMapper fuelTypeMapper) {
        this.fuelTypeRepository = fuelTypeRepository;
        this.fuelTypeMapper = fuelTypeMapper;
    }


    @Override
    public List<FuelTypeDTO> find(FuelTypeCriteria fuelTypeFilter) {
        log.debug("Find all fuel types by filter {}.", fuelTypeFilter);

        return fuelTypeMapper.toDto(fuelTypeRepository.findAll());
    }


}
