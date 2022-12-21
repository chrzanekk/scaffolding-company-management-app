package pl.com.chrzanowski.scma.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.com.chrzanowski.scma.domain.Role;
import pl.com.chrzanowski.scma.model.RoleDTO;
import pl.com.chrzanowski.scma.service.RoleService;

import java.net.URI;
import java.util.Set;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/roles")
    public ResponseEntity<Set<Role>> getUsers() {
        return ResponseEntity.ok().body(roleService.findAll());
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody RoleDTO roleDTO) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(roleService.saveRole(roleDTO));
    }
}
