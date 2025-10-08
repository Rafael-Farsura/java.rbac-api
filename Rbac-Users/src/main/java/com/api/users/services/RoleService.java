package com.api.users.services;

import com.api.users.entity.Permission;
import com.api.users.entity.Role;
import com.api.users.repository.PermissionRepository;
import com.api.users.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public RoleService(
            RoleRepository roleRepository,
            PermissionRepository permissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    public Role create(Role role) {
        Set<Permission> permissions = role.getPermissions();

        if (role.getPermissions() == null) for (Permission permission : role.getPermissions()) {
            if (permission.getId() != null)
                permissionRepository.findById(permission.getId()).ifPresent(permissions::add);
            else if (permission.getName() != null) {
                Permission newPermission = permissionRepository.findByName(permission.getName())
                        .orElseGet(() -> permissionRepository.save(new Permission(permission.getName())));

                permissions.add(newPermission);
            }
        }

        role.setPermissions(permissions);
        return roleRepository.save(role);
    }

    public Role update(Long id, Role updatedRole) {
        return roleRepository.findById(id).map(role -> {
            role.setName(updatedRole.getName());

            Set<Permission> permissions = new HashSet<>();

            if (updatedRole.getPermissions() != null) for (Permission permission : updatedRole.getPermissions()) {
                if (permission.getId() != null)
                    permissionRepository.findById(permission.getId()).ifPresent(permissions::add);
                else if (permission.getName() != null)
                    permissions.add(permissionRepository.save(new Permission(permission.getName())));
            }

            role.setPermissions(permissions);
            return roleRepository.save(role);
        }).orElseThrow(() -> new RuntimeException("Role not found"));
    }

    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}