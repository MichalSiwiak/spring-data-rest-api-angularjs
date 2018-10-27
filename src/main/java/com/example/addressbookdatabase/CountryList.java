package com.example.addressbookdatabase;

import java.util.List;


public class CountryList {

    private List<Country> countries;

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "CountryList{" +
                "countries=" + countries +
                '}';
    }
}
