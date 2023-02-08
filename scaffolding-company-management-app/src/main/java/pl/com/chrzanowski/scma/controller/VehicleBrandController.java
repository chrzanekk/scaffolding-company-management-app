package pl.com.chrzanowski.scma.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.com.chrzanowski.scma.service.VehicleBrandService;
import pl.com.chrzanowski.scma.service.dto.VehicleBrandDTO;
import pl.com.chrzanowski.scma.service.filter.vehiclebrand.VehicleBrandFilter;

import java.util.List;

@RestController
@RequestMapping(path = "/api/vehicleBrands")
public class VehicleBrandController {

    private final Logger log = LoggerFactory.getLogger(VehicleBrandController.class);
    private static final String ENTITY_NAME = "vehicleBrand";
    private final VehicleBrandService vehicleBrandService;

    public VehicleBrandController(VehicleBrandService vehicleBrandService) {
        this.vehicleBrandService = vehicleBrandService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<VehicleBrandDTO>> getAllVehicleBrands() {
        log.debug("REST request to get all vehicleBrands");
        List<VehicleBrandDTO> vehicleBrandDTOList = vehicleBrandService.findAll();
        return new ResponseEntity<>(vehicleBrandDTOList, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<VehicleBrandDTO>> getAllVehicleBrandsByFilter(VehicleBrandFilter vehicleBrandFilter) {
        log.debug("REST request to get all vehicleBrands by filter: {}", vehicleBrandFilter);
        List<VehicleBrandDTO> vehicleBrandDTOList = vehicleBrandService.find(vehicleBrandFilter);
        return new ResponseEntity<>(vehicleBrandDTOList, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<VehicleBrandDTO> getVehicleBrandById(@PathVariable Long id) {
        log.debug("REST request to get vehicleBrand by id: {}", id);
        VehicleBrandDTO vehicleBrandDTO = vehicleBrandService.findById(id);
        return new ResponseEntity<>(vehicleBrandDTO, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<VehicleBrandDTO> addVehicleBrand(@RequestBody VehicleBrandDTO vehicleBrandDTO) {
        log.debug("REST request to add new vehicleBrand: {}", vehicleBrandDTO);
        VehicleBrandDTO newVehicleBrandDTO = vehicleBrandService.save(vehicleBrandDTO);
        return new ResponseEntity<>(newVehicleBrandDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<VehicleBrandDTO> updateVehicleBrand(@RequestBody VehicleBrandDTO vehicleBrandDTO) {
        log.debug("RST request to update vehicleBrand: {}", vehicleBrandDTO);
        VehicleBrandDTO updatedVehicleBrandDTO = vehicleBrandService.update(vehicleBrandDTO);
        return new ResponseEntity<>(updatedVehicleBrandDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVehicleBrand(@PathVariable Long id) {
        log.debug("REST request to delete vehicleBrand of id: {}", id);
        vehicleBrandService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
