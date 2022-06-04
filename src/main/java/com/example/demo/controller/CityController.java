package com.example.demo.controller;

import com.example.demo.entity.City;
import com.example.demo.entity.Citysight;
import com.example.demo.service.CityService;
import com.example.demo.service.CitysightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private final CityService cityService;

    @Autowired
    private final CitysightService citysightService;

    public CityController(CityService cityService, CitysightService citysightService) {
        this.cityService = cityService;
        this.citysightService = citysightService;
    }

    @GetMapping(value = "/allCity",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<City> getCity() {
        return cityService.allCity();
    }

    @GetMapping("/allCitySights")
    public List<Citysight> getAllCitySights() {
        return citysightService.getAllCitySights();
    }
}