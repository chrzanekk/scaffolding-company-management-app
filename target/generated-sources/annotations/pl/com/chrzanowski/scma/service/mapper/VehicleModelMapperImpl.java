package pl.com.chrzanowski.scma.service.mapper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.com.chrzanowski.scma.domain.VehicleBrand;
import pl.com.chrzanowski.scma.domain.VehicleModel;
import pl.com.chrzanowski.scma.service.dto.VehicleModelDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-25T17:42:39+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class VehicleModelMapperImpl implements VehicleModelMapper {

    @Override
    public List<VehicleModel> toEntity(List<VehicleModelDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<VehicleModel> list = new ArrayList<VehicleModel>( dtoList.size() );
        for ( VehicleModelDTO vehicleModelDTO : dtoList ) {
            list.add( toEntity( vehicleModelDTO ) );
        }

        return list;
    }

    @Override
    public List<VehicleModelDTO> toDto(List<VehicleModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<VehicleModelDTO> list = new ArrayList<VehicleModelDTO>( entityList.size() );
        for ( VehicleModel vehicleModel : entityList ) {
            list.add( toDto( vehicleModel ) );
        }

        return list;
    }

    @Override
    public Set<VehicleModel> toEntity(Set<VehicleModelDTO> dtoSet) {
        if ( dtoSet == null ) {
            return null;
        }

        Set<VehicleModel> set = new LinkedHashSet<VehicleModel>( Math.max( (int) ( dtoSet.size() / .75f ) + 1, 16 ) );
        for ( VehicleModelDTO vehicleModelDTO : dtoSet ) {
            set.add( toEntity( vehicleModelDTO ) );
        }

        return set;
    }

    @Override
    public Set<VehicleModelDTO> toDto(Set<VehicleModel> entitySet) {
        if ( entitySet == null ) {
            return null;
        }

        Set<VehicleModelDTO> set = new LinkedHashSet<VehicleModelDTO>( Math.max( (int) ( entitySet.size() / .75f ) + 1, 16 ) );
        for ( VehicleModel vehicleModel : entitySet ) {
            set.add( toDto( vehicleModel ) );
        }

        return set;
    }

    @Override
    public VehicleModelDTO toDto(VehicleModel vehicleModel) {
        if ( vehicleModel == null ) {
            return null;
        }

        VehicleModelDTO.Builder vehicleModelDTO = VehicleModelDTO.builder();

        vehicleModelDTO.vehicleBrandId( vehicleModelVehicleBrandId( vehicleModel ) );
        vehicleModelDTO.vehicleBrandName( vehicleModelVehicleBrandName( vehicleModel ) );
        vehicleModelDTO.id( vehicleModel.getId() );
        vehicleModelDTO.name( vehicleModel.getName() );
        vehicleModelDTO.createDate( vehicleModel.getCreateDate() );
        vehicleModelDTO.modifyDate( vehicleModel.getModifyDate() );
        vehicleModelDTO.removeDate( vehicleModel.getRemoveDate() );

        return vehicleModelDTO.build();
    }

    @Override
    public VehicleModel toEntity(VehicleModelDTO vehicleModelDTO) {
        if ( vehicleModelDTO == null ) {
            return null;
        }

        VehicleModel vehicleModel = new VehicleModel();

        vehicleModel.setVehicleBrand( vehicleModelDTOToVehicleBrand( vehicleModelDTO ) );
        vehicleModel.setId( vehicleModelDTO.getId() );
        vehicleModel.setName( vehicleModelDTO.getName() );
        vehicleModel.setCreateDate( vehicleModelDTO.getCreateDate() );
        vehicleModel.setModifyDate( vehicleModelDTO.getModifyDate() );
        vehicleModel.setRemoveDate( vehicleModelDTO.getRemoveDate() );

        return vehicleModel;
    }

    private Long vehicleModelVehicleBrandId(VehicleModel vehicleModel) {
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

    private String vehicleModelVehicleBrandName(VehicleModel vehicleModel) {
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

    protected VehicleBrand vehicleModelDTOToVehicleBrand(VehicleModelDTO vehicleModelDTO) {
        if ( vehicleModelDTO == null ) {
            return null;
        }

        VehicleBrand vehicleBrand = new VehicleBrand();

        vehicleBrand.setId( vehicleModelDTO.getVehicleBrandId() );
        vehicleBrand.name( vehicleModelDTO.getVehicleBrandName() );

        return vehicleBrand;
    }
}
