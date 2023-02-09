package pl.com.chrzanowski.scma.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.domain.ServiceActionType;
import pl.com.chrzanowski.scma.exception.ObjectNotFoundException;
import pl.com.chrzanowski.scma.repository.ServiceActionTypeRepository;
import pl.com.chrzanowski.scma.service.ServiceActionTypeService;
import pl.com.chrzanowski.scma.service.dto.ServiceActionTypeDTO;
import pl.com.chrzanowski.scma.service.filter.serviceactiontype.ServiceActionTypeFilter;
import pl.com.chrzanowski.scma.service.filter.serviceactiontype.ServiceActionTypeSpecification;
import pl.com.chrzanowski.scma.service.mapper.ServiceActionTypeMapper;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceActionTypeServiceImpl implements ServiceActionTypeService {

    private final Logger log = LoggerFactory.getLogger(ServiceActionTypeServiceImpl.class);
    private final ServiceActionTypeRepository serviceActionTypeRepository;
    private final ServiceActionTypeMapper serviceActionTypeMapper;
    private final ServiceActionTypeSpecification serviceActionTypeSpecification;

    public ServiceActionTypeServiceImpl(ServiceActionTypeRepository serviceActionTypeRepository,
                                        ServiceActionTypeMapper serviceActionTypeMapper,
                                        ServiceActionTypeSpecification serviceActionTypeSpecification) {
        this.serviceActionTypeRepository = serviceActionTypeRepository;
        this.serviceActionTypeMapper = serviceActionTypeMapper;
        this.serviceActionTypeSpecification = serviceActionTypeSpecification;
    }

    @Override
    public ServiceActionTypeDTO save(ServiceActionTypeDTO serviceActionTypeDTO) {
        log.debug("Save service action type: {}", serviceActionTypeDTO);
        ServiceActionType serviceActionType =
                serviceActionTypeRepository.save(serviceActionTypeMapper.toEntity(serviceActionTypeDTO));
        return serviceActionTypeMapper.toDto(serviceActionType);
    }

    @Override
    public ServiceActionTypeDTO update(ServiceActionTypeDTO serviceActionTypeDTO) {
        log.debug("Update service action type: {}", serviceActionTypeDTO);
        ServiceActionType serviceActionType =
                serviceActionTypeRepository.save(serviceActionTypeMapper.toEntity(serviceActionTypeDTO));
        return serviceActionTypeMapper.toDto(serviceActionType);
    }

    @Override
    public List<ServiceActionTypeDTO> findByFilter(ServiceActionTypeFilter serviceActionTypeFilter) {
        log.debug("Find service action type by filter: {}", serviceActionTypeFilter);
        Specification<ServiceActionType> spec =
                ServiceActionTypeSpecification.builder().serviceActionTypeFilter(serviceActionTypeFilter).build();
        return serviceActionTypeMapper.toDto(serviceActionTypeRepository.findAll(spec));
    }

    @Override
    public Page<ServiceActionTypeDTO> findByFilterAndPage(ServiceActionTypeFilter serviceActionTypeFilter,
                                                          Pageable pageable) {
        log.debug("Find service action type by filter: {}", serviceActionTypeFilter);
        Specification<ServiceActionType> spec =
                ServiceActionTypeSpecification.builder().serviceActionTypeFilter(serviceActionTypeFilter).build();
        return serviceActionTypeRepository.findAll(spec, pageable).map(serviceActionTypeMapper::toDto);
    }

    @Override
    public ServiceActionTypeDTO findById(Long id) {
        log.debug("Find service action type by id: {}", id);
        Optional<ServiceActionType> serviceActionType = serviceActionTypeRepository.findById(id);
        return serviceActionTypeMapper.toDto(serviceActionType.orElseThrow(()-> new ObjectNotFoundException(" " +
                "Service action type not found")));
    }

    @Override
    public List<ServiceActionTypeDTO> findAll() {
        log.debug("Find all service action types.");
        List<ServiceActionType> serviceActionTypeList = serviceActionTypeRepository.findAll();
        return serviceActionTypeMapper.toDto(serviceActionTypeList);
    }

    @Override
    public void delete(Long id) {
        log.debug("Delete service action type by id: {}", id);
        serviceActionTypeRepository.deleteServiceActionTypeById(id);
    }
}
