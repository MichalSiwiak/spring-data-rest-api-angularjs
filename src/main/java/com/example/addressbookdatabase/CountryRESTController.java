package com.example.addressbookdatabase;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

import static java.util.stream.Collectors.toList;

@Controller
public class CountryRESTController {

    private CountryList countries;
    private CountryList findByContinentList;
    private CountryList findByNameLikeList;
    private CountryList findByPopulationLessThanList;

    private final CountryRepository countryRepository;

    @Autowired
    public CountryRESTController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @PostConstruct
    public void init() {
        findByContinentList = new CountryList();
        findByContinentList.setCountries(countryRepository.findAll());
        findByNameLikeList = new CountryList();
        findByNameLikeList.setCountries(countryRepository.findAll());
        findByPopulationLessThanList = new CountryList();
        findByPopulationLessThanList.setCountries(countryRepository.findAll());
    }

    @RequestMapping(value = "/population", consumes = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> findByPopulationLessThan(@RequestBody String population) {
        findByPopulationLessThanList
                .setCountries(countryRepository
                        .findByPopulationLessThan(Integer.parseInt(population)));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/continents", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<String>> getAllContinentsJSON() {
        List<String> continents = countryRepository.findDistinctContinents();
        continents.add("ALL");
        return new ResponseEntity<>(continents, HttpStatus.OK);
    }

    @RequestMapping(value = "/name", consumes = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> findByNameLike(@RequestBody String name) {
        if (name.equals("all")) {
            findByNameLikeList.setCountries(countryRepository.findAll());
        } else {
            findByNameLikeList.setCountries(countryRepository.findByNameLike(name));
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/continent", consumes = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> findByContinent(@RequestBody String continent) {
        if (continent.equals("ALL")) {
            findByContinentList.setCountries(countryRepository.findAll());
        } else {
            findByContinentList.setCountries(countryRepository.findByContinentEquals(continent));
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Utility methods for getting country by id
    private Country getCountryById(int id) {
        for (Country c : countries.getCountries()) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    /**
     * HTTP GET - Get all countries
     */
    @RequestMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<CountryList> getAllCountriesJSON() {
        countries = new CountryList();
        countries.setCountries(countryRepository.findAll());

        //countries.setCountries(countryRepository.findAll());
        //System.out.println("countries: "+countries.getCountries().toString());
        //List<Country> all = countryRepository.findAll();

        List<Country> common = new ArrayList<>();

        try {
            common = countries.getCountries()
                    .stream()
                    .filter(findByContinentList.getCountries()::contains)
                    .filter(findByNameLikeList.getCountries()::contains)
                    .filter(findByPopulationLessThanList.getCountries()::contains)
                    .collect(toList());

        } catch (Exception e) {
        }

        countries.setCountries(common);

        System.out.println("countries: " + countries.getCountries().toString());
        System.out.println("findByContinentList :" + findByContinentList.getCountries().toString());
        System.out.println("findByNameLikeList :" + findByNameLikeList.getCountries().toString());
        System.out.println("findByPopulationLessThanList: " + findByPopulationLessThanList.getCountries().toString());
        //System.out.println("common: "+common.toString());
        System.out.println("====================================================================");


        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    /**
     * HTTP POST - Create new country
     */
    @RequestMapping(value = "/countries", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> createCountry(@RequestBody Country newCountry) {
        newCountry.setId(countries.getCountries().size() + 1);
        countryRepository.save(newCountry);
        findByContinentList.setCountries(countryRepository.findAll());
        findByNameLikeList.setCountries(countryRepository.findAll());
        findByPopulationLessThanList.setCountries(countryRepository.findAll());
        System.out.println(newCountry.toString());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * HTTP PUT - Update country
     */
    @RequestMapping(value = "/countries/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<Country> updateCountry(@PathVariable("id") int id, @RequestBody Country country) {

        Country countryToUpdate = new Country();
        try {
            countryToUpdate = getCountryById(id);
        } catch (Exception e) {
            System.out.println("Error fetching data");
        }


        if (countryToUpdate != null) {

            countryToUpdate.setName(country.getName());
            countryToUpdate.setContinent(country.getContinent());
            countryToUpdate.setPopulation(country.getPopulation());
            countryToUpdate.setLifeExpectancy(country.getLifeExpectancy());
            countryToUpdate.setIndepYear(country.getIndepYear());
            countryToUpdate.setSurfaceArea(country.getSurfaceArea());

            countryRepository.save(countryToUpdate);
            //System.out.println(countryToUpdate.toString());
            return new ResponseEntity<>(countryToUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * HTTP DELETE - Delete country
     */
    @RequestMapping(value = "/countries/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCountry(@PathVariable("id") int id) {

        Country countryToDelete;
        try {
            countryToDelete = getCountryById(id);
            if (countryToDelete != null) {
                countryRepository.delete(countryToDelete);
                System.out.println(countryToDelete.toString());
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println("Error fetching data");
        }


        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}