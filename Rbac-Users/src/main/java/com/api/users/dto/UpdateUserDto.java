package com.api.users.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;


public class UpdateUserDto {
    @NotBlank(message = "username cannot be empty")
    @Size(min = 5, max = 20, message = "username must be between 5 n 20 characters")
    private String username;

    @Size(min = 6, max = 20, message = "passsword must be between 6 n 20 characters")
    private String password;

    private Set<String> roles;


    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Set<String> getRoles() { return roles; }
    public void setRoles(Set<String> roles) { this.roles = roles; }
}