package ru.sberbank.firstproject.services;

import ru.sberbank.firstproject.domain.City;

import java.util.*;

public class Sorter {
    List<City> cities;

    public Sorter(List<City> cities) {
        if (!isListValid(cities)) throw new NoSuchElementException();
        else this.cities=cities;
    }

    //2
    public List<City> getCitiesListSortedByComparator(Comparator<City> comparator) {
        cities.sort(comparator);
        return cities;
    }

    //3
    public String getMostPopulatedCity() {
        City city = cities.stream().max(Comparator.comparingInt(City::getPopulation)).get();
        return String.format("[%s] = %s", cities.indexOf(city), city.getPopulation());
    }

    //4
    public Map<String, Integer> getNumberOfCitiesWithinRegions() {
        Map<String, Integer> map = new HashMap<>();
        cities.forEach(c -> map.merge(c.getRegion(), 1, Integer::sum));
        return map;
    }

    public boolean isListValid(List<City> cities) {
        return (cities != null && !cities.isEmpty());
    }
}
