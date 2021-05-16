package ru.sberbank.firstproject.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sberbank.firstproject.TestData;
import ru.sberbank.firstproject.services.util.CityComparator;
import ru.sberbank.firstproject.services.util.DistrictAndCityComparator;
import ru.sberbank.firstproject.domain.City;
import java.util.*;

class SorterTest {

    static final Sorter SORTER = new Sorter(TestData.TEST_CITIES);

    @Test
    void printCitiesListSortedByName() {
        List<City> output = SORTER.getCitiesListSortedByComparator(new CityComparator());
        Assertions.assertEquals(Arrays.asList(
                TestData.CITY1,
                TestData.CITY4,
                TestData.CITY3,
                TestData.CITY2), output);
    }

    @Test
    void printCitiesListSortedByDistrict() {
        List<City> output = SORTER.getCitiesListSortedByComparator(new DistrictAndCityComparator());
        Assertions.assertEquals(Arrays.asList(
                TestData.CITY4,
                TestData.CITY3,
                TestData.CITY1,
                TestData.CITY2), output);
    }

    @Test
    void printMostPopulatedCity() {
        String out = SORTER.getMostPopulatedCity();
        Assertions.assertEquals("[1] = 144246", out);
    }

    @Test
    void printNumberOfCitiesWithinRegions() {

        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("Адыгея", 2);
        expected.put("Якутия", 1);
        expected.put("Алтай", 1);

        Map<String, Integer> output = SORTER.getNumberOfCitiesWithinRegions();
        Assertions.assertEquals(expected, output);

    }

}
