package pl.com.chrzanowski.scma.service.mapper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.com.chrzanowski.scma.domain.VehicleType;
import pl.com.chrzanowski.scma.service.dto.VehicleTypeDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-25T17:42:39+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class VehicleTypeMapperImpl implements VehicleTypeMapper {

    @Override
    public VehicleType toEntity(VehicleTypeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VehicleType vehicleType = new VehicleType();

        vehicleType.setId( dto.getId() );
        vehicleType.name( dto.getName() );
        vehicleType.createDate( dto.getCreateDate() );
        vehicleType.modifyDate( dto.getModifyDate() );
        vehicleType.removeDate( dto.getRemoveDate() );

        return vehicleType;
    }

    @Override
    public VehicleTypeDTO toDto(VehicleType entity) {
        if ( entity == null ) {
            return null;
        }

        VehicleTypeDTO.Builder vehicleTypeDTO = VehicleTypeDTO.builder();

        vehicleTypeDTO.id( entity.getId() );
        vehicleTypeDTO.name( entity.getName() );
        vehicleTypeDTO.createDate( entity.getCreateDate() );
        vehicleTypeDTO.modifyDate( entity.getModifyDate() );
        vehicleTypeDTO.removeDate( entity.getRemoveDate() );

        return vehicleTypeDTO.build();
    }

    @Override
    public List<VehicleType> toEntity(List<VehicleTypeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<VehicleType> list = new ArrayList<VehicleType>( dtoList.size() );
        for ( VehicleTypeDTO vehicleTypeDTO : dtoList ) {
            list.add( toEntity( vehicleTypeDTO ) );
        }

        return list;
    }

    @Override
    public List<VehicleTypeDTO> toDto(List<VehicleType> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<VehicleTypeDTO> list = new ArrayList<VehicleTypeDTO>( entityList.size() );
        for ( VehicleType vehicleType : entityList ) {
            list.add( toDto( vehicleType ) );
        }

        return list;
    }

    @Override
    public Set<VehicleType> toEntity(Set<VehicleTypeDTO> dtoSet) {
        if ( dtoSet == null ) {
            return null;
        }

        Set<VehicleType> set = new LinkedHashSet<VehicleType>( Math.max( (int) ( dtoSet.size() / .75f ) + 1, 16 ) );
        for ( VehicleTypeDTO vehicleTypeDTO : dtoSet ) {
            set.add( toEntity( vehicleTypeDTO ) );
        }

        return set;
    }

    @Override
    public Set<VehicleTypeDTO> toDto(Set<VehicleType> entitySet) {
        if ( entitySet == null ) {
            return null;
        }

        Set<VehicleTypeDTO> set = new LinkedHashSet<VehicleTypeDTO>( Math.max( (int) ( entitySet.size() / .75f ) + 1, 16 ) );
        for ( VehicleType vehicleType : entitySet ) {
            set.add( toDto( vehicleType ) );
        }

        return set;
    }
}
