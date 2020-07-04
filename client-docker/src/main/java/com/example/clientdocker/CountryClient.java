package com.example.clientdocker;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class CountryClient {

    private final RestTemplate restTemplate;

    //http://localhost:8082/client/gui
    @GetMapping("/gui")
    public Country[] countries() {
        ResponseEntity<Country[]> exchange = restTemplate.exchange("http://app:8081/api/country/all", HttpMethod.GET, HttpEntity.EMPTY, Country[].class);
        return exchange.getBody();
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello docker";
    }


}
