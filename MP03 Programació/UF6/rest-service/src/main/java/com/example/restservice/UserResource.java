package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserResource.USERS)
public class UserResource {
    public static final String USERS = "v1/users";

    @Autowired
    UserController userController;

    @GetMapping
    public List<User> getUsers() {
        return userController.readAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return userController.getUserById(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userController.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userController.deleteUser(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        userController.updateUser(id, updatedUser);
    }

    @PatchMapping("/{id}")
    public void partiallyUpdateUser(@PathVariable Integer id, @RequestBody User partialUser) {
        userController.partiallyUpdateUser(id, partialUser);
    }
}
