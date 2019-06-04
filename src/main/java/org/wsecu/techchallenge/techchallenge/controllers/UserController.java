package org.wsecu.techchallenge.techchallenge.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.wsecu.techchallenge.techchallenge.domain.User;
import org.wsecu.techchallenge.techchallenge.services.UserService;

import java.util.List;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public static final String BASE_URL = "/api/v1/users";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        User existingUser = userService.findUserByUsername(user.getUsername());

        if (existingUser == null) {
            return userService.createUser(user);
        }
        else {
            return existingUser;
        }

    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User existingUser = userService.findUserByUsername(user.getUsername());

        if (existingUser == null) {
            return ResponseEntity.badRequest().body(existingUser);
        }
        else {
            return ResponseEntity.ok(userService.updateUser(user));
        }

    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removeUser(@PathVariable String username) {
        userService.deleteUser(username);
    }
}
