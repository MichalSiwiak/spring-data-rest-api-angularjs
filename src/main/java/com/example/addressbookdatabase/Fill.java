package com.example.addressbookdatabase;

import java.sql.*;

public class Fill {

    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select  * from country;");

            int i =1;

            while (resultSet.next()) {
                Country country = new Country();
                country.setName(resultSet.getString("Name"));
                country.setContinent(resultSet.getString("Continent"));
                country.setSurfaceArea(resultSet.getDouble("SurfaceArea"));
                country.setIndepYear(resultSet.getInt("IndepYear"));
                country.setPopulation(resultSet.getInt("Population"));
                country.setLifeExpectancy(resultSet.getDouble("LifeExpectancy"));
                System.out.println("INSERT INTO `country` (`id`,`name`, `continent`, `surface_area`, `indep_year`, `population`,`life_expectancy`) " +
                        "VALUES ("+i+",\"" + country.getName() + "\",\"" + country.getContinent() + "\"," + country.getSurfaceArea() + "," + country.getIndepYear() + "," + country.getPopulation() + "," + country.getLifeExpectancy()+");");

                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
}


//INSERT INTO `country` (`id`, `name`, `continent`, `surface_area`, `indep_year`, `population`,`life_expectancy`) VALUES (1,"Zimbabwe","Africa",390757.0,1980,11669000,8);