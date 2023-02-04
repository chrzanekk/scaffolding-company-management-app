package pl.com.chrzanowski.scma.service;

import pl.com.chrzanowski.scma.model.FuelTypeDTO;
import pl.com.chrzanowski.scma.service.filter.FuelTypeFilter;

import java.util.List;

public interface FuelTypeService {
    FuelTypeDTO save (FuelTypeDTO fuelTypeDTO);
    FuelTypeDTO update(FuelTypeDTO fuelTypeDTO);
    List<FuelTypeDTO> find(FuelTypeFilter fuelTypeFilter);
    FuelTypeDTO findById(Long id);
    List<FuelTypeDTO> findAll();
}
