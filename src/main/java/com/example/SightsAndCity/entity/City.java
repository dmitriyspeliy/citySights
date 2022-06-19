package com.example.SightsAndCity.entity;


import javax.persistence.*;
import java.util.*;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "city",schema = "public")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    private Integer city_id;

    @Column(name = "city_name", nullable = false, length = 256)
    private String cityName;

    @Column(name = "population", nullable = false)
    private Integer population;

    @Column(name = "subway", nullable = false)
    private Boolean subway;

    @Column(name = "country", nullable = false, length = 32)
    private String country;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Citysight> citySights;


}