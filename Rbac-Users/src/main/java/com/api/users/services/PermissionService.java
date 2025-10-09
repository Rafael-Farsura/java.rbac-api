package com.api.users.services;

import com.api.users.entity.Permission;
import com.api.users.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;

    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    public Optional<Permission> findById(Long id) {
        return permissionRepository.findById(id);
    }

    public Permission create(Permission permission) {
        return permissionRepository.save(permission);
    }

    public Permission update(Long id, Permission updatedPermission) {
        return permissionRepository.findById(id).map(permission -> {
            permission.setName(updatedPermission.getName());
            return permissionRepository.save(permission);
        }).orElseThrow(() -> new RuntimeException("Permission not found"));
    }

    public void delete(Long id) {
        permissionRepository.deleteById(id);
    }
}