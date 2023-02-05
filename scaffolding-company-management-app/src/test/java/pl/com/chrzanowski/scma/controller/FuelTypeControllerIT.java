package pl.com.chrzanowski.scma.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import pl.com.chrzanowski.scma.ScaffoldingCompanyManagementAppApplication;
import pl.com.chrzanowski.scma.domain.FuelType;
import pl.com.chrzanowski.scma.repository.FuelTypeRepository;
import pl.com.chrzanowski.scma.service.impl.FuelTypeServiceImpl;
import pl.com.chrzanowski.scma.service.mapper.FuelTypeMapper;
import javax.persistence.EntityManager;

@SpringBootTest(classes = ScaffoldingCompanyManagementAppApplication.class)
@AutoConfigureMockMvc
public class FuelTypeControllerIT {

    private static final String DEFAULT_NAME = "firstDefaultFuelType";
    private static final String UPDATED_NAME = "firstUpdatedFuelType";

    @Autowired
    private FuelTypeRepository fuelTypeRepository;
    @Autowired
    private FuelTypeServiceImpl fuelTypeService;
    @Autowired
    private FuelTypeMapper fuelTypeMapper;
    @Autowired
    private EntityManager em;
    private FuelType fuelType;

}
