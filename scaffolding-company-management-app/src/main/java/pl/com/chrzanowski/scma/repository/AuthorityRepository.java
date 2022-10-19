package pl.com.chrzanowski.scma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.chrzanowski.scma.model.Authority;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByName(String name);
}
