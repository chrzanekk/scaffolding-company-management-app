package pl.com.chrzanowski.scma.service.impl;

import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.model.FuelTypeDTO;
import pl.com.chrzanowski.scma.service.FuelTypeService;
import pl.com.chrzanowski.scma.service.filter.FuelTypeFilter;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FuelTypeServiceImpl implements FuelTypeService {
    @Override
    public List<FuelTypeDTO> find(FuelTypeFilter fuelTypeFilter) {
        return null;
    }
}
