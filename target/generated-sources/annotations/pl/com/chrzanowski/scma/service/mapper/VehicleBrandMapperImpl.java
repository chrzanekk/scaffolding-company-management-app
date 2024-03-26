package pl.com.chrzanowski.scma.service.mapper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.com.chrzanowski.scma.domain.VehicleBrand;
import pl.com.chrzanowski.scma.service.dto.VehicleBrandDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-25T17:42:39+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class VehicleBrandMapperImpl implements VehicleBrandMapper {

    @Override
    public VehicleBrand toEntity(VehicleBrandDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VehicleBrand vehicleBrand = new VehicleBrand();

        vehicleBrand.setId( dto.getId() );
        vehicleBrand.name( dto.getName() );
        vehicleBrand.createDate( dto.getCreateDate() );
        vehicleBrand.modifyDate( dto.getModifyDate() );
        vehicleBrand.removeDate( dto.getRemoveDate() );

        return vehicleBrand;
    }

    @Override
    public VehicleBrandDTO toDto(VehicleBrand entity) {
        if ( entity == null ) {
            return null;
        }

        VehicleBrandDTO.Builder vehicleBrandDTO = VehicleBrandDTO.builder();

        vehicleBrandDTO.id( entity.getId() );
        vehicleBrandDTO.name( entity.getName() );
        vehicleBrandDTO.createDate( entity.getCreateDate() );
        vehicleBrandDTO.modifyDate( entity.getModifyDate() );
        vehicleBrandDTO.removeDate( entity.getRemoveDate() );

        return vehicleBrandDTO.build();
    }

    @Override
    public List<VehicleBrand> toEntity(List<VehicleBrandDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<VehicleBrand> list = new ArrayList<VehicleBrand>( dtoList.size() );
        for ( VehicleBrandDTO vehicleBrandDTO : dtoList ) {
            list.add( toEntity( vehicleBrandDTO ) );
        }

        return list;
    }

    @Override
    public List<VehicleBrandDTO> toDto(List<VehicleBrand> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<VehicleBrandDTO> list = new ArrayList<VehicleBrandDTO>( entityList.size() );
        for ( VehicleBrand vehicleBrand : entityList ) {
            list.add( toDto( vehicleBrand ) );
        }

        return list;
    }

    @Override
    public Set<VehicleBrand> toEntity(Set<VehicleBrandDTO> dtoSet) {
        if ( dtoSet == null ) {
            return null;
        }

        Set<VehicleBrand> set = new LinkedHashSet<VehicleBrand>( Math.max( (int) ( dtoSet.size() / .75f ) + 1, 16 ) );
        for ( VehicleBrandDTO vehicleBrandDTO : dtoSet ) {
            set.add( toEntity( vehicleBrandDTO ) );
        }

        return set;
    }

    @Override
    public Set<VehicleBrandDTO> toDto(Set<VehicleBrand> entitySet) {
        if ( entitySet == null ) {
            return null;
        }

        Set<VehicleBrandDTO> set = new LinkedHashSet<VehicleBrandDTO>( Math.max( (int) ( entitySet.size() / .75f ) + 1, 16 ) );
        for ( VehicleBrand vehicleBrand : entitySet ) {
            set.add( toDto( vehicleBrand ) );
        }

        return set;
    }
}
