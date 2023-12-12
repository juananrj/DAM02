package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(GreetingController.GREETING)
public class GreetingController {
    public static final String GREETING = "/greeting";

    @Value("exemple value")
    private String valor;

    /*private ArrayList<String> listMessages;
     @Autowired
    public GreetingController(ArrayList<String> listMessages) {
        this.listMessages = listMessages;
    }*/

    @GetMapping()
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        //listMessages.add(name)
        greetingService.addMessage(name);
        model.addAttribute("name", greetingService.getListMessages());
        return "greeting";
    }

    @GetMapping("/exemple")
    public String valor(Model model) {
    model.addAttribute("name", valor);
    return "greeting";
    }
    @Autowired
    private GreetingService greetingService;
}

