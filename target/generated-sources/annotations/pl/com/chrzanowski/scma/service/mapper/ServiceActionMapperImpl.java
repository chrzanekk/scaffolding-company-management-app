package pl.com.chrzanowski.scma.service.mapper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.com.chrzanowski.scma.domain.ServiceAction;
import pl.com.chrzanowski.scma.domain.ServiceActionType;
import pl.com.chrzanowski.scma.domain.Vehicle;
import pl.com.chrzanowski.scma.domain.Workshop;
import pl.com.chrzanowski.scma.service.dto.ServiceActionDTO;
import pl.com.chrzanowski.scma.service.dto.ServiceActionTypeDTO;
import pl.com.chrzanowski.scma.service.dto.WorkshopDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-25T17:42:39+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class ServiceActionMapperImpl implements ServiceActionMapper {

    @Override
    public List<ServiceAction> toEntity(List<ServiceActionDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ServiceAction> list = new ArrayList<ServiceAction>( dtoList.size() );
        for ( ServiceActionDTO serviceActionDTO : dtoList ) {
            list.add( toEntity( serviceActionDTO ) );
        }

        return list;
    }

    @Override
    public List<ServiceActionDTO> toDto(List<ServiceAction> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ServiceActionDTO> list = new ArrayList<ServiceActionDTO>( entityList.size() );
        for ( ServiceAction serviceAction : entityList ) {
            list.add( toDto( serviceAction ) );
        }

        return list;
    }

    @Override
    public Set<ServiceAction> toEntity(Set<ServiceActionDTO> dtoSet) {
        if ( dtoSet == null ) {
            return null;
        }

        Set<ServiceAction> set = new LinkedHashSet<ServiceAction>( Math.max( (int) ( dtoSet.size() / .75f ) + 1, 16 ) );
        for ( ServiceActionDTO serviceActionDTO : dtoSet ) {
            set.add( toEntity( serviceActionDTO ) );
        }

        return set;
    }

    @Override
    public Set<ServiceActionDTO> toDto(Set<ServiceAction> entitySet) {
        if ( entitySet == null ) {
            return null;
        }

        Set<ServiceActionDTO> set = new LinkedHashSet<ServiceActionDTO>( Math.max( (int) ( entitySet.size() / .75f ) + 1, 16 ) );
        for ( ServiceAction serviceAction : entitySet ) {
            set.add( toDto( serviceAction ) );
        }

        return set;
    }

    @Override
    public ServiceActionDTO toDto(ServiceAction serviceAction) {
        if ( serviceAction == null ) {
            return null;
        }

        ServiceActionDTO.Builder serviceActionDTO = ServiceActionDTO.builder();

        serviceActionDTO.workshopId( serviceActionWorkshopId( serviceAction ) );
        serviceActionDTO.workshopName( serviceActionWorkshopName( serviceAction ) );
        serviceActionDTO.vehicleId( serviceActionVehicleId( serviceAction ) );
        serviceActionDTO.vehicleRegistrationNumber( serviceActionVehicleRegistrationNumber( serviceAction ) );
        serviceActionDTO.id( serviceAction.getId() );
        serviceActionDTO.carMileage( serviceAction.getCarMileage() );
        serviceActionDTO.invoiceNumber( serviceAction.getInvoiceNumber() );
        serviceActionDTO.grossValue( serviceAction.getGrossValue() );
        serviceActionDTO.taxValue( serviceAction.getTaxValue() );
        serviceActionDTO.netValue( serviceAction.getNetValue() );
        serviceActionDTO.taxRate( serviceAction.getTaxRate() );
        serviceActionDTO.serviceDate( serviceAction.getServiceDate() );
        serviceActionDTO.description( serviceAction.getDescription() );
        serviceActionDTO.serviceActionTypes( serviceActionTypeSetToServiceActionTypeDTOSet( serviceAction.getServiceActionTypes() ) );
        serviceActionDTO.createDate( serviceAction.getCreateDate() );
        serviceActionDTO.modifyDate( serviceAction.getModifyDate() );
        serviceActionDTO.removeDate( serviceAction.getRemoveDate() );

        return serviceActionDTO.build();
    }

    @Override
    public ServiceAction toEntity(ServiceActionDTO serviceActionDTO) {
        if ( serviceActionDTO == null ) {
            return null;
        }

        ServiceAction serviceAction = new ServiceAction();

        serviceAction.setWorkshop( serviceActionDTOToWorkshop( serviceActionDTO ) );
        serviceAction.setVehicle( serviceActionDTOToVehicle( serviceActionDTO ) );
        serviceAction.setId( serviceActionDTO.getId() );
        serviceAction.setCarMileage( serviceActionDTO.getCarMileage() );
        serviceAction.setInvoiceNumber( serviceActionDTO.getInvoiceNumber() );
        serviceAction.setGrossValue( serviceActionDTO.getGrossValue() );
        serviceAction.setTaxValue( serviceActionDTO.getTaxValue() );
        serviceAction.setNetValue( serviceActionDTO.getNetValue() );
        serviceAction.setTaxRate( serviceActionDTO.getTaxRate() );
        serviceAction.setServiceDate( serviceActionDTO.getServiceDate() );
        serviceAction.setDescription( serviceActionDTO.getDescription() );
        serviceAction.setServiceActionTypes( serviceActionTypeDTOSetToServiceActionTypeSet( serviceActionDTO.getServiceActionTypes() ) );
        serviceAction.setCreateDate( serviceActionDTO.getCreateDate() );
        serviceAction.setModifyDate( serviceActionDTO.getModifyDate() );
        serviceAction.setRemoveDate( serviceActionDTO.getRemoveDate() );

        return serviceAction;
    }

    private Long serviceActionWorkshopId(ServiceAction serviceAction) {
        if ( serviceAction == null ) {
            return null;
        }
        Workshop workshop = serviceAction.getWorkshop();
        if ( workshop == null ) {
            return null;
        }
        Long id = workshop.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String serviceActionWorkshopName(ServiceAction serviceAction) {
        if ( serviceAction == null ) {
            return null;
        }
        Workshop workshop = serviceAction.getWorkshop();
        if ( workshop == null ) {
            return null;
        }
        String name = workshop.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long serviceActionVehicleId(ServiceAction serviceAction) {
        if ( serviceAction == null ) {
            return null;
        }
        Vehicle vehicle = serviceAction.getVehicle();
        if ( vehicle == null ) {
            return null;
        }
        Long id = vehicle.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String serviceActionVehicleRegistrationNumber(ServiceAction serviceAction) {
        if ( serviceAction == null ) {
            return null;
        }
        Vehicle vehicle = serviceAction.getVehicle();
        if ( vehicle == null ) {
            return null;
        }
        String registrationNumber = vehicle.getRegistrationNumber();
        if ( registrationNumber == null ) {
            return null;
        }
        return registrationNumber;
    }

    protected Set<ServiceActionTypeDTO> serviceActionTypeSetToServiceActionTypeDTOSet(Set<ServiceActionType> set) {
        if ( set == null ) {
            return null;
        }

        Set<ServiceActionTypeDTO> set1 = new LinkedHashSet<ServiceActionTypeDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ServiceActionType serviceActionType : set ) {
            set1.add( serviceActionTypeToServiceActionTypeDTO( serviceActionType ) );
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
        workshopDTO.serviceActionTypes( serviceActionTypeSetToServiceActionTypeDTOSet( workshop.getServiceActionTypes() ) );
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

    protected ServiceActionTypeDTO serviceActionTypeToServiceActionTypeDTO(ServiceActionType serviceActionType) {
        if ( serviceActionType == null ) {
            return null;
        }

        ServiceActionTypeDTO.Builder serviceActionTypeDTO = ServiceActionTypeDTO.builder();

        serviceActionTypeDTO.id( serviceActionType.getId() );
        serviceActionTypeDTO.name( serviceActionType.getName() );
        serviceActionTypeDTO.typeOfService( serviceActionType.getTypeOfService() );
        serviceActionTypeDTO.createDate( serviceActionType.getCreateDate() );
        serviceActionTypeDTO.modifyDate( serviceActionType.getModifyDate() );
        serviceActionTypeDTO.removeDate( serviceActionType.getRemoveDate() );
        serviceActionTypeDTO.workshops( workshopSetToWorkshopDTOSet( serviceActionType.getWorkshops() ) );

        return serviceActionTypeDTO.build();
    }

    protected Workshop serviceActionDTOToWorkshop(ServiceActionDTO serviceActionDTO) {
        if ( serviceActionDTO == null ) {
            return null;
        }

        Workshop workshop = new Workshop();

        workshop.setId( serviceActionDTO.getWorkshopId() );
        workshop.setName( serviceActionDTO.getWorkshopName() );

        return workshop;
    }

    protected Vehicle serviceActionDTOToVehicle(ServiceActionDTO serviceActionDTO) {
        if ( serviceActionDTO == null ) {
            return null;
        }

        Vehicle vehicle = new Vehicle();

        vehicle.setId( serviceActionDTO.getVehicleId() );
        vehicle.setRegistrationNumber( serviceActionDTO.getVehicleRegistrationNumber() );

        return vehicle;
    }

    protected Set<ServiceActionType> serviceActionTypeDTOSetToServiceActionTypeSet(Set<ServiceActionTypeDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<ServiceActionType> set1 = new LinkedHashSet<ServiceActionType>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ServiceActionTypeDTO serviceActionTypeDTO : set ) {
            set1.add( serviceActionTypeDTOToServiceActionType( serviceActionTypeDTO ) );
        }

        return set1;
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
        workshop.setServiceActionTypes( serviceActionTypeDTOSetToServiceActionTypeSet( workshopDTO.getServiceActionTypes() ) );
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

    protected ServiceActionType serviceActionTypeDTOToServiceActionType(ServiceActionTypeDTO serviceActionTypeDTO) {
        if ( serviceActionTypeDTO == null ) {
            return null;
        }

        ServiceActionType serviceActionType = new ServiceActionType();

        serviceActionType.setId( serviceActionTypeDTO.getId() );
        serviceActionType.setName( serviceActionTypeDTO.getName() );
        serviceActionType.setCreateDate( serviceActionTypeDTO.getCreateDate() );
        serviceActionType.setModifyDate( serviceActionTypeDTO.getModifyDate() );
        serviceActionType.setRemoveDate( serviceActionTypeDTO.getRemoveDate() );
        serviceActionType.setWorkshops( workshopDTOSetToWorkshopSet( serviceActionTypeDTO.getWorkshops() ) );
        serviceActionType.setTypeOfService( serviceActionTypeDTO.getTypeOfService() );

        return serviceActionType;
    }
}
