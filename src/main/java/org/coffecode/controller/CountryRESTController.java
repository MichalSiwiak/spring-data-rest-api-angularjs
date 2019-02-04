package org.coffecode.controller;


import org.coffecode.entity.Country;
import org.coffecode.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
public class CountryRESTController {

    private CountryList countries;
    private CountryList findByContinentList;
    private CountryList findByNameLikeList;
    private CountryList findByPopulationLessThanList;

    @Autowired
    private CountryService countryService;


    @PostConstruct
    public void init() {
        findByContinentList = new CountryList();
        findByContinentList.setCountries(countryService.findAll());
        findByNameLikeList = new CountryList();
        findByNameLikeList.setCountries(countryService.findAll());
        findByPopulationLessThanList = new CountryList();
        findByPopulationLessThanList.setCountries(countryService.findAll());
    }

    @GetMapping("/demo")
    public String getDemo(){
        return "crm-form";
    }

    @RequestMapping(value = "/demo/population", consumes = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> findByPopulationLessThan(@RequestBody String population) {
        findByPopulationLessThanList
                .setCountries(countryService
                        .findByPopulationLessThan(Integer.parseInt(population)));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/demo/continents", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<String>> getAllContinentsJSON() {
        List<String> continents = countryService.findDistinctContinents();
        continents.add("ALL");
        return new ResponseEntity<>(continents, HttpStatus.OK);
    }

    @RequestMapping(value = "/demo/name", consumes = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> findByNameLike(@RequestBody String name) {
        if (name.equals("all")) {
            findByNameLikeList.setCountries(countryService.findAll());
        } else {
            findByNameLikeList.setCountries(countryService.findByNameLike(name));
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/demo/continent", consumes = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> findByContinent(@RequestBody String continent) {
        if (continent.equals("ALL")) {
            findByContinentList.setCountries(countryService.findAll());
        } else {
            findByContinentList.setCountries(countryService.findByContinentEquals(continent));
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

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
    @RequestMapping(value = "/demo/countries", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<CountryList> getAllCountriesJSON() {
        countries = new CountryList();
        countries.setCountries(countryService.findAll());

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

        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    /**
     * HTTP POST - Create new country
     */
    @RequestMapping(value = "/demo/countries", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> createCountry(@RequestBody Country newCountry) {
        newCountry.setId(countries.getCountries().size() + 1);
        countryService.saveCountry(newCountry);
        findByContinentList.setCountries(countryService.findAll());
        findByNameLikeList.setCountries(countryService.findAll());
        findByPopulationLessThanList.setCountries(countryService.findAll());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * HTTP PUT - Update country
     */
    @RequestMapping(value = "/demo/countries/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
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

            countryService.saveCountry(countryToUpdate);
            return new ResponseEntity<>(countryToUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * HTTP DELETE - Delete country
     */
    @RequestMapping(value = "/demo/countries/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCountry(@PathVariable("id") int id) {

        Country countryToDelete;
        try {
            countryToDelete = getCountryById(id);
            if (countryToDelete != null) {
                countryService.deleteCountry(countryToDelete);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception e) {
            System.out.println("Error fetching data");
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/error")
    public String showErrorPage() {
        return "error-page";
    }
}