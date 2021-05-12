package ru.sberbank.firstproject;

import ru.sberbank.firstproject.domain.City;
import ru.sberbank.firstproject.services.Parser;
import ru.sberbank.firstproject.services.Sorter;

import java.util.List;


public class Main {




    public static void main(String[] args) {

        Parser parser = new Parser();
        Sorter sorter = new Sorter();
        List<City> cities = parser.parse("src/main/resources/testdata.txt");

        System.out.println(sorter.getCitiesListSortedByName(cities));

        System.out.println(sorter.getCitiesListSortedByDistrict(cities));

        System.out.println(sorter.getMostPopulatedCity(cities));

        System.out.println(sorter.getNumberOfCitiesWithinRegions(cities));
    }



}
