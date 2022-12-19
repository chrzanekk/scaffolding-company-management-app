package pl.com.chrzanowski.scma.service;

import pl.com.chrzanowski.scma.domain.Role;

import java.util.Optional;
import java.util.Set;

public interface RoleService {

    Set<Role> findAll();
    Optional<Role> findByName(String name);
}
