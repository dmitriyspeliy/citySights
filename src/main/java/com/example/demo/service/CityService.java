package com.example.demo.service;

import com.example.demo.entity.City;
import com.example.demo.repository.CityRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityService {
    @Autowired
    CityRepositoty cityRepositoty;

    public List<City> allCity(){
        return  cityRepositoty.findAll();
    }
}
