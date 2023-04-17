package pl.com.chrzanowski.scma.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.com.chrzanowski.scma.service.dto.VehicleTireDTO;
import pl.com.chrzanowski.scma.service.filter.vehicletire.VehicleTireFilter;

import java.util.List;

public interface VehicleTireService {


    VehicleTireDTO save(VehicleTireDTO vehicleTireDTO);

    VehicleTireDTO update(VehicleTireDTO vehicleTireDTO);

    List<VehicleTireDTO> findByFilter(VehicleTireFilter filter);

    Page<VehicleTireDTO> findByFilterAndPage(VehicleTireFilter filter, Pageable pageable);

    VehicleTireDTO findById(Long id);

    List<VehicleTireDTO> findAll();

    void delete(Long id);
}
