package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    public List<User> readAll(){
        return userService.readAllUsers();

    }


    public User getUserById(Integer id) {
        Optional<User> optionalUser;
        optionalUser = userService.readAllUsers().stream().filter(u -> u.id() == id).findFirst();
        if(optionalUser.isPresent()) return optionalUser.get();
        else return null;
    }

    public void addUser(User user){
        userService.addUser(user);
    }

    public void deleteUser (Integer id){
        userService.removeUser(id);
    }
}
