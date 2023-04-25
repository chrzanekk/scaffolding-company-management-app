package pl.com.chrzanowski.scma.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.com.chrzanowski.scma.domain.VehicleTire;
import pl.com.chrzanowski.scma.service.dto.VehicleTireDTO;

@Mapper(componentModel = "spring", uses = {TireMapper.class, VehicleMapper.class})
public interface VehicleTireMapper extends EntityMapper<VehicleTireDTO, VehicleTire> {

    @Mapping(source = "vehicle.id", target = "vehicleId")
    @Mapping(source = "tire.id", target = "tireId")
    VehicleTireDTO toDTO(VehicleTire vehicleTire);

    @Mapping(source = "vehicleId", target = "vehicle")
    @Mapping(source = "tireId", target = "tire")
    VehicleTire toEntity(VehicleTireDTO vehicleTireDTO);

    default VehicleTire fromId(Long id) {
        if (id == null) {
            return null;
        }
        VehicleTire vehicleTire = new VehicleTire();
        vehicleTire.setId(id);
        return vehicleTire;
    }
}
