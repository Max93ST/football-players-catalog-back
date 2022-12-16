package com.max.controller;

import com.max.model.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/country")
public class CountryController {

    @GetMapping
    public List<Country> getCountryList() {
        log.info("get country list");
        return new ArrayList<>(EnumSet.allOf(Country.class));
    }
}
