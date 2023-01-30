package pl.com.chrzanowski.scma.service;

import pl.com.chrzanowski.scma.model.FuelTypeDTO;
import pl.com.chrzanowski.scma.service.filter.FuelTypeFilter;

import java.util.List;

public interface FuelTypeService {

    List<FuelTypeDTO> find(FuelTypeFilter fuelTypeFilter);
}
