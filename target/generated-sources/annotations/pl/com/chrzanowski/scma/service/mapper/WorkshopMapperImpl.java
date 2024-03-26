package pl.com.chrzanowski.scma.service.mapper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.chrzanowski.scma.domain.Workshop;
import pl.com.chrzanowski.scma.service.dto.WorkshopDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-25T17:42:39+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class WorkshopMapperImpl implements WorkshopMapper {

    @Autowired
    private ServiceActionTypeMapper serviceActionTypeMapper;

    @Override
    public Workshop toEntity(WorkshopDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Workshop workshop = new Workshop();

        workshop.setId( dto.getId() );
        workshop.setName( dto.getName() );
        workshop.setTaxNumber( dto.getTaxNumber() );
        workshop.setStreet( dto.getStreet() );
        workshop.setBuildingNo( dto.getBuildingNo() );
        workshop.setApartmentNo( dto.getApartmentNo() );
        workshop.setPostalCode( dto.getPostalCode() );
        workshop.setCity( dto.getCity() );
        workshop.setCountry( dto.getCountry() );
        workshop.setServiceActionTypes( serviceActionTypeMapper.toEntity( dto.getServiceActionTypes() ) );
        workshop.setCreateDate( dto.getCreateDate() );
        workshop.setModifyDate( dto.getModifyDate() );
        workshop.setRemoveDate( dto.getRemoveDate() );

        return workshop;
    }

    @Override
    public WorkshopDTO toDto(Workshop entity) {
        if ( entity == null ) {
            return null;
        }

        WorkshopDTO.Builder workshopDTO = WorkshopDTO.builder();

        workshopDTO.id( entity.getId() );
        workshopDTO.name( entity.getName() );
        workshopDTO.taxNumber( entity.getTaxNumber() );
        workshopDTO.street( entity.getStreet() );
        workshopDTO.buildingNo( entity.getBuildingNo() );
        workshopDTO.apartmentNo( entity.getApartmentNo() );
        workshopDTO.postalCode( entity.getPostalCode() );
        workshopDTO.city( entity.getCity() );
        workshopDTO.country( entity.getCountry() );
        workshopDTO.serviceActionTypes( serviceActionTypeMapper.toDto( entity.getServiceActionTypes() ) );
        workshopDTO.createDate( entity.getCreateDate() );
        workshopDTO.modifyDate( entity.getModifyDate() );
        workshopDTO.removeDate( entity.getRemoveDate() );

        return workshopDTO.build();
    }

    @Override
    public List<Workshop> toEntity(List<WorkshopDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Workshop> list = new ArrayList<Workshop>( dtoList.size() );
        for ( WorkshopDTO workshopDTO : dtoList ) {
            list.add( toEntity( workshopDTO ) );
        }

        return list;
    }

    @Override
    public List<WorkshopDTO> toDto(List<Workshop> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<WorkshopDTO> list = new ArrayList<WorkshopDTO>( entityList.size() );
        for ( Workshop workshop : entityList ) {
            list.add( toDto( workshop ) );
        }

        return list;
    }

    @Override
    public Set<Workshop> toEntity(Set<WorkshopDTO> dtoSet) {
        if ( dtoSet == null ) {
            return null;
        }

        Set<Workshop> set = new LinkedHashSet<Workshop>( Math.max( (int) ( dtoSet.size() / .75f ) + 1, 16 ) );
        for ( WorkshopDTO workshopDTO : dtoSet ) {
            set.add( toEntity( workshopDTO ) );
        }

        return set;
    }

    @Override
    public Set<WorkshopDTO> toDto(Set<Workshop> entitySet) {
        if ( entitySet == null ) {
            return null;
        }

        Set<WorkshopDTO> set = new LinkedHashSet<WorkshopDTO>( Math.max( (int) ( entitySet.size() / .75f ) + 1, 16 ) );
        for ( Workshop workshop : entitySet ) {
            set.add( toDto( workshop ) );
        }

        return set;
    }
}
