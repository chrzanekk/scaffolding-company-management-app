package pl.com.chrzanowski.scma.service.mapper;

import org.mapstruct.Mapper;
import pl.com.chrzanowski.scma.domain.ServiceActionType;
import pl.com.chrzanowski.scma.service.dto.ServiceActionTypeDTO;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {})
public interface ServiceActionTypeMapper extends EntityMapper<ServiceActionTypeDTO, ServiceActionType> {
    Set<ServiceActionTypeDTO> mapDTOSet(Set<ServiceActionType>serviceActionTypes);
    Set<ServiceActionType> mapEntitySet(Set<ServiceActionTypeDTO>serviceActionTypeDTOS);

    default ServiceActionType fromId(Long id) {
        if (id == null) {
            return null;
        }
        ServiceActionType serviceActionType = new ServiceActionType();
        serviceActionType.setId(id);
        return serviceActionType;
    }

}
