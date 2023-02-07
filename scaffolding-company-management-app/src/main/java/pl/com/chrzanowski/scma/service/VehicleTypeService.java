package pl.com.chrzanowski.scma.service;

import pl.com.chrzanowski.scma.service.dto.VehicleTypeDTO;
import pl.com.chrzanowski.scma.service.filter.vehicletype.VehicleTypeFilter;

import java.util.List;

public interface VehicleTypeService {

    VehicleTypeDTO save(VehicleTypeDTO vehicleTypeDTO);

    VehicleTypeDTO update(VehicleTypeDTO vehicleTypeDTO);

    List<VehicleTypeDTO> find(VehicleTypeFilter vehicleTypeFilter);

    VehicleTypeDTO findById(Long id);

    List<VehicleTypeDTO> findAll();

    void delete(Long id);
}
