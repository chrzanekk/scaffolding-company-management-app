package pl.com.chrzanowski.scma.service;

import pl.com.chrzanowski.scma.model.FuelTypeDTO;
import pl.com.chrzanowski.scma.service.filter.FuelTypeCriteria;

import java.util.List;

public interface FuelTypeService {

    List<FuelTypeDTO> find(FuelTypeCriteria fuelTypeFilter);
}
