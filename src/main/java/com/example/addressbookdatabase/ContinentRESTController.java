package com.example.addressbookdatabase;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContinentRESTController {

    @RequestMapping(value = "/continents", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<String>> getAllContinentsJSON() {
        List<String> continents = new ArrayList<>();
        continents.add("cokolwiek1");
        continents.add("cokolwiek2");
        continents.add("cokolwiek3");
        return new ResponseEntity<>(continents, HttpStatus.OK);
    }

    @RequestMapping(value = "/continent", consumes = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> getContinent(@RequestBody String string) {
        System.out.println(string);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
