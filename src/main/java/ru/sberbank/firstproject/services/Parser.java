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


    public List<City> parse(String path) {
        List<City> cities = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                int id = Integer.parseInt(getClearString(scanner));
                String name = getClearString(scanner);
                String region = getClearString(scanner);
                String district = getClearString(scanner);
                int population = Integer.parseInt(getClearString(scanner));
                int foundation = Integer.parseInt(getClearString(scanner));
                City city = new City(id, name, region, district, population, foundation);
                cities.add(city);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        return cities;
    }


    private String getClearString(Scanner scanner) {
        return scanner.nextLine().replaceAll(";", "");
    }
}
