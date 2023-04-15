package pl.com.chrzanowski.scma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.com.chrzanowski.scma.domain.VehicleTire;

@Repository
public interface VehicleTireRepository extends JpaRepository<VehicleTire, Long>, JpaSpecificationExecutor<VehicleTire> {

    void deleteByVehicleTireId(Long id);

}

