package com.example.consumingrest;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChuckService {
    RestTemplate restTemplate = new RestTemplate();

    public ChuckQuote getChuckQuote(){
        ChuckQuote q;
        q = restTemplate.getForObject("https://api.chucknorris.io/jokes/random", ChuckQuote.class);
        return q;
    }
}
