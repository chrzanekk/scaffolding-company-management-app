package pl.com.chrzanowski.scma.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.com.chrzanowski.scma.service.VehicleTypeService;
import pl.com.chrzanowski.scma.service.dto.VehicleTypeDTO;
import pl.com.chrzanowski.scma.service.filter.vehicletype.VehicleTypeFilter;

import java.util.List;

@RestController
@RequestMapping(path = "/api/vehicleTypes")
public class VehicleTypeController {

    private final Logger log = LoggerFactory.getLogger(VehicleTypeController.class);
    private static final String ENTITY_NAME = "vehicleType";
    private final VehicleTypeService vehicleTypeService;

    public VehicleTypeController(VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<VehicleTypeDTO>> getAllVehicleTypes() {
        log.debug("REST request to get all vehicleTypes");
        List<VehicleTypeDTO> vehicleTypeDTOList = vehicleTypeService.findAll();
        return new ResponseEntity<>(vehicleTypeDTOList, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<VehicleTypeDTO>> getAllVehicleTypesByFilter(VehicleTypeFilter vehicleTypeFilter) {
        log.debug("REST request to get all vehicleTypes by filter: {}", vehicleTypeFilter);
        List<VehicleTypeDTO> vehicleTypeDTOList = vehicleTypeService.find(vehicleTypeFilter);
        return new ResponseEntity<>(vehicleTypeDTOList, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<VehicleTypeDTO> getVehicleTypeById(@PathVariable Long id) {
        log.debug("REST request to get vehicleType by id: {}", id);
        VehicleTypeDTO vehicleTypeDTO = vehicleTypeService.findById(id);
        return new ResponseEntity<>(vehicleTypeDTO, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<VehicleTypeDTO> addVehicleType(@RequestBody VehicleTypeDTO vehicleTypeDTO) {
        log.debug("REST request to add new vehicleType: {}", vehicleTypeDTO);
        VehicleTypeDTO newVehicleTypeDTO = vehicleTypeService.save(vehicleTypeDTO);
        return new ResponseEntity<>(newVehicleTypeDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<VehicleTypeDTO> updateVehicleType(@RequestBody VehicleTypeDTO vehicleTypeDTO) {
        log.debug("RST request to update vehicleType: {}", vehicleTypeDTO);
        VehicleTypeDTO updatedVehicleTypeDTO = vehicleTypeService.update(vehicleTypeDTO);
        return new ResponseEntity<>(updatedVehicleTypeDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVehicleType(@PathVariable Long id) {
        log.debug("REST request to delete vehicleType of id: {}", id);
        vehicleTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
