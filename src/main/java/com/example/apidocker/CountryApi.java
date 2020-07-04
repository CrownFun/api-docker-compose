package com.example.apidocker;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/country")
@RequiredArgsConstructor
public class CountryApi {

    private final CountryRepo countryRepo;

    @GetMapping("/all")
    public List<Country> getAllAcountries() {
        List<Country> all = countryRepo.findAll();
        return all;
    }

    //localhost:8081/api/country/test
    @GetMapping("/test")
    public Country getCountry(){
        return new Country("Egypt","Afrika");
    }


    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        countryRepo.save(new Country("Poland", "Europe"));
        countryRepo.save(new Country("USA", "Amerika"));
        countryRepo.save(new Country("Japan", "Asia"));
    }
}
