package pl.com.chrzanowski.scma.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.com.chrzanowski.scma.domain.VehicleTire;
import pl.com.chrzanowski.scma.service.dto.VehicleTireDTO;

@Mapper(componentModel = "spring", uses = {VehicleMapper.class})
public interface VehicleTireMapper extends EntityMapper<VehicleTireDTO, VehicleTire> {

    @Mapping(source = "vehicle.id", target = "vehicleId")
    @Mapping(source = "vehicle.vehicleModel.vehicleBrand.id", target = "vehicleBrandId")
    @Mapping(source = "vehicle.vehicleModel.vehicleBrand.name", target = "vehicleBrandName")
    @Mapping(source = "vehicle.vehicleModel.id", target = "vehicleModelId")
    @Mapping(source = "vehicle.vehicleModel.name", target = "vehicleModelName")
    VehicleTireDTO toDto(VehicleTire vehicleTire);

    @Mapping(source = "vehicleId", target = "vehicle.id")
    @Mapping(source = "vehicleBrandId", target = "vehicle.vehicleModel.vehicleBrand.id")
    @Mapping(source = "vehicleBrandName", target = "vehicle.vehicleModel.vehicleBrand.name")
    @Mapping(source = "vehicleModelId", target = "vehicle.vehicleModel.id")
    @Mapping(source = "vehicleModelName", target = "vehicle.vehicleModel.name")
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
