package pl.com.chrzanowski.scma.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.domain.ServiceAction;
import pl.com.chrzanowski.scma.exception.ObjectNotFoundException;
import pl.com.chrzanowski.scma.repository.ServiceActionRepository;
import pl.com.chrzanowski.scma.service.ServiceActionService;
import pl.com.chrzanowski.scma.service.dto.ServiceActionDTO;
import pl.com.chrzanowski.scma.service.dto.SummaryValueServiceActionDTO;
import pl.com.chrzanowski.scma.service.filter.serviceaction.ServiceActionFilter;
import pl.com.chrzanowski.scma.service.filter.serviceaction.ServiceActionSpecification;
import pl.com.chrzanowski.scma.service.mapper.ServiceActionMapper;
import pl.com.chrzanowski.scma.util.DateTimeUtil;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceActionServiceImpl implements ServiceActionService {

    private final Logger log = LoggerFactory.getLogger(ServiceActionServiceImpl.class);

    private final ServiceActionRepository serviceActionRepository;
    private final ServiceActionMapper serviceActionMapper;
    private final ServiceActionSpecification serviceActionSpecification;

    public ServiceActionServiceImpl(ServiceActionRepository serviceActionRepository,
                                    ServiceActionMapper serviceActionMapper,
                                    ServiceActionSpecification serviceActionSpecification) {
        this.serviceActionRepository = serviceActionRepository;
        this.serviceActionMapper = serviceActionMapper;
        this.serviceActionSpecification = serviceActionSpecification;
    }

    @Override
    public ServiceActionDTO save(ServiceActionDTO serviceActionDTO) {
        log.debug("Save service action: {}", serviceActionDTO);
        ServiceActionDTO serviceActionDTOtoUpdate = ServiceActionDTO.builder(serviceActionDTO)
                .createDate(DateTimeUtil.setDateTimeIfNotExists(serviceActionDTO.getCreateDate())).build();
        ServiceAction serviceAction =
                serviceActionRepository.save(serviceActionMapper.toEntity(serviceActionDTOtoUpdate));
        return serviceActionMapper.toDto(serviceAction);
    }

    @Override
    public ServiceActionDTO update(ServiceActionDTO serviceActionDTO) {
        log.debug("Update service action: {}", serviceActionDTO);
        if (serviceActionDTO.getId() != null) {
            ServiceActionDTO serviceActionDTOtoUpdate = ServiceActionDTO.builder(serviceActionDTO)
                    .modifyDate(Instant.now()).build();
            ServiceAction serviceAction =
                    serviceActionRepository.save(serviceActionMapper.toEntity(serviceActionDTOtoUpdate));
            return serviceActionMapper.toDto(serviceAction);
        } else {
            throw new ObjectNotFoundException("Id not found");
        }
    }

    @Override
    public List<ServiceActionDTO> findByFilter(ServiceActionFilter serviceActionFilter) {
        log.debug("Find service actions by filter: {}", serviceActionFilter);
        Specification<ServiceAction> spec = ServiceActionSpecification.createSpecification(serviceActionFilter);
        List<ServiceActionDTO> result = serviceActionMapper.toDto(serviceActionRepository.findAll(spec));
        return handleSummaryValuesOfServiceActions(result);
    }

    private List<ServiceActionDTO> handleSummaryValuesOfServiceActions(List<ServiceActionDTO> result) {
        SummaryValueServiceActionDTO summaryValues = calculateSummaryValues(result);
        addSummaryToFirstElementOfResult(summaryValues, result);
        return result;
    }

    private SummaryValueServiceActionDTO calculateSummaryValues(List<ServiceActionDTO> list) {
        return SummaryValueServiceActionDTO.builder()
                .summaryGrossValue(calculateSummaryGrossValue(list))
                .summaryTaxValue(calculateSummaryTaxValue(list))
                .summaryNetValue(calculateSummaryNetValue(list)).build();
    }

    private BigDecimal calculateSummaryGrossValue(List<ServiceActionDTO> list) {
        return list.stream().map(ServiceActionDTO::getGrossValue).reduce(BigDecimal.ZERO
                , BigDecimal::add);
    }

    private BigDecimal calculateSummaryNetValue(List<ServiceActionDTO> list) {
        return list.stream().map(ServiceActionDTO::getNetValue).reduce(BigDecimal.ZERO
                , BigDecimal::add);
    }

    private BigDecimal calculateSummaryTaxValue(List<ServiceActionDTO> list) {
        return list.stream().map(ServiceActionDTO::getTaxValue).reduce(BigDecimal.ZERO
                , BigDecimal::add);
    }

    private void addSummaryToFirstElementOfResult(SummaryValueServiceActionDTO summaryValues,
                                                  List<ServiceActionDTO> result) {
        result.stream().findFirst().ifPresent(serviceActionDTO ->
                ServiceActionDTO.builder(serviceActionDTO)
                        .summaryGrossValue(summaryValues.getSummaryGrossValue())
                        .summaryNetValue(summaryValues.getSummaryNetValue())
                        .summaryTaxValue(summaryValues.getSummaryTaxValue()));
    }

    @Override
    public Page<ServiceActionDTO> findByFilterAndPage(ServiceActionFilter serviceActionFilter, Pageable pageable) {
        log.debug("Find service actions by filter with page: {}", serviceActionFilter);
        Specification<ServiceAction> spec = ServiceActionSpecification.createSpecification(serviceActionFilter);
        Page<ServiceActionDTO> result = serviceActionRepository.findAll(spec, pageable).map(serviceActionMapper::toDto);
        return new PageImpl<>(handleSummaryValuesOfServiceActions(result.getContent()), pageable, result.getTotalElements());
    }

    @Override
    public ServiceActionDTO findById(Long id) {
        log.debug("Find service action by id: {}", id);
        Optional<ServiceAction> serviceActionOptional = serviceActionRepository.findById(id);
        return serviceActionMapper.toDto(serviceActionOptional.orElseThrow(() -> new ObjectNotFoundException("Service" +
                " action not found")));
    }

    @Override
    public List<ServiceActionDTO> findAll() {
        log.debug("Find all service actions.");
        return serviceActionMapper.toDto(serviceActionRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        log.debug("Delete service action by id {}", id);
        serviceActionRepository.deleteServiceActionById(id);
    }
}
