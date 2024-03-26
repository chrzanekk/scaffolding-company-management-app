package pl.com.chrzanowski.scma.service.mapper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.com.chrzanowski.scma.domain.FuelType;
import pl.com.chrzanowski.scma.service.dto.FuelTypeDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-25T17:42:39+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class FuelTypeMapperImpl implements FuelTypeMapper {

    @Override
    public FuelType toEntity(FuelTypeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        FuelType fuelType = new FuelType();

        fuelType.setId( dto.getId() );
        fuelType.name( dto.getName() );
        fuelType.createDate( dto.getCreateDate() );
        fuelType.modifyDate( dto.getModifyDate() );
        fuelType.removeDate( dto.getRemoveDate() );

        return fuelType;
    }

    @Override
    public FuelTypeDTO toDto(FuelType entity) {
        if ( entity == null ) {
            return null;
        }

        FuelTypeDTO.Builder fuelTypeDTO = FuelTypeDTO.builder();

        fuelTypeDTO.id( entity.getId() );
        fuelTypeDTO.name( entity.getName() );
        fuelTypeDTO.createDate( entity.getCreateDate() );
        fuelTypeDTO.modifyDate( entity.getModifyDate() );
        fuelTypeDTO.removeDate( entity.getRemoveDate() );

        return fuelTypeDTO.build();
    }

    @Override
    public List<FuelType> toEntity(List<FuelTypeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<FuelType> list = new ArrayList<FuelType>( dtoList.size() );
        for ( FuelTypeDTO fuelTypeDTO : dtoList ) {
            list.add( toEntity( fuelTypeDTO ) );
        }

        return list;
    }

    @Override
    public List<FuelTypeDTO> toDto(List<FuelType> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<FuelTypeDTO> list = new ArrayList<FuelTypeDTO>( entityList.size() );
        for ( FuelType fuelType : entityList ) {
            list.add( toDto( fuelType ) );
        }

        return list;
    }

    @Override
    public Set<FuelType> toEntity(Set<FuelTypeDTO> dtoSet) {
        if ( dtoSet == null ) {
            return null;
        }

        Set<FuelType> set = new LinkedHashSet<FuelType>( Math.max( (int) ( dtoSet.size() / .75f ) + 1, 16 ) );
        for ( FuelTypeDTO fuelTypeDTO : dtoSet ) {
            set.add( toEntity( fuelTypeDTO ) );
        }

        return set;
    }

    @Override
    public Set<FuelTypeDTO> toDto(Set<FuelType> entitySet) {
        if ( entitySet == null ) {
            return null;
        }

        Set<FuelTypeDTO> set = new LinkedHashSet<FuelTypeDTO>( Math.max( (int) ( entitySet.size() / .75f ) + 1, 16 ) );
        for ( FuelType fuelType : entitySet ) {
            set.add( toDto( fuelType ) );
        }

        return set;
    }
}
