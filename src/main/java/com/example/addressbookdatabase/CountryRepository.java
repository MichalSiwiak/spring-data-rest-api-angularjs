package com.example.addressbookdatabase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query("select DISTINCT(c.continent) from Country c")
    List<String> findDistinctContinents();

    @Query("select c from Country c where lower(c.name) like lower(concat('%', :nameToFind,'%'))")
    List<Country> findByNameLike(@Param("nameToFind") String name);

    @Query("select max(c.population) from Country c")
    Integer findMaxPopulation();

    List<Country> findByPopulationLessThan(int population);

    List<Country> findByContinentEquals(String continent);

}
