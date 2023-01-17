package pl.com.chrzanowski.scma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.chrzanowski.scma.domain.FuelType;

public interface FuelTypeRepository extends JpaRepository<FuelType,Long> {
}
