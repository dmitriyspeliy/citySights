package com.example.SightsAndCity.controller;

import com.example.SightsAndCity.entity.City;
import com.example.SightsAndCity.entity.Citysight;
import com.example.SightsAndCity.entity.TypeOfConstruction;
import com.example.SightsAndCity.service.CityService;
import com.example.SightsAndCity.service.CitysightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class cityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CitysightService citysightService;

    @GetMapping("/")
    public String getCitySights(Model model) {
        return findPaginated(1,"citysights.sights_name","asc", "museum",
                "pamyatnik","zdanie",model);
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo",required = false) int pageNo,
                                @RequestParam(value = "sortField",required = false) String sortFiled,
                                @RequestParam(value = "sortDir",required = false) String sortDir,
                                @RequestParam(value = "museum",required = false) String museum,
                                @RequestParam(value = "pamyatnik",required = false) String pamyatnik,
                                @RequestParam(value = "zdanie",required = false) String zdanie,
                                Model model) {
        int pageSize = 5;


        Page<Citysight> page = citysightService.findPaginated(pageNo,pageSize,sortFiled,sortDir,museum,pamyatnik,zdanie);

        List<Citysight> citysights = page.getContent();


        model.addAttribute("museum",museum);
        model.addAttribute("pamyatnik",pamyatnik);
        model.addAttribute("zdanie",zdanie);

        model.addAttribute("sortField",sortFiled);
        model.addAttribute("sortDir",sortDir);
        model.addAttribute("reverseSortDir",sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("listCitySights",citysights);

        return "citySights";
    }

    @GetMapping("/openDesc/{name}")
    public String getDesc(@PathVariable(value = "name") String name,Model model) {
        model.addAttribute("openDesc", citysightService.getSightsByName(name));
        return "openDesc";
    }

    @GetMapping("/update/{name}")
    public String update(@PathVariable(value = "name") String name,Model model) {
        model.addAttribute("updateSight", citysightService.getSightsByName(name));
        return "updateSight";
    }

    @GetMapping("/updateCity/{name}")
    public String updateCity(@PathVariable(value = "name") String name,Model model) {
        model.addAttribute("updateCity", cityService.getCityByName(name));
        return "updateCity";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        citysightService.deleteSigths(id);
        return "redirect:/";
    }

    @GetMapping("/deleteCity/{id}")
    public String deleteCity(@PathVariable(value = "id") int id) {
        cityService.deleteCity(id);
        return "redirect:/city";
    }

    @GetMapping("/city")
    public String getCity(Model model) {
        model.addAttribute("City",cityService.allCity());
        return "city";
    }


    @ModelAttribute("Citysight")
    public Citysight defaultInstanceSights() {
        return new Citysight();
    }

    @ModelAttribute("CityForm")
    public City defaultInstanceCity() {
        return new City();
    }

    @ModelAttribute("getNameCity")
    public List<String> getNameCity(){
        return cityService.getNameCity();
    }




    @PostMapping("/saveSights")
    public String saveSights(@ModelAttribute("Citysight") Citysight citysight) {
        citysightService.saveSights(citysight);
        return "redirect:/";
    }

    @PostMapping("/saveCity")
    public String saveCity(@ModelAttribute("CityForm") City city) {
        cityService.saveSights(city);
        return "redirect:/city";
    }


    @PostMapping("/updateAndSaveSight/{id}")
    public String updateAndSaveSight(@ModelAttribute("updateSight") Citysight citysight,
                                     @PathVariable(value = "id") int id) {

        citysightService.updateSights(citysight,id);
        return "redirect:/";
    }

    @PostMapping("/updateAndSaveCity/{id}")
    public String updateAndSaveCity(@ModelAttribute("updateCity") City city,
                                     @PathVariable(value = "id") int id) {

        cityService.updateCity(city,id);
        return "redirect:/city";
    }





}