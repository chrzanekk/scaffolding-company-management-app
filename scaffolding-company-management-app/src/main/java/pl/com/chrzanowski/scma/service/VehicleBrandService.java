package pl.com.chrzanowski.scma.service;

import pl.com.chrzanowski.scma.service.dto.VehicleBrandDTO;
import pl.com.chrzanowski.scma.service.filter.vehiclebrand.VehicleBrandFilter;

import java.util.List;

public interface VehicleBrandService {

    VehicleBrandDTO save(VehicleBrandDTO vehicleBrandDTO);

    VehicleBrandDTO update(VehicleBrandDTO vehicleBrandDTO);

    List<VehicleBrandDTO> find(VehicleBrandFilter vehicleBrandFilter);

    VehicleBrandDTO findById(Long id);

    List<VehicleBrandDTO> findAll();

    void delete(Long id);
}
