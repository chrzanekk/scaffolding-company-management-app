package pl.com.chrzanowski.scma.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.com.chrzanowski.scma.model.FuelTypeDTO;
import pl.com.chrzanowski.scma.service.FuelTypeService;
import pl.com.chrzanowski.scma.service.filter.FuelTypeFilter;
import pl.com.chrzanowski.scma.service.impl.FuelTypeServiceImpl;
import pl.com.chrzanowski.scma.service.mapper.FuelTypeMapper;

import java.util.List;

@RestController
@RequestMapping(path = "/api/fuelTypes")
public class FuelTypeController {
    private final Logger log = LoggerFactory.getLogger(FuelTypeServiceImpl.class);

    private static final String ENTITY_NAME = "fuelType";

    private final FuelTypeService fuelTypeService;
    private final FuelTypeMapper fuelTypeMapper;

    // todo create endpoint to get all fuel types with pagination
    public FuelTypeController(FuelTypeService fuelTypeService, FuelTypeMapper fuelTypeMapper) {
        this.fuelTypeService = fuelTypeService;
        this.fuelTypeMapper = fuelTypeMapper;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FuelTypeDTO>> getAllFuelTypes() {
        log.debug("REST request to get all fuelTypes");
        List<FuelTypeDTO> fuelTypeList = fuelTypeService.findAll();
        return new ResponseEntity<>(fuelTypeList, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FuelTypeDTO>> getFuelTypesByFilter(FuelTypeFilter fuelTypeFilter) {
        log.debug("REST request to get fuelTypes by filter {}: ", fuelTypeFilter);
        List<FuelTypeDTO> fuelTypeDTOList = fuelTypeService.find(fuelTypeFilter);
        return new ResponseEntity<>(fuelTypeDTOList, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<FuelTypeDTO> getFuelTypeById(@PathVariable Long id) {
        log.debug("REST request to get fuelType by id:  {}", id);
        FuelTypeDTO fuelTypeDTO = fuelTypeService.findById(id);
        return new ResponseEntity<>(fuelTypeDTO, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<FuelTypeDTO> addFuelType(@RequestBody FuelTypeDTO fuelTypeDTO) {
        log.debug("REST request to add new fuelType: {}", fuelTypeDTO);
        FuelTypeDTO newFuelTypeDTO = fuelTypeService.save(fuelTypeDTO);
        return new ResponseEntity<>(newFuelTypeDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<FuelTypeDTO> updateFuelType(@RequestBody FuelTypeDTO fuelTypeDTO) {
        log.debug("REST request to add new fuelType: {}", fuelTypeDTO);
        FuelTypeDTO updatedFuelTypeDTO = fuelTypeService.update(fuelTypeDTO);
        return new ResponseEntity<>(updatedFuelTypeDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFuelType(@PathVariable Long id) {
        log.debug("REST request to delete fuelType of id : {}", id);
        fuelTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
