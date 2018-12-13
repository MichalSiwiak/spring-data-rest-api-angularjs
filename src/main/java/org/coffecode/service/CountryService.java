package org.coffecode.service;

import org.coffecode.entity.Country;
import java.util.List;

public interface CountryService {


    public void saveCountry(Country country);

    public void deleteCountry(Country country);

    public List<Country> findAll();

    public List<String> findDistinctContinents();

    public List<Country> findByNameLike(String name);

    public List<Country> findByPopulationLessThan(int population);

    public List<Country> findByContinentEquals(String continent);


}
