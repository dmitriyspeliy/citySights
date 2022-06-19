package com.example.SightsAndCity.repository;

import com.example.SightsAndCity.entity.Citysight;
import liquibase.pro.packaged.S;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface CitysightRepository extends JpaRepository<Citysight, Integer> {

    @Query( value = "SELECT * FROM citysights",
            nativeQuery = true)
    @NotNull
    Page<Citysight> findAll(@NotNull Pageable pageable);


    @Query( value = "SELECT * FROM citysights " +
            "WHERE citysights.typeofsights = :museum ",
            nativeQuery = true)
    Page<Citysight> findWithM(@Param("museum") String museum,
                              Pageable pageable);

    @Query( value = "SELECT * FROM citysights " +
            "WHERE citysights.typeofsights = :pamyatnik ",
            nativeQuery = true)
    Page<Citysight> findWithP(@Param("pamyatnik") String pamyatnik,
                              Pageable pageable);

    @Query( value = "SELECT * FROM citysights " +
            "WHERE citysights.typeofsights = :zdanie ",
            nativeQuery = true)
    Page<Citysight> findWithZ(@Param("zdanie") String zdanie,
                              Pageable pageable);
    @Query( value = "SELECT * FROM citysights " +
            "WHERE citysights.typeofsights = :museum " +
            "OR citysights.typeofsights = :pamyatnik ",
            nativeQuery = true)
    Page<Citysight> findWithMP(@Param("museum") String museum,
                                      @Param("pamyatnik") String pamyatnik,
                                      Pageable pageable);


    @Query( value = "SELECT * FROM citysights " +
            "WHERE citysights.typeofsights = :museum " +
            "OR citysights.typeofsights = :zdanie ",
            nativeQuery = true)
    Page<Citysight> findWithMZ(@Param("museum") String museum,
                               @Param("zdanie") String zdanie,
                               Pageable pageable);


    @Query( value = "SELECT * FROM citysights " +
            "WHERE citysights.typeofsights = :pamyatnik " +
            "OR citysights.typeofsights = :zdanie ",
            nativeQuery = true)
    Page<Citysight> findWithPZ(@Param("pamyatnik") String pamyatnik,
                                      @Param("zdanie") String zdanie,
                                      Pageable pageable);


}