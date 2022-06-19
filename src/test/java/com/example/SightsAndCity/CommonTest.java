package com.example.SightsAndCity;


import com.example.SightsAndCity.entity.City;
import com.example.SightsAndCity.entity.Citysight;
import com.example.SightsAndCity.repository.CitysightRepository;
import com.example.SightsAndCity.service.CitysightService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class CommonTest {

    @Autowired
    CitysightService citysightService;

    @MockBean
    CitysightRepository repository;

    @BeforeEach
    void init() {

    }

    @Test
    @DisplayName("Test findById Success")
    void testFindById() {
        // Setup our mock repository
        Citysight citysight = new Citysight(1, "НСК",new Date("1993-12-27"),"sadad","plfybt",1,new City());
        doReturn(Optional.of(citysight)).when(repository).save(citysight);
        // Execute the service call
        Citysight returnedCitysight = citysightService.saveSights(citysight);

        // Assert the response
        Assertions.assertNotNull(returnedCitysight, "The saved widget should not be null");
        Assertions.assertEquals(2, returnedCitysight.getCity_id(), "The version should be incremented");
    }
}
