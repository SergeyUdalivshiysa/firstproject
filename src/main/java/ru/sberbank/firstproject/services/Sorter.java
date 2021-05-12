package ru.sberbank.firstproject.services;

import ru.sberbank.firstproject.domain.City;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sorter {

    public Sorter(List<City> cities) throws Exception {
        if (!isListValid(cities)) throw new NullPointerException();
    }
//2
    public String getCitiesListSortedByComparator(List<City> cities, Comparator<City> comparator) {
        cities.sort(comparator);
        StringBuilder stringBuilder = new StringBuilder();
        cities.forEach(c -> stringBuilder.append(c).append("\n"));
        return stringBuilder.toString().trim();
    }
//3
    public String getMostPopulatedCity(List<City> cities) {
        City city = cities.stream().max(Comparator.comparingInt(City::getPopulation)).get();
        return String.format("[%s] = %s", cities.indexOf(city), city.getPopulation());
    }
//4
    public String getNumberOfCitiesWithinRegions(List<City> cities) {
        Map<String, Integer> map = new HashMap<>();
        cities.forEach(c -> map.merge(c.getRegion(), 1, Integer::sum));
        StringBuilder stringBuilder = new StringBuilder();
        map.forEach((c, i) -> stringBuilder.append(String.format("%s - %s\n", c, i)));
        return stringBuilder.toString().trim();
    }

    public boolean isListValid (List<City> cities) {
        return (cities != null && !cities.isEmpty());
    }

}
