package ru.sberbank.firstproject.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sberbank.firstproject.TestData;
import ru.sberbank.firstproject.domain.City;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

class ParserTest {
    private static final Parser parser = new Parser();


    @Test
    void parse() {
        List<City> testCities = null;
        try {
            testCities = parser.parse(new File(TestData.PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(TestData.TEST_CITIES, testCities);
    }

    @Test
    void parseIncorrectData() {
        Assertions.assertThrows(Exception.class,
                () -> parser.parse(new File("src/test/java/ru/sberbank/firstproject/resources/incorrectTestData.txt")));
    }
}