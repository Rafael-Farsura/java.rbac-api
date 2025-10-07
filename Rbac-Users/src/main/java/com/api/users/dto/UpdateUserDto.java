package com.api.users.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.Set;

public class UpdateUserDto {
    @NotBlank
    @Size(min = 1, max = 100)
    Long id;

    @Size(min = 5, max = 20)
    private String username;

    @Override
    public String toString() {
        return "UpdateUserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleIds=" + roleIds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UpdateUserDto that = (UpdateUserDto) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(roleIds, that.roleIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, roleIds);
    }

    @Size(min = 6, max = 20)
    private String password;

    private Set<Long> roleIds;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Set<Long> getRoleIds() { return roleIds; }
    public void setRoleIds(Set<Long> roleIds) { this.roleIds = roleIds; }
}
