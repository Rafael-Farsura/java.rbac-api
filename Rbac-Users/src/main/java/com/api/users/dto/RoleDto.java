package com.api.users.dto;

import java.util.Objects;
import java.util.Set;

public class RoleDto {
    private Long id;
    private String name;
    private Set<PermissionDto> permissions;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<PermissionDto> getPermissions() { return permissions; }

    @Override
    public String toString() {
        return "RoleDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", permissions=" + permissions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RoleDto roleDto = (RoleDto) o;
        return Objects.equals(id, roleDto.id) && Objects.equals(name, roleDto.name) && Objects.equals(permissions, roleDto.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, permissions);
    }

    public void setPermissions(Set<PermissionDto> permissions) { this.permissions = permissions; }
}
