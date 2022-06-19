package com.example.SightsAndCity.service;

import com.example.SightsAndCity.entity.City;
import com.example.SightsAndCity.repository.CityRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CityService {
    @Autowired
    CityRepositoty cityRepositoty;

    public List<City> allCity(){
        return  cityRepositoty.findAll();
    }

    public List<String> getNameCity(){
        return cityRepositoty.getAllCityName();
    }

    public void deleteCity(int id){
        cityRepositoty.deleteById(id);
    }

    public void saveSights(City city){
        cityRepositoty.save(city);
    }

    public City getCityByName(String name){
        City city = null;
        Optional<City> cityGet = cityRepositoty.findAll().stream().filter(x->x.getCityName().contains(name)).findFirst();
        if(cityGet.isPresent()){
            city = cityGet.get();
        }
        return city;
    }

    public void updateCity(City city, int id){
        Optional<City> cityOptional = cityRepositoty.findById(id);
        if(cityOptional.isPresent()){
            City cityUpdate = cityOptional.get();
            cityUpdate.setPopulation(city.getPopulation());
            cityUpdate.setSubway(city.getSubway());
            cityRepositoty.save(cityUpdate);
        }
    }


}
