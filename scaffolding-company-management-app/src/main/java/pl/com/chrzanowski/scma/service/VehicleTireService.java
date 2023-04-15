package pl.com.chrzanowski.scma.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.com.chrzanowski.scma.service.dto.VehicleDTO;
import pl.com.chrzanowski.scma.service.dto.VehicleTireDTO;
import pl.com.chrzanowski.scma.service.filter.vehicle.VehicleFilter;

import java.util.List;

public interface VehicleTireService {


    VehicleTireDTO save(VehicleTireDTO vehicleDTO);

    VehicleTireDTO update(VehicleTireDTO vehicleDTO);

    List<VehicleTireDTO> findByFilter(VehicleFilter filter);

    Page<VehicleTireDTO> findByFilterAndPage(VehicleFilter filter, Pageable pageable);

    VehicleTireDTO findById(Long id);

    List<VehicleTireDTO> findAll();

    void delete(Long id);
}
