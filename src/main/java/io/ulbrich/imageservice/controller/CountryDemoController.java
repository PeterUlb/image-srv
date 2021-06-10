package io.ulbrich.imageservice.controller;

import io.ulbrich.imageservice.client.CountryClient;
import io.ulbrich.imageservice.interceptor.RateLimited;
import io.ulbrich.imageservice.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryDemoController {
    private final CountryClient countryClient;

    public CountryDemoController(CountryClient countryClient) {
        this.countryClient = countryClient;
    }

    @GetMapping("/{name}")
    @RateLimited(group = 1)
    public List<Country> name(@PathVariable String name) {
        return countryClient.getByName(name);
    }
}
