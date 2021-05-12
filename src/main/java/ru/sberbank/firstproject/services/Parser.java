package ru.sberbank.firstproject.services;

import ru.sberbank.firstproject.domain.City;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Parser {


    private boolean isSuccess = false;

    public boolean isSuccess() {
        return isSuccess;
    }

    public Parser() {
    }


    public List<City> parse(File file) {
        List<City> cities = new ArrayList<>();
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
            isSuccess = true;
            scanner.close();
        } catch (Exception e) {
            System.out.println("Ошибка при парсинге файла, проверте наличие файла и соответсвование требованиям");
            System.exit(0);
        }

        return cities;
    }


    private String getClearString(Scanner scanner) {
        return scanner.nextLine().replaceAll(";", "");
    }
}
