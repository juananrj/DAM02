package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    List<String> listMessages;

    @Autowired
    public GreetingService(List<String> listMessages) {
        this.listMessages = listMessages;
    }

    public List<String> getListMessages() {
        return listMessages;
    }

    public void addMessage(String msg) {
       listMessages.add(msg);
    }
}
