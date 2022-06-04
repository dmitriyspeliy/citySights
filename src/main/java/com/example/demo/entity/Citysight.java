package com.example.demo.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "citysights")
public class Citysight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sights_id", nullable = false)
    private Integer sights_id;

    @Column(name = "sights_name", length = 256)
    private String sightsName;

    @Column(name = "dateofconstruction", columnDefinition = "DATE")
    private Date dateofconstruction;

    @Column(name = "shortdesc", columnDefinition = "text")
    private String shortdesc;

    @Column(name = "typeofsights", length = 256)
    private String typeofsights;

    @Column(name = "city_id")
    private  Integer city_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id",referencedColumnName = "city_id",updatable = false,insertable = false)
    @JsonBackReference
    private City city;

}