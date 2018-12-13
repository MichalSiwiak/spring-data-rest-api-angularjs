package org.coffecode.service;

import org.coffecode.dao.CountryDAO;
import org.coffecode.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDAO countryDAO;


    @Override
    @Transactional
    public void saveCountry(Country country) {
        countryDAO.saveCountry(country);
    }

    @Override
    @Transactional
    public void deleteCountry(Country country) {
        countryDAO.deleteCountry(country);
    }

    @Override
    @Transactional
    public List<Country> findAll() {
        return countryDAO.findAll();
    }

    @Override
    @Transactional
    public List<String> findDistinctContinents() {
        return countryDAO.findDistinctContinents();
    }

    @Override
    @Transactional
    public List<Country> findByNameLike(String name) {
        return countryDAO.findByNameLike(name);
    }

    @Override
    @Transactional
    public List<Country> findByPopulationLessThan(int population) {
        return countryDAO.findByPopulationLessThan(population);
    }

    @Override
    @Transactional
    public List<Country> findByContinentEquals(String continent) {
        return countryDAO.findByContinentEquals(continent);
    }
}
