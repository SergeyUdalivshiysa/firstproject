package ru.sberbank.firstproject;

import ru.sberbank.firstproject.domain.City;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static final List<City> TEST_CITIES = new ArrayList<>();
    public static final String PATH = "src/test/java/ru/sberbank/firstproject/resources/testdata.txt";

    static public City CITY1 = new City("Адыгейск", "Адыгея", "Южный", 12248,1973);
    static public City CITY2 = new City("Майкоп", "Адыгея", "Южный", 144246,1857);
    static public City CITY3 = new City("Горно-Алтайск", "Алтай", "Сибирский", 56928,1830);
    static public City CITY4 = new City( "Алдан", "Якутия", "Дальневосточный", 21277,1924);

    static {
        TEST_CITIES.add(CITY1);
        TEST_CITIES.add(CITY2);
        TEST_CITIES.add(CITY3);
        TEST_CITIES.add(CITY4);
    }

}
