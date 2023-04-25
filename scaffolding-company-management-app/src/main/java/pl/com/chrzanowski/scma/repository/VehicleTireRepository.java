package pl.com.chrzanowski.scma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.chrzanowski.scma.domain.VehicleTire;
import pl.com.chrzanowski.scma.service.dto.VehicleTireDTO;

@Repository
public interface VehicleTireRepository extends JpaRepository<VehicleTire, VehicleTireDTO> {

    void deleteVehicleTireById(Long id);
}
