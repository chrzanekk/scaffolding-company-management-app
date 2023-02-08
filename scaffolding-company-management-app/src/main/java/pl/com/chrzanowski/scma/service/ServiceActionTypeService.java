package pl.com.chrzanowski.scma.service;

import pl.com.chrzanowski.scma.service.dto.ServiceActionTypeDTO;
import pl.com.chrzanowski.scma.service.filter.serviceactiontype.ServiceActionTypeFilter;

import java.util.List;

public interface ServiceActionTypeService {

    ServiceActionTypeDTO save(ServiceActionTypeDTO serviceActionTypeDTO);

    ServiceActionTypeDTO update(ServiceActionTypeDTO serviceActionTypeDTO);

    List<ServiceActionTypeDTO> find(ServiceActionTypeFilter serviceActionTypeFilter);

    ServiceActionTypeDTO findById(Long id);

    List<ServiceActionTypeDTO> findAll();

    void delete(Long id);
}
