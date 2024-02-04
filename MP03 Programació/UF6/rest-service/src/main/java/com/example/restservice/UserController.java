package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    public List<User> readAll() {
        return userService.readAllUsers();
    }

    public User getUserById(Integer id) {
        Optional<User> optionalUser = userService.readAllUsers().stream().filter(u -> u.id().equals(id)).findFirst();
        return optionalUser.orElse(null);
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public void deleteUser(Integer id) {
        userService.removeUser(id);
    }

    public void updateUser(Integer id, User updatedUser) {
        userService.updateUser(id, updatedUser);
    }

    public void partiallyUpdateUser(Integer id, User partialUser) {
        userService.partiallyUpdateUser(id, partialUser);
    }
}
