package ru.sberbank.firstproject.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sberbank.firstproject.util.CityComparator;
import ru.sberbank.firstproject.util.DistrictAndCityComparator;
import ru.sberbank.firstproject.domain.City;
import java.util.ArrayList;
import java.util.List;

class SorterTest {

    static List<City> cities = new ArrayList<>();
    static Sorter sorter;

    static {
        try {
            sorter = new Sorter(cities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
   static void fillTheList() {
        cities.add(new City("Калуга", "Калужская область", "Калужский округ", 50000,1888));
        cities.add(new City("Воронеж", "Воронежская область", "Воронежский округ", 300000,1828));
        cities.add(new City("Санкт_Петербург", "Ленобласть", "Северо-западный", 6000000,1703));
        cities.add(new City("Ломоносов", "Ленобласть", "Северо-западный", 50000,1747));
    }

    @Test
    void printCitiesListSortedByName() {
        String out = sorter.getCitiesListSortedByComparator(cities, new CityComparator());
        Assertions.assertEquals("City{name='Воронеж', region='Воронежская область', district='Воронежский округ', population=300000, yearOfFoundation=1828}\n" +
                "City{name='Калуга', region='Калужская область', district='Калужский округ', population=50000, yearOfFoundation=1888}\n" +
                "City{name='Ломоносов', region='Ленобласть', district='Северо-западный', population=50000, yearOfFoundation=1747}\n" +
                "City{name='Санкт_Петербург', region='Ленобласть', district='Северо-западный', population=6000000, yearOfFoundation=1703}", out);
    }

    @Test
    void printCitiesListSortedByDistrict() {
        String out = sorter.getCitiesListSortedByComparator(cities, new DistrictAndCityComparator());
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