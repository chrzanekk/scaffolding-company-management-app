package pl.com.chrzanowski.scma.service.mapper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.com.chrzanowski.scma.domain.ServiceActionType;
import pl.com.chrzanowski.scma.domain.Workshop;
import pl.com.chrzanowski.scma.service.dto.ServiceActionTypeDTO;
import pl.com.chrzanowski.scma.service.dto.WorkshopDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-25T17:42:40+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class ServiceActionTypeMapperImpl implements ServiceActionTypeMapper {

    @Override
    public ServiceActionType toEntity(ServiceActionTypeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ServiceActionType serviceActionType = new ServiceActionType();

        serviceActionType.setId( dto.getId() );
        serviceActionType.setName( dto.getName() );
        serviceActionType.setCreateDate( dto.getCreateDate() );
        serviceActionType.setModifyDate( dto.getModifyDate() );
        serviceActionType.setRemoveDate( dto.getRemoveDate() );
        serviceActionType.setWorkshops( workshopDTOSetToWorkshopSet( dto.getWorkshops() ) );
        serviceActionType.setTypeOfService( dto.getTypeOfService() );

        return serviceActionType;
    }

    @Override
    public ServiceActionTypeDTO toDto(ServiceActionType entity) {
        if ( entity == null ) {
            return null;
        }

        ServiceActionTypeDTO.Builder serviceActionTypeDTO = ServiceActionTypeDTO.builder();

        serviceActionTypeDTO.id( entity.getId() );
        serviceActionTypeDTO.name( entity.getName() );
        serviceActionTypeDTO.typeOfService( entity.getTypeOfService() );
        serviceActionTypeDTO.createDate( entity.getCreateDate() );
        serviceActionTypeDTO.modifyDate( entity.getModifyDate() );
        serviceActionTypeDTO.removeDate( entity.getRemoveDate() );
        serviceActionTypeDTO.workshops( workshopSetToWorkshopDTOSet( entity.getWorkshops() ) );

        return serviceActionTypeDTO.build();
    }

    @Override
    public List<ServiceActionType> toEntity(List<ServiceActionTypeDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ServiceActionType> list = new ArrayList<ServiceActionType>( dtoList.size() );
        for ( ServiceActionTypeDTO serviceActionTypeDTO : dtoList ) {
            list.add( toEntity( serviceActionTypeDTO ) );
        }

        return list;
    }

    @Override
    public List<ServiceActionTypeDTO> toDto(List<ServiceActionType> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ServiceActionTypeDTO> list = new ArrayList<ServiceActionTypeDTO>( entityList.size() );
        for ( ServiceActionType serviceActionType : entityList ) {
            list.add( toDto( serviceActionType ) );
        }

        return list;
    }

    @Override
    public Set<ServiceActionType> toEntity(Set<ServiceActionTypeDTO> dtoSet) {
        if ( dtoSet == null ) {
            return null;
        }

        Set<ServiceActionType> set = new LinkedHashSet<ServiceActionType>( Math.max( (int) ( dtoSet.size() / .75f ) + 1, 16 ) );
        for ( ServiceActionTypeDTO serviceActionTypeDTO : dtoSet ) {
            set.add( toEntity( serviceActionTypeDTO ) );
        }

        return set;
    }

    @Override
    public Set<ServiceActionTypeDTO> toDto(Set<ServiceActionType> entitySet) {
        if ( entitySet == null ) {
            return null;
        }

        Set<ServiceActionTypeDTO> set = new LinkedHashSet<ServiceActionTypeDTO>( Math.max( (int) ( entitySet.size() / .75f ) + 1, 16 ) );
        for ( ServiceActionType serviceActionType : entitySet ) {
            set.add( toDto( serviceActionType ) );
        }

        return set;
    }

    protected Workshop workshopDTOToWorkshop(WorkshopDTO workshopDTO) {
        if ( workshopDTO == null ) {
            return null;
        }

        Workshop workshop = new Workshop();

        workshop.setId( workshopDTO.getId() );
        workshop.setName( workshopDTO.getName() );
        workshop.setTaxNumber( workshopDTO.getTaxNumber() );
        workshop.setStreet( workshopDTO.getStreet() );
        workshop.setBuildingNo( workshopDTO.getBuildingNo() );
        workshop.setApartmentNo( workshopDTO.getApartmentNo() );
        workshop.setPostalCode( workshopDTO.getPostalCode() );
        workshop.setCity( workshopDTO.getCity() );
        workshop.setCountry( workshopDTO.getCountry() );
        workshop.setServiceActionTypes( toEntity( workshopDTO.getServiceActionTypes() ) );
        workshop.setCreateDate( workshopDTO.getCreateDate() );
        workshop.setModifyDate( workshopDTO.getModifyDate() );
        workshop.setRemoveDate( workshopDTO.getRemoveDate() );

        return workshop;
    }

    protected Set<Workshop> workshopDTOSetToWorkshopSet(Set<WorkshopDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Workshop> set1 = new LinkedHashSet<Workshop>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( WorkshopDTO workshopDTO : set ) {
            set1.add( workshopDTOToWorkshop( workshopDTO ) );
        }

        return set1;
    }

    protected WorkshopDTO workshopToWorkshopDTO(Workshop workshop) {
        if ( workshop == null ) {
            return null;
        }

        WorkshopDTO.Builder workshopDTO = WorkshopDTO.builder();

        workshopDTO.id( workshop.getId() );
        workshopDTO.name( workshop.getName() );
        workshopDTO.taxNumber( workshop.getTaxNumber() );
        workshopDTO.street( workshop.getStreet() );
        workshopDTO.buildingNo( workshop.getBuildingNo() );
        workshopDTO.apartmentNo( workshop.getApartmentNo() );
        workshopDTO.postalCode( workshop.getPostalCode() );
        workshopDTO.city( workshop.getCity() );
        workshopDTO.country( workshop.getCountry() );
        workshopDTO.serviceActionTypes( toDto( workshop.getServiceActionTypes() ) );
        workshopDTO.createDate( workshop.getCreateDate() );
        workshopDTO.modifyDate( workshop.getModifyDate() );
        workshopDTO.removeDate( workshop.getRemoveDate() );

        return workshopDTO.build();
    }

    protected Set<WorkshopDTO> workshopSetToWorkshopDTOSet(Set<Workshop> set) {
        if ( set == null ) {
            return null;
        }

        Set<WorkshopDTO> set1 = new LinkedHashSet<WorkshopDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Workshop workshop : set ) {
            set1.add( workshopToWorkshopDTO( workshop ) );
        }

        return set1;
    }
}
