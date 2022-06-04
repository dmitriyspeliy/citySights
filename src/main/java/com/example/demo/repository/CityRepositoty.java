package com.example.demo.repository;

import com.example.demo.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepositoty extends JpaRepository<City, Integer> {
}