package ru.sberbank.firstproject.services;

import ru.sberbank.firstproject.domain.City;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sorter {

    public Sorter() {
    }

    public String getCitiesListSortedByName(List<City> cities) {
        if (!isListValid(cities)) return "Список городов пуст";
        cities.sort(Comparator.comparing(o -> o.getName().toLowerCase()));
        StringBuilder stringBuilder = new StringBuilder();
        cities.forEach(c -> stringBuilder.append(c).append("\n"));
        return stringBuilder.toString().trim();
    }

    public String getCitiesListSortedByDistrict(List<City> cities) {
        if (!isListValid(cities)) return "Список городов пуст";
        cities.sort((o1, o2) -> {
            if (o1.getDistrict().equals(o2.getDistrict())) return o1.getName().compareTo(o2.getName());
            return o1.getDistrict().compareTo(o2.getDistrict());
        });
        StringBuilder stringBuilder = new StringBuilder();
        cities.forEach(c -> stringBuilder.append(c).append("\n"));
        return stringBuilder.toString().trim();
    }

    public String getMostPopulatedCity(List<City> cities) {
        if (!isListValid(cities)) return "Список городов пуст";
        City city = cities.stream().max(Comparator.comparingInt(City::getPopulation)).get();
        return String.format("[%s] = %s", city.getId(), city.getPopulation());

    }

    public String getNumberOfCitiesWithinRegions(List<City> cities) {
        if (!isListValid(cities)) return "Список городов пуст";
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
