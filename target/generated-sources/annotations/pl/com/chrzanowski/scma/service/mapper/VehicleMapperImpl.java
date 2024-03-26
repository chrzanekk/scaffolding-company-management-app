package pl.com.chrzanowski.scma.service.mapper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.com.chrzanowski.scma.domain.FuelType;
import pl.com.chrzanowski.scma.domain.Vehicle;
import pl.com.chrzanowski.scma.domain.VehicleBrand;
import pl.com.chrzanowski.scma.domain.VehicleModel;
import pl.com.chrzanowski.scma.domain.VehicleType;
import pl.com.chrzanowski.scma.service.dto.VehicleDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-25T17:42:40+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class VehicleMapperImpl implements VehicleMapper {

    @Override
    public List<Vehicle> toEntity(List<VehicleDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Vehicle> list = new ArrayList<Vehicle>( dtoList.size() );
        for ( VehicleDTO vehicleDTO : dtoList ) {
            list.add( toEntity( vehicleDTO ) );
        }

        return list;
    }

    @Override
    public List<VehicleDTO> toDto(List<Vehicle> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<VehicleDTO> list = new ArrayList<VehicleDTO>( entityList.size() );
        for ( Vehicle vehicle : entityList ) {
            list.add( toDto( vehicle ) );
        }

        return list;
    }

    @Override
    public Set<Vehicle> toEntity(Set<VehicleDTO> dtoSet) {
        if ( dtoSet == null ) {
            return null;
        }

        Set<Vehicle> set = new LinkedHashSet<Vehicle>( Math.max( (int) ( dtoSet.size() / .75f ) + 1, 16 ) );
        for ( VehicleDTO vehicleDTO : dtoSet ) {
            set.add( toEntity( vehicleDTO ) );
        }

        return set;
    }

    @Override
    public Set<VehicleDTO> toDto(Set<Vehicle> entitySet) {
        if ( entitySet == null ) {
            return null;
        }

        Set<VehicleDTO> set = new LinkedHashSet<VehicleDTO>( Math.max( (int) ( entitySet.size() / .75f ) + 1, 16 ) );
        for ( Vehicle vehicle : entitySet ) {
            set.add( toDto( vehicle ) );
        }

        return set;
    }

    @Override
    public VehicleDTO toDto(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }

        VehicleDTO.Builder vehicleDTO = VehicleDTO.builder();

        vehicleDTO.brandId( vehicleVehicleModelVehicleBrandId( vehicle ) );
        vehicleDTO.brandName( vehicleVehicleModelVehicleBrandName( vehicle ) );
        vehicleDTO.modelId( vehicleVehicleModelId( vehicle ) );
        vehicleDTO.modelName( vehicleVehicleModelName( vehicle ) );
        vehicleDTO.vehicleTypeId( vehicleVehicleTypeId( vehicle ) );
        vehicleDTO.vehicleTypeName( vehicleVehicleTypeName( vehicle ) );
        vehicleDTO.fuelTypeId( vehicleFuelTypeId( vehicle ) );
        vehicleDTO.fuelTypeName( vehicleFuelTypeName( vehicle ) );
        vehicleDTO.id( vehicle.getId() );
        vehicleDTO.registrationNumber( vehicle.getRegistrationNumber() );
        vehicleDTO.vin( vehicle.getVin() );
        vehicleDTO.productionYear( vehicle.getProductionYear() );
        vehicleDTO.firstRegistrationDate( vehicle.getFirstRegistrationDate() );
        vehicleDTO.freePlacesForTechInspection( vehicle.getFreePlacesForTechInspection() );
        vehicleDTO.length( vehicle.getLength() );
        vehicleDTO.width( vehicle.getWidth() );
        vehicleDTO.height( vehicle.getHeight() );
        vehicleDTO.createDate( vehicle.getCreateDate() );
        vehicleDTO.modifyDate( vehicle.getModifyDate() );

        return vehicleDTO.build();
    }

    @Override
    public Vehicle toEntity(VehicleDTO vehicleDTO) {
        if ( vehicleDTO == null ) {
            return null;
        }

        Vehicle vehicle = new Vehicle();

        vehicle.setVehicleModel( vehicleDTOToVehicleModel( vehicleDTO ) );
        vehicle.setVehicleType( vehicleDTOToVehicleType( vehicleDTO ) );
        vehicle.setFuelType( vehicleDTOToFuelType( vehicleDTO ) );
        vehicle.setId( vehicleDTO.getId() );
        vehicle.setRegistrationNumber( vehicleDTO.getRegistrationNumber() );
        vehicle.setVin( vehicleDTO.getVin() );
        vehicle.setProductionYear( vehicleDTO.getProductionYear() );
        vehicle.setFirstRegistrationDate( vehicleDTO.getFirstRegistrationDate() );
        vehicle.setFreePlacesForTechInspection( vehicleDTO.getFreePlacesForTechInspection() );
        vehicle.setLength( vehicleDTO.getLength() );
        vehicle.setWidth( vehicleDTO.getWidth() );
        vehicle.setHeight( vehicleDTO.getHeight() );
        vehicle.setCreateDate( vehicleDTO.getCreateDate() );
        vehicle.setModifyDate( vehicleDTO.getModifyDate() );

        return vehicle;
    }

    private Long vehicleVehicleModelVehicleBrandId(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }
        VehicleModel vehicleModel = vehicle.getVehicleModel();
        if ( vehicleModel == null ) {
            return null;
        }
        VehicleBrand vehicleBrand = vehicleModel.getVehicleBrand();
        if ( vehicleBrand == null ) {
            return null;
        }
        Long id = vehicleBrand.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String vehicleVehicleModelVehicleBrandName(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }
        VehicleModel vehicleModel = vehicle.getVehicleModel();
        if ( vehicleModel == null ) {
            return null;
        }
        VehicleBrand vehicleBrand = vehicleModel.getVehicleBrand();
        if ( vehicleBrand == null ) {
            return null;
        }
        String name = vehicleBrand.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long vehicleVehicleModelId(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }
        VehicleModel vehicleModel = vehicle.getVehicleModel();
        if ( vehicleModel == null ) {
            return null;
        }
        Long id = vehicleModel.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String vehicleVehicleModelName(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }
        VehicleModel vehicleModel = vehicle.getVehicleModel();
        if ( vehicleModel == null ) {
            return null;
        }
        String name = vehicleModel.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long vehicleVehicleTypeId(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }
        VehicleType vehicleType = vehicle.getVehicleType();
        if ( vehicleType == null ) {
            return null;
        }
        Long id = vehicleType.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String vehicleVehicleTypeName(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }
        VehicleType vehicleType = vehicle.getVehicleType();
        if ( vehicleType == null ) {
            return null;
        }
        String name = vehicleType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long vehicleFuelTypeId(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }
        FuelType fuelType = vehicle.getFuelType();
        if ( fuelType == null ) {
            return null;
        }
        Long id = fuelType.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String vehicleFuelTypeName(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }
        FuelType fuelType = vehicle.getFuelType();
        if ( fuelType == null ) {
            return null;
        }
        String name = fuelType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    protected VehicleBrand vehicleDTOToVehicleBrand(VehicleDTO vehicleDTO) {
        if ( vehicleDTO == null ) {
            return null;
        }

        VehicleBrand vehicleBrand = new VehicleBrand();

        vehicleBrand.setId( vehicleDTO.getBrandId() );
        vehicleBrand.name( vehicleDTO.getBrandName() );

        return vehicleBrand;
    }

    protected VehicleModel vehicleDTOToVehicleModel(VehicleDTO vehicleDTO) {
        if ( vehicleDTO == null ) {
            return null;
        }

        VehicleModel vehicleModel = new VehicleModel();

        vehicleModel.setVehicleBrand( vehicleDTOToVehicleBrand( vehicleDTO ) );
        vehicleModel.setId( vehicleDTO.getModelId() );
        vehicleModel.setName( vehicleDTO.getModelName() );

        return vehicleModel;
    }

    protected VehicleType vehicleDTOToVehicleType(VehicleDTO vehicleDTO) {
        if ( vehicleDTO == null ) {
            return null;
        }

        VehicleType vehicleType = new VehicleType();

        vehicleType.setId( vehicleDTO.getVehicleTypeId() );
        vehicleType.name( vehicleDTO.getVehicleTypeName() );

        return vehicleType;
    }

    protected FuelType vehicleDTOToFuelType(VehicleDTO vehicleDTO) {
        if ( vehicleDTO == null ) {
            return null;
        }

        FuelType fuelType = new FuelType();

        fuelType.setId( vehicleDTO.getFuelTypeId() );
        fuelType.name( vehicleDTO.getFuelTypeName() );

        return fuelType;
    }
}
