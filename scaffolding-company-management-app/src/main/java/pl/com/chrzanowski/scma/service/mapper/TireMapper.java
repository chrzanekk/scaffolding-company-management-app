package pl.com.chrzanowski.scma.service.mapper;

import org.mapstruct.Mapper;
import pl.com.chrzanowski.scma.domain.Tire;
import pl.com.chrzanowski.scma.service.dto.TireDTO;

@Mapper(componentModel = "spring", uses = {})
public interface TireMapper extends EntityMapper<TireDTO, Tire> {


    TireDTO toDto(Tire tire);


    Tire toEntity(TireDTO tireDTO);


    default Tire fromId(Long id) {
        if (id == null) {
            return null;
        }
        Tire tire = new Tire();
        tire.setId(id);
        return tire;
    }
}
