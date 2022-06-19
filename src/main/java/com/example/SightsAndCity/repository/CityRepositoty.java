package com.example.SightsAndCity.repository;


import com.example.SightsAndCity.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepositoty extends JpaRepository<City, Integer> {

    @Query( value = "SELECT city_name FROM City",
            nativeQuery = true)
    List<String> getAllCityName();


}