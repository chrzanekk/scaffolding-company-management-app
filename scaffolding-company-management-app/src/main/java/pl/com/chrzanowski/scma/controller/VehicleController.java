package pl.com.chrzanowski.scma.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.chrzanowski.scma.service.VehicleService;

@RestController
@RequestMapping(path = "/api/vehicles")
public class VehicleController {

    private final Logger log = LoggerFactory.getLogger(VehicleController.class);
    private static final String ENTITY_NAME = "vehicle";
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
}
