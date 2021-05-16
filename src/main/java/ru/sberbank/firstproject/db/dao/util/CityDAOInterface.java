package ru.sberbank.firstproject.db.dao.util;

import ru.sberbank.firstproject.domain.City;
import java.util.List;

public interface CityDAOInterface {
     static void postCity(City city) {
    }

     static void updateCity(City city) {
    }

    static void deleteCityByName(String name) {
    }

     static City getCityByName(String name) {
         return null;
     }

     static List<City> getAllCities() {
         return null;
    }
}
