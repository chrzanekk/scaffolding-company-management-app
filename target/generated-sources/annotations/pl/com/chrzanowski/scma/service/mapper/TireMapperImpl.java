package pl.com.chrzanowski.scma.service.mapper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.chrzanowski.scma.domain.Tire;
import pl.com.chrzanowski.scma.domain.Vehicle;
import pl.com.chrzanowski.scma.service.dto.TireDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-25T17:42:39+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class TireMapperImpl implements TireMapper {

    @Autowired
    private VehicleMapper vehicleMapper;

    @Override
    public List<Tire> toEntity(List<TireDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Tire> list = new ArrayList<Tire>( dtoList.size() );
        for ( TireDTO tireDTO : dtoList ) {
            list.add( toEntity( tireDTO ) );
        }

        return list;
    }

    @Override
    public List<TireDTO> toDto(List<Tire> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TireDTO> list = new ArrayList<TireDTO>( entityList.size() );
        for ( Tire tire : entityList ) {
            list.add( toDto( tire ) );
        }

        return list;
    }

    @Override
    public Set<Tire> toEntity(Set<TireDTO> dtoSet) {
        if ( dtoSet == null ) {
            return null;
        }

        Set<Tire> set = new LinkedHashSet<Tire>( Math.max( (int) ( dtoSet.size() / .75f ) + 1, 16 ) );
        for ( TireDTO tireDTO : dtoSet ) {
            set.add( toEntity( tireDTO ) );
        }

        return set;
    }

    @Override
    public Set<TireDTO> toDto(Set<Tire> entitySet) {
        if ( entitySet == null ) {
            return null;
        }

        Set<TireDTO> set = new LinkedHashSet<TireDTO>( Math.max( (int) ( entitySet.size() / .75f ) + 1, 16 ) );
        for ( Tire tire : entitySet ) {
            set.add( toDto( tire ) );
        }

        return set;
    }

    @Override
    public TireDTO toDto(Tire tire) {
        if ( tire == null ) {
            return null;
        }

        TireDTO.Builder tireDTO = TireDTO.builder();

        tireDTO.vehicleId( tireVehicleId( tire ) );
        tireDTO.id( tire.getId() );
        tireDTO.brand( tire.getBrand() );
        tireDTO.model( tire.getModel() );
        tireDTO.width( tire.getWidth() );
        tireDTO.profile( tire.getProfile() );
        tireDTO.diameter( tire.getDiameter() );
        tireDTO.type( tire.getType() );
        tireDTO.tireReinforcedIndex( tire.getTireReinforcedIndex() );
        tireDTO.speedIndex( tire.getSpeedIndex() );
        tireDTO.capacityIndex( tire.getCapacityIndex() );
        tireDTO.tireSeasonType( tire.getTireSeasonType() );
        tireDTO.runOnFlat( tire.getRunOnFlat() );
        tireDTO.productionYear( tire.getProductionYear() );
        tireDTO.purchaseDate( tire.getPurchaseDate() );
        tireDTO.tireStatus( tire.getTireStatus() );
        tireDTO.createDate( tire.getCreateDate() );
        tireDTO.modifyDate( tire.getModifyDate() );
        tireDTO.removeDate( tire.getRemoveDate() );

        return tireDTO.build();
    }

    @Override
    public Tire toEntity(TireDTO tireDTO) {
        if ( tireDTO == null ) {
            return null;
        }

        Tire tire = new Tire();

        tire.setVehicle( vehicleMapper.fromId( tireDTO.getVehicleId() ) );
        tire.setId( tireDTO.getId() );
        tire.setBrand( tireDTO.getBrand() );
        tire.setModel( tireDTO.getModel() );
        tire.setWidth( tireDTO.getWidth() );
        tire.setProfile( tireDTO.getProfile() );
        tire.setDiameter( tireDTO.getDiameter() );
        tire.setType( tireDTO.getType() );
        tire.setTireReinforcedIndex( tireDTO.getTireReinforcedIndex() );
        tire.setSpeedIndex( tireDTO.getSpeedIndex() );
        tire.setCapacityIndex( tireDTO.getCapacityIndex() );
        tire.setTireSeasonType( tireDTO.getTireSeasonType() );
        tire.setRunOnFlat( tireDTO.getRunOnFlat() );
        tire.setTireStatus( tireDTO.getTireStatus() );
        tire.setProductionYear( tireDTO.getProductionYear() );
        tire.setPurchaseDate( tireDTO.getPurchaseDate() );
        tire.setCreateDate( tireDTO.getCreateDate() );
        tire.setModifyDate( tireDTO.getModifyDate() );
        tire.setRemoveDate( tireDTO.getRemoveDate() );

        return tire;
    }

    private Long tireVehicleId(Tire tire) {
        if ( tire == null ) {
            return null;
        }
        Vehicle vehicle = tire.getVehicle();
        if ( vehicle == null ) {
            return null;
        }
        Long id = vehicle.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
