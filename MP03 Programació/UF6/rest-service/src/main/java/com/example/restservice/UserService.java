package com.example.restservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> llistaUsers = new ArrayList<>();

    public UserService(){
        llistaUsers.add(new User(1,"pere@gmail.com", "Pere Garcia", "123456"));
        llistaUsers.add(new User(2,"maria@gmail.com", "Maria Perez", "654321"));
    }
    public List<User> readAllUsers(){
        return llistaUsers;
    }

    public void addUser(User user){
        llistaUsers.add(user);
    }

    public void removeUser(Integer id){
        llistaUsers.removeIf(u -> u.id() == id);
    }
}
