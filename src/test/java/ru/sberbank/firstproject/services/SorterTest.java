package ru.sberbank.firstproject.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sberbank.firstproject.domain.City;

import java.util.ArrayList;
import java.util.List;

class SorterTest {

    static List<City> cities = new ArrayList<>();
    static Sorter sorter = new Sorter();

    @BeforeAll
   static void fillTheList() {
        cities.add(new City(1, "Калуга", "Калужская область", "Калужский округ", 50000,1888));
        cities.add(new City(2, "Воронеж", "Воронежская область", "Воронежский округ", 300000,1828));
        cities.add(new City(3, "Санкт_Петербург", "Ленобласть", "Северо-западный", 6000000,1703));
        cities.add(new City(4, "Ломоносов", "Ленобласть", "Северо-западный", 50000,1747));
    }

    @Test
    void printCitiesListSortedByName() {
        String out = sorter.getCitiesListSortedByName(cities);
        Assertions.assertEquals("City{name='Воронеж', region='Воронежская область', district='Воронежский округ', population=300000, yearOfFoundation=1828}\n" +
                "City{name='Калуга', region='Калужская область', district='Калужский округ', population=50000, yearOfFoundation=1888}\n" +
                "City{name='Ломоносов', region='Ленобласть', district='Северо-западный', population=50000, yearOfFoundation=1747}\n" +
                "City{name='Санкт_Петербург', region='Ленобласть', district='Северо-западный', population=6000000, yearOfFoundation=1703}", out);
    }

    @Test
    void printCitiesListSortedByDistrict() {
        String out = sorter.getCitiesListSortedByDistrict(cities);
        Assertions.assertEquals("City{name='Воронеж', region='Воронежская область', district='Воронежский округ', population=300000, yearOfFoundation=1828}\n" +
                "City{name='Калуга', region='Калужская область', district='Калужский округ', population=50000, yearOfFoundation=1888}\n" +
                "City{name='Ломоносов', region='Ленобласть', district='Северо-западный', population=50000, yearOfFoundation=1747}\n" +
                "City{name='Санкт_Петербург', region='Ленобласть', district='Северо-западный', population=6000000, yearOfFoundation=1703}", out);
    }

    @Test
    void printMostPopulatedCity() {
        String out = sorter.getMostPopulatedCity(cities);
        Assertions.assertEquals("[3] = 6000000", out);
    }

    @Test
    void printNumberOfCitiesWithinRegions() {
        String out = sorter.getNumberOfCitiesWithinRegions(cities);
        Assertions.assertEquals("Ленобласть - 2\n" +
                "Воронежская область - 1\n" +
                "Калужская область - 1", out);

    }

}