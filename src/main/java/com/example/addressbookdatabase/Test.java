package com.example.addressbookdatabase;

public class Test {

    public static void main(String[] args) {
        Country country1 = new Country();
        country1.setId(1);
        country1.setName("foo");
        country1.setContinent("foo");
        country1.setSurfaceArea(50);
        country1.setIndepYear(50);
        country1.setPopulation(50);
        country1.setLifeExpectancy(50);

        Country country2 = new Country();
        country2.setId(1);
        country2.setName("foo");
        country2.setContinent("foo");
        country2.setSurfaceArea(50);
        country2.setIndepYear(50);
        country2.setPopulation(50);
        country2.setLifeExpectancy(50);


        System.out.println(country1.equals(country2));
        System.out.println(country1.hashCode());
        System.out.println(country2.hashCode());

    }
}
