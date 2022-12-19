package pl.com.chrzanowski.scma.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.domain.Role;
import pl.com.chrzanowski.scma.repository.RoleRepository;
import pl.com.chrzanowski.scma.service.RoleService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Set<Role> findAll() {
        List<Role> roleList = roleRepository.findAll();
        return Set.copyOf(roleList);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }
}
