package com.example.restservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    List<User> userList = new ArrayList<>();

    public UserService() {
        userList.add(new User(1, "pere@gmail.com", "Pere Garcia", "123456"));
        userList.add(new User(2, "maria@gmail.com", "Maria Perez", "654321"));
    }

    public List<User> readAllUsers() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void removeUser(Integer id) {
        userList.removeIf(u -> u.id().equals(id));
    }

    public void updateUser(Integer id, User updatedUser) {
        Optional<User> optionalUser = userList.stream().filter(u -> u.id().equals(id)).findFirst();
        optionalUser.ifPresent(user -> {
            userList.remove(user);
            userList.add(updatedUser);
        });
    }

    public void partiallyUpdateUser(Integer id, User partialUser) {
        Optional<User> optionalUser = userList.stream().filter(u -> u.id().equals(id)).findFirst();
        optionalUser.ifPresent(user -> {
            if (partialUser.email() != null) {
                user = user.withEmail(partialUser.email());
            }
            if (partialUser.fullName() != null) {
                user = user.withFullName(partialUser.fullName());
            }
            if (partialUser.password() != null) {
                user = user.withPassword(partialUser.password());
            }
            userList.removeIf(u -> u.id().equals(id));
            userList.add(user);
        });
    }

}
