package com.example.SightsAndCity.service;

import com.example.SightsAndCity.entity.Citysight;
import com.example.SightsAndCity.repository.CitysightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CitysightService {
    @Autowired
    CitysightRepository citysightRepository;

    public List<Citysight> getAllCitySights(){
        return  citysightRepository.findAll();
    }

    public Citysight getSightsByName(String name){
        Citysight citysight = null;
        Optional<Citysight> citysightGet = citysightRepository.findAll().stream().filter(x->x.getSightsName().contains(name)).findFirst();
        if(citysightGet.isPresent()){
            citysight = citysightGet.get();
        }
        return citysight;
    }

    public Page<Citysight> findPaginated(int pageNo, int pageSize,
                              String sortField, String sortDirection,String museum,String pamyatnik,String zdanie) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

        Page<Citysight> returnPage = null;


        if(museum!=null && museum.equals("museum")){
            museum = "музей";
        }
        if(pamyatnik!=null && pamyatnik.equals("pamyatnik")){
            pamyatnik = "памятник";
        }
        if(zdanie!=null && zdanie.equals("zdanie")){
            zdanie = "здание";
        }


        if(museum!=null && museum.equals("null")){
            museum = null;
        }
        if(pamyatnik!=null && pamyatnik.equals("null")){
            pamyatnik = null;
        }
        if(zdanie!=null && zdanie.equals("null")){
            zdanie = null;
        }

        System.out.println(museum);

        if (museum != null && pamyatnik != null && zdanie != null) {
            System.out.println(1);
            returnPage = citysightRepository.findAll(pageable);
        }
        if (museum != null && pamyatnik == null && zdanie == null) {
            System.out.println(2);
            returnPage = citysightRepository.findWithM(museum, pageable);
        }
        if (museum == null && pamyatnik != null && zdanie == null) {
            System.out.println(3);
            returnPage = citysightRepository.findWithP(pamyatnik, pageable);
        }
        if (museum == null && pamyatnik == null && zdanie != null) {
            System.out.println(4);
            returnPage = citysightRepository.findWithZ(zdanie, pageable);
        }
        if (museum != null && pamyatnik != null && zdanie == null) {
            System.out.println(5);
            returnPage = citysightRepository.findWithMP(museum, pamyatnik, pageable);
        }
        if (museum != null && pamyatnik == null && zdanie != null) {
            System.out.println(6);
            returnPage = citysightRepository.findWithMZ(museum, zdanie, pageable);
        }
        if (museum == null && pamyatnik != null && zdanie != null) {
            System.out.println(7);
            returnPage = citysightRepository.findWithPZ(zdanie, pamyatnik, pageable);
        }
        if(museum == null && pamyatnik == null && zdanie == null){
            System.out.println(8);
            returnPage = citysightRepository.findAll(pageable);
        }
        return returnPage;
    }

    public Citysight saveSights(Citysight citysight){
        citysightRepository.save(citysight);
        return citysight;
    }


    public void updateSights(Citysight citysight, int id){
        Optional<Citysight> citysightOption = citysightRepository.findById(id);
        if(citysightOption.isPresent()){
            Citysight citysightUpdate = citysightOption.get();
            citysightUpdate.setShortDescription(citysight.getShortDescription());
            citysightRepository.save(citysightUpdate);
        }
    }

    public void deleteSigths(int id){
        citysightRepository.deleteById(id);
    }


}
