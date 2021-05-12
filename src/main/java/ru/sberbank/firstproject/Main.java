package ru.sberbank.firstproject;

import ru.sberbank.firstproject.domain.City;
import ru.sberbank.firstproject.services.Parser;
import ru.sberbank.firstproject.services.Sorter;
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
            List<City> cities = parser.parse(file);

            if (parser.isSuccess()) {
                System.out.println("Парсинг прошел успешно");
                getAndExecuteCommands(cities);
            }
        }
    }

    private static void getAndExecuteCommands(List<City> cities) {
        Sorter sorter = new Sorter();
        while (true) {
            System.out.println("Введите команду:\n" +
                    "1 - Список городов, отсартированный по алфавиту, без учета ригистра\n" +
                    "2 - Список городов, отсартированный по федеральному округу и наименованию города внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра\n" +
                    "3 - Город с самым большим населением\n" +
                    "4 - Количество городов в разрезе регионов\n" +
                    "5 - Выход\n");

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
