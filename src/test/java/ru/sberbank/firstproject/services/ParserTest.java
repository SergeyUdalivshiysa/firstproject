package ru.sberbank.firstproject.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sberbank.firstproject.domain.City;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class ParserTest {
    private static final Parser parser = new Parser();
    private static final String path = "src/test/java/ru/sberbank/firstproject/resources/testdata.txt";
    private static final List<City> cities = new ArrayList<>();

    @BeforeAll
    static void fillTheList() {
        cities.add(new City("Калуга", "Калужская область", "Калужский округ", 50000,1899));
        cities.add(new City("Воронеж", "Воронежская область", "Воронежский округ", 300000,1789));
        cities.add(new City("Санкт-Петербург", "Ленобласть", "Северо-западный", 6000000,1703));
        cities.add(new City( "Ломоносов", "Ленобласть", "Северо-западный", 60000,1703));
    }

    @Test
    void parse() {
        List<City> testCities = null;
        try {
            testCities = parser.parse(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(cities, testCities);
    }

    @Test
    void parseIncorrectData() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        try {
            parser.parse(new File("src/test/java/ru/sberbank/firstproject/resources/incorrectTestData.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals("Ошибка при парсинге файла, проверте наличие файла и соответсвование требованиям", outputStreamCaptor.toString()
                .trim());
    }
}