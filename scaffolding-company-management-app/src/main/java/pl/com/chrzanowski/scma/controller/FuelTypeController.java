package pl.com.chrzanowski.scma.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.com.chrzanowski.scma.controller.util.PaginationUtil;
import pl.com.chrzanowski.scma.exception.BadRequestAlertException;
import pl.com.chrzanowski.scma.exception.EmptyValueException;
import pl.com.chrzanowski.scma.exception.ObjectNotFoundException;
import pl.com.chrzanowski.scma.service.FuelTypeService;
import pl.com.chrzanowski.scma.service.dto.FuelTypeDTO;
import pl.com.chrzanowski.scma.service.filter.fueltype.FuelTypeFilter;

import java.util.List;

@RestController
@RequestMapping(path = "/api/fuelTypes")
public class FuelTypeController {
    private final Logger log = LoggerFactory.getLogger(FuelTypeController.class);

    private static final String ENTITY_NAME = "fuelType";

    private final FuelTypeService fuelTypeService;

    public FuelTypeController(FuelTypeService fuelTypeService) {
        this.fuelTypeService = fuelTypeService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<FuelTypeDTO>> getAllFuelTypes() {
        log.debug("REST request to get all fuelTypes");
        List<FuelTypeDTO> fuelTypeList = fuelTypeService.findAll();
        return ResponseEntity.ok().body(fuelTypeList);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<FuelTypeDTO>> getFuelTypesByFilter(FuelTypeFilter fuelTypeFilter) {
        log.debug("REST request to get fuelTypes by filter {}: ", fuelTypeFilter);
        List<FuelTypeDTO> fuelTypeDTOList = fuelTypeService.findByFilter(fuelTypeFilter);
        return ResponseEntity.ok().body(fuelTypeDTOList);
    }

    @GetMapping(path = "/page")
    public ResponseEntity<List<FuelTypeDTO>> getFuelTypesByFilterAndPage(FuelTypeFilter fuelTypeFilter,
                                                                         Pageable pageable) {
        log.debug("REST request to get fuelTypes by filter {}: ", fuelTypeFilter);
        Page<FuelTypeDTO> page = fuelTypeService.findByFilterAndPage(fuelTypeFilter, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequestUri(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<FuelTypeDTO> getFuelTypeById(@PathVariable Long id) {
        log.debug("REST request to get fuelType by id:  {}", id);
        FuelTypeDTO fuelTypeDTO = fuelTypeService.findById(id);
        return ResponseEntity.ok().body(fuelTypeDTO);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<FuelTypeDTO> addFuelType(@RequestBody FuelTypeDTO fuelTypeDTO) {
        log.debug("REST request to add new fuelType: {}", fuelTypeDTO);
        try {
            FuelTypeDTO newFuelTypeDTO = fuelTypeService.save(fuelTypeDTO);
            return ResponseEntity.ok().body(newFuelTypeDTO);
        } catch (EmptyValueException e) {
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "emptyFieldException");
        } catch (ObjectNotFoundException e) {
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "vehicleModelNotFound");
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<FuelTypeDTO> updateFuelType(@RequestBody FuelTypeDTO fuelTypeDTO) {
        log.debug("REST request to update fuelType: {}", fuelTypeDTO);
        try {
            FuelTypeDTO updatedFuelTypeDTO = fuelTypeService.update(fuelTypeDTO);
            return ResponseEntity.ok().body(updatedFuelTypeDTO);
        } catch (EmptyValueException e) {
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "emptyFieldException");
        } catch (ObjectNotFoundException e) {
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "vehicleModelNotFound");
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteFuelType(@PathVariable Long id) {
        log.debug("REST request to delete fuelType of id : {}", id);
        fuelTypeService.delete(id);
        return ResponseEntity.ok().build();
    }


}
