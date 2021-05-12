package ru.sberbank.firstproject.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sberbank.firstproject.domain.City;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    static Parser parser = new Parser();
    static String path = "src/test/java/ru/sberbank/firstproject/resources/testdata.txt";
    static List<City> cities = new ArrayList<>();

    @BeforeAll
   static void fillTheList() {
        cities.add(new City(1, "Калуга", "Калужская область", "Калужский округ", 50000,1899));
        cities.add(new City(2, "Воронеж", "Воронежская область", "Воронежский округ", 300000,1789));
        cities.add(new City(3, "Санкт-Петербург", "Ленобласть", "Северо-западный", 6000000,1703));
        cities.add(new City(4, "Ломоносов", "Ленобласть", "Северо-западный", 60000,1703));
    }



    @Test
    void parse() {
        List<City> testCities = parser.parse(new File(path));
        Assertions.assertEquals(cities, testCities);
    }
}