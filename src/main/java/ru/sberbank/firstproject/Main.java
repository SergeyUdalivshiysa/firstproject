package ru.sberbank.firstproject;

import ru.sberbank.firstproject.domain.City;
import ru.sberbank.firstproject.services.Parser;
import ru.sberbank.firstproject.services.Sorter;

import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.out.println("Запуск парсинага");
        Parser parser = new Parser();
        Sorter sorter = new Sorter();

        //Модуль 1
        List<City> cities = parser.parse("src/main/resources/testdata.txt");
        if (parser.isSuccess()) {
            System.out.println("Парсинг прошел успешно");
            getAndExecuteCommands(sorter, cities);
        }


    }

    private static void getAndExecuteCommands(Sorter sorter, List<City> cities) {
        while (true) {
            System.out.println("Введите команду:\n" +
                    "1 - Список городов, отсартированный по алфавиту, без учета ригистра\n" +
                    "2 - Список городов, отсартированный по федеральному округу и наименованию города внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра\n" +
                    "3 - Город с самым большим населением\n" +
                    "4 - Количество городов в разрезе регионов\n");

            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    //Модуль 2
                    System.out.println(sorter.getCitiesListSortedByName(cities) + "\n");
                    break;
                case "2":
                    //Модуль 2
                    System.out.println(sorter.getCitiesListSortedByDistrict(cities) + "\n");
                    break;
                case "3":
                    //Модуль 3
                    System.out.println(sorter.getMostPopulatedCity(cities) + "\n");
                    break;
                case "4":
                    //Модуль 4
                    System.out.println(sorter.getNumberOfCitiesWithinRegions(cities) + "\n");
                    break;
                default:
                    break;
            }
        }
    }



}
