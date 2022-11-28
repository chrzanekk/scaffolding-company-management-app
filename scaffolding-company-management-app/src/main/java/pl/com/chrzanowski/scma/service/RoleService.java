package pl.com.chrzanowski.scma.service;

import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.model.ERole;
import pl.com.chrzanowski.scma.model.Role;

import java.util.Optional;

public interface RoleService {

    Optional<Role> findByName(ERole name);
}
