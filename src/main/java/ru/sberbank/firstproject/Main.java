package ru.sberbank.firstproject;

import ru.sberbank.firstproject.domain.City;
import ru.sberbank.firstproject.services.Parser;
import ru.sberbank.firstproject.services.Sorter;
import ru.sberbank.firstproject.util.CityComparator;
import ru.sberbank.firstproject.util.DistrictAndCityComparator;

import javax.swing.*;
import java.io.File;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        while (true) {
            File file = chooseFile();

            System.out.println("Запуск парсинага");
            Parser parser = new Parser();
            //Модуль 1
            try {
                List<City> cities = parser.parse(file);
                getAndExecuteCommands(cities);
                System.out.println("Парсинг прошел успешно");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Ошибка при парсинге, проверьте корректность файла");
            }
        }
    }

    private static void getAndExecuteCommands(List<City> cities) throws Exception {
        Sorter sorter = new Sorter(cities);
        System.out.println("Введите команду:\n" +
                "1 - Список городов, отсартированный по алфавиту, без учета ригистра\n" +
                "2 - Список городов, отсартированный по федеральному округу и наименованию города внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра\n" +
                "3 - Город с самым большим населением\n" +
                "4 - Количество городов в разрезе регионов\n" +
                "5 - Выход\n");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    //Модуль 2
                    System.out.println(sorter.getCitiesListSortedByComparator(cities, new CityComparator()) + "\n");
                    break;
                case "2":
                    //Модуль 2
                    System.out.println(sorter.getCitiesListSortedByComparator(cities, new DistrictAndCityComparator()) + "\n");
                    break;
                case "3":
                    //Модуль 3
                    System.out.println(sorter.getMostPopulatedCity(cities) + "\n");
                    break;
                case "4":
                    //Модуль 4
                    System.out.println(sorter.getNumberOfCitiesWithinRegions(cities) + "\n");
                    break;
                case "5":
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    private static File chooseFile() {
        JFileChooser jFileChooser = new JFileChooser();
        while (true) {
            int ret = jFileChooser.showDialog(null, "Выбрать файл");
            if (ret == JFileChooser.APPROVE_OPTION) return jFileChooser.getSelectedFile();
        }

    }


}
