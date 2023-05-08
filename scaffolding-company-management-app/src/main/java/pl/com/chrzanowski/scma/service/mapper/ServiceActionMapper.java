package pl.com.chrzanowski.scma.service.mapper;

import org.mapstruct.Mapper;
import pl.com.chrzanowski.scma.domain.ServiceAction;
import pl.com.chrzanowski.scma.service.dto.ServiceActionDTO;

@Mapper(componentModel = "spring", uses = {ServiceActionTypeMapper.class, WorkshopMapper.class})
public interface ServiceActionMapper extends EntityMapper<ServiceActionDTO, ServiceAction> {


    default ServiceAction fromId(Long id) {
        if (id == null) {
            return null;
        }
        ServiceAction serviceAction = new ServiceAction();
        serviceAction.setId(id);
        return serviceAction;
    }

}
