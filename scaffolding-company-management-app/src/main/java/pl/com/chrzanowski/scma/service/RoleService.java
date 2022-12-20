package pl.com.chrzanowski.scma.service;

import pl.com.chrzanowski.scma.domain.Role;
import pl.com.chrzanowski.scma.domain.enumeration.ERole;

import java.util.Optional;
import java.util.Set;

public interface RoleService {

    Set<Role> findAll();

    Optional<Role> findByName(ERole name);
}
