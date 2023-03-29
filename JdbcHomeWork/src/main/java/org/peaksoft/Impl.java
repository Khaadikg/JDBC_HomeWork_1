package org.peaksoft;

import org.peaksoft.models.City;
import org.peaksoft.models.Country;

import java.sql.*;

import static org.peaksoft.dao.Lists.cities;
import static org.peaksoft.dao.Lists.countries;

public class Impl {
    public static void addCountry(String name, int population) {
        String SQL = "INSERT INTO countries(name, population) VALUES(?,?)";
        try(Connection connection = DB.connection();
            PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.setInt(2, population);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void getCountry(int id) {
        String SQL = "SELECT * FROM countries WHERE id = " + id;
        try(Connection connection = DB.connection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL);
            resultSet.next();
            System.out.printf("id = %d || name = %s || population = %d",
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("population"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Inserting everything into DB
    public static void add_db_countries_into_arraylist() {
        String SQL = "SELECT * FROM countries;";
        try(Connection connection = DB.connection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setName(resultSet.getString("name"));
                country.setPopulation(resultSet.getInt("population"));
                if (!checkExistence(country)) countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void add_db_cities_into_arraylist() {
        String SQL = "SELECT * FROM cities;";
        try(Connection connection = DB.connection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setCountries_id(resultSet.getInt("countries_id"));
                if (!checkExistence(city)) cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkExistence(City city) {
        for (City city1 : cities) {
            if(city1.getName().equalsIgnoreCase(city.getName())) {
                return true;
            }
        }
        return false;
    }
    private static boolean checkExistence(Country country) {
        for (Country country1 : countries) {
            if(country1.getName().equalsIgnoreCase(country.getName())) {
                return true;
            }
        }
        return false;
    }
}
