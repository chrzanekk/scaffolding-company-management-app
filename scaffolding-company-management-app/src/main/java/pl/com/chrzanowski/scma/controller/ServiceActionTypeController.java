package pl.com.chrzanowski.scma.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.com.chrzanowski.scma.service.ServiceActionTypeService;
import pl.com.chrzanowski.scma.service.dto.ServiceActionTypeDTO;
import pl.com.chrzanowski.scma.service.filter.serviceactiontype.ServiceActionTypeFilter;

import java.util.List;

@RestController
@RequestMapping(path = "/api/serviceActionTypes")
public class ServiceActionTypeController {

    private final Logger log = LoggerFactory.getLogger(ServiceActionTypeController.class);
    private static final String ENTITY_NAME = "serviceActionType";
    private final ServiceActionTypeService serviceActionTypeService;

    public ServiceActionTypeController(ServiceActionTypeService serviceActionTypeService) {
        this.serviceActionTypeService = serviceActionTypeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ServiceActionTypeDTO>> getAllServiceTypes() {
        log.debug("REST request to get all serviceActionTypes");
        List<ServiceActionTypeDTO> serviceActionTypeDTOList = serviceActionTypeService.findAll();
        return new ResponseEntity<>(serviceActionTypeDTOList, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ServiceActionTypeDTO>> getAllServiceTypesByFilter(ServiceActionTypeFilter serviceActionTypeFilter) {
        log.debug("REST request to get all serviceActionTypes by filter: {}", serviceActionTypeFilter);
        List<ServiceActionTypeDTO> serviceActionTypeDTOList = serviceActionTypeService.find(serviceActionTypeFilter);
        return new ResponseEntity<>(serviceActionTypeDTOList, HttpStatus.OK);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<ServiceActionTypeDTO> getServiceActionTypeById(@PathVariable Long id) {
        log.debug("REST request to get serviceActionType by id: {}", id);
        ServiceActionTypeDTO serviceActionTypeDTO = serviceActionTypeService.findById(id);
        return new ResponseEntity<>(serviceActionTypeDTO, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ServiceActionTypeDTO> addServiceActionType(@RequestBody ServiceActionTypeDTO serviceActionTypeDTO) {
        log.debug("REST request to add new serviceActionType: {}", serviceActionTypeDTO);
        ServiceActionTypeDTO newServiceActionTypeDTO = serviceActionTypeService.save(serviceActionTypeDTO);
        return new ResponseEntity<>(newServiceActionTypeDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ServiceActionTypeDTO> updateServiceActionType(@RequestBody ServiceActionTypeDTO serviceActionTypeDTO) {
        log.debug("REST request to update new serviceActionType: {}", serviceActionTypeDTO);
        ServiceActionTypeDTO updatedServiceActionTypeDTO = serviceActionTypeService.update(serviceActionTypeDTO);
        return new ResponseEntity<>(updatedServiceActionTypeDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteServiceType(@PathVariable Long id) {
        log.debug("REST request to delete serviceType by id: {}", id);
        serviceActionTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
