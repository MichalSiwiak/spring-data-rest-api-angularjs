package com.example.addressbookdatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;

@Controller
public class CountryRESTController {

    private CountryList countries;
    private final CountryRepository countryRepository;

    @Autowired
    public CountryRESTController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @PostConstruct
    public void init() {

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
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    /**
     * HTTP POST - Create new country
     */
    @RequestMapping(value = "/countries", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> createCountry(@RequestBody Country newCountry) {
        newCountry.setId(countries.getCountries().size() + 1);
        countryRepository.save(newCountry);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * HTTP PUT - Update country
     */
    @RequestMapping(value = "/countries/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<Country> updateCountry(@PathVariable("id") int id, @RequestBody Country country) {
        Country countryToUpdate = getCountryById(id);

        if (countryToUpdate != null) {

            countryToUpdate.setName(country.getName());
            countryToUpdate.setContinent(country.getContinent());
            countryToUpdate.setPopulation(country.getPopulation());
            countryToUpdate.setLifeExpectancy(country.getLifeExpectancy());
            countryToUpdate.setIndepYear(country.getIndepYear());
            countryToUpdate.setSurfaceArea(country.getSurfaceArea());

            countryRepository.save(countryToUpdate);
            System.out.println(countryToUpdate.toString());
            return new ResponseEntity<>(countryToUpdate, HttpStatus.OK);
        }
        System.out.println(countryToUpdate.toString());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * HTTP DELETE - Delete country
     */
    @RequestMapping(value = "/countries/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCountry(@PathVariable("id") int id) {
        Country countryToDelete = getCountryById(id);
        if (countryToDelete != null) {
            countryRepository.delete(countryToDelete);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}