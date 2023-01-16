package pl.com.chrzanowski.scma.service.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.domain.Role;
import pl.com.chrzanowski.scma.model.RoleDTO;
import pl.com.chrzanowski.scma.repository.RoleRepository;
import pl.com.chrzanowski.scma.service.RoleService;
import pl.com.chrzanowski.scma.service.mapper.RoleMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    @Override
    public Set<Role> findAll() {
        log.info("Fetching all roles.");
        List<Role> roleList = roleRepository.findAll();
        return Set.copyOf(roleList);
    }

    @Override
    public Optional<Role> findByName(String name) {
        log.info("Fetching role {}", name);
        return roleRepository.findByName(name);
    }

    @Override
    public Role saveRole(RoleDTO roleDTO) {
        log.info("Adding new role {} to database", roleDTO.getName());
        return roleRepository.save(roleMapper.roleDTOtoRole(roleDTO));
    }
}
