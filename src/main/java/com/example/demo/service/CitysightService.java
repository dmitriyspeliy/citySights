package com.example.demo.service;

import com.example.demo.entity.Citysight;
import com.example.demo.repository.CitysightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CitysightService {
    @Autowired
    CitysightRepository citysightRepository;

    public List<Citysight> getAllCitySights(){
        return  citysightRepository.findAll();
    }
}
