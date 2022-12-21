package pl.com.chrzanowski.scma.service;

import pl.com.chrzanowski.scma.domain.Role;
import pl.com.chrzanowski.scma.model.RoleDTO;

import java.util.Optional;
import java.util.Set;

public interface RoleService {

    Set<Role> findAll();

    Optional<Role> findByName(String name);

    Role saveRole(RoleDTO roleDTO);
}
