package ru.sberbank.firstproject.services.util;

import ru.sberbank.firstproject.domain.City;

import java.util.Comparator;

public class CityComparator implements Comparator<City> {
    @Override
    public int compare(City s1, City s2) {
        return s1.getName().toLowerCase().compareTo(s2.getName().toLowerCase());
    }
}
