package com.api.users.controller;

import com.api.users.dto.CreateUserDto;
import com.api.users.dto.UpdateUserDto;
import com.api.users.entity.*;
import com.api.users.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        try {
            return ResponseEntity.ok(userService.findAll());
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        try {
        return userService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * It creates a User Entity.
     *
     * @param username: e.g.: "myUserName"
     * @param password: e.g.: "my password"
     * @param roleIds:  e.g.: [1, 2, 3]
     * @return User => {"myUserName", "my password", "[1, 2, 3]"}
     */
    @PostMapping
    public ResponseEntity<User> create(@RequestBody CreateUserDto dto) {
        try {
            return ResponseEntity.ok(userService.create(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UpdateUserDto dto) {
        try {
            return ResponseEntity.ok(userService.update(id, dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            userService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}