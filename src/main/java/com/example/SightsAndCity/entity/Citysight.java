package com.example.SightsAndCity.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "citysights", schema = "public")
public class Citysight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sights_id", nullable = false)
    private Integer sightsId;

    @Column(name = "sights_name", length = 256)
    private String sightsName;

    @Column(name = "dateofconstruction", columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfConstruction;

    @Column(name = "shortdesc", columnDefinition = "text")
    private String shortDescription;

    @Column(name = "typeofsights", length = 256)
    private String typeOfSights;

    @Column(name = "city_id")
    private Integer city_id;




    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "city_id", updatable = false, insertable = false)
    @JsonBackReference
    private City city;



}