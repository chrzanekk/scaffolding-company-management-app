package pl.com.chrzanowski.scma.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.com.chrzanowski.scma.domain.Role;
import pl.com.chrzanowski.scma.domain.enumeration.ERole;
import pl.com.chrzanowski.scma.repository.RoleRepository;
import pl.com.chrzanowski.scma.service.RoleService;
import pl.com.chrzanowski.scma.service.dto.RoleDTO;
import pl.com.chrzanowski.scma.service.mapper.RoleMapper;
import pl.com.chrzanowski.scma.util.FieldValidator;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final Logger log = LoggerFactory.getLogger(RoleService.class);

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public Set<Role> findAll() {
        log.info("Fetching all roles.");
        List<Role> roleList = roleRepository.findAll();
        return Set.copyOf(roleList);
    }

    @Override
    public Optional<Role> findByName(ERole name) {
        log.info("Fetching role {}", name);
        return roleRepository.findByName(name);
    }

    @Override
    public Role saveRole(RoleDTO roleDTO) {
        log.info("Adding new role {} to database", roleDTO.getName());
        FieldValidator.validateObject(roleDTO, "roleDTO");
        FieldValidator.validateString(roleDTO.getName(), "Role name");
        return roleRepository.save(roleMapper.roleDTOtoRole(roleDTO));
    }
}
