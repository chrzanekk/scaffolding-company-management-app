package pl.com.chrzanowski.scma.service.impl;


import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.model.ERole;
import pl.com.chrzanowski.scma.model.Role;
import pl.com.chrzanowski.scma.repository.RoleRepository;
import pl.com.chrzanowski.scma.service.RoleService;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findByName(ERole name) {
        return roleRepository.findByName(name);
    }
}
