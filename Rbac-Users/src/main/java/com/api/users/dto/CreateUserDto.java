package com.api.users.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;


public class CreateUserDto {

    @Size(min = 5, max = 20, message = "username must be between 5 and 20")
    @NotBlank(message = "usename could not be empty")
    private String username;

    @NotBlank
    @Size(min = 6, max = 20, message = "pswrd must be between 6 and 20 char")
    private String password;

    private Set<String> roles;


    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Set<String> getRoles() { return roles; }
    public void setRoles(Set<String> roles) { this.roles = roles; }
}