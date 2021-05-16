package ru.sberbank.firstproject.services.util;

import ru.sberbank.firstproject.domain.City;

import java.util.Comparator;

public class DistrictAndCityComparator implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        if (o1.getDistrict().equals(o2.getDistrict())) return o1.getName().compareTo(o2.getName());
        return o1.getDistrict().compareTo(o2.getDistrict());
    }
}
