package ru.sberbank.firstproject.services;

import ru.sberbank.firstproject.domain.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Parser {
    public Parser() {
    }

    public List<City> parse(File file) throws FileNotFoundException {
        List<City> cities = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String[] strings = scanner.nextLine().split(";");
            String name = strings[1];
            String region = strings[2];
            String district = strings[3];
            int population = Integer.parseInt(strings[4]);
            int foundation = Integer.parseInt(strings[5]);
            City city = new City(name, region, district, population, foundation);
            cities.add(city);
        }
        scanner.close();
        return cities;
    }
}
