package pl.com.chrzanowski.scma.service.mapper;

import org.mapstruct.Mapper;
import pl.com.chrzanowski.scma.domain.FuelType;
import pl.com.chrzanowski.scma.domain.VehicleType;
import pl.com.chrzanowski.scma.service.dto.VehicleTypeDTO;

@Mapper(componentModel = "spring", uses = {})
public interface VehicleTypeMapper extends EntityMapper<VehicleTypeDTO, VehicleType> {

    default VehicleType fromId(Long id) {
        if (id == null) {
            return null;
        }
        VehicleType fuelType = new VehicleType();
        fuelType.setId(id);
        return fuelType;
    }
}
