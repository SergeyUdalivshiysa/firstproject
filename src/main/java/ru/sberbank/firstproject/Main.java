package ru.sberbank.firstproject;

import ru.sberbank.firstproject.db.dao.CityDAO;
import ru.sberbank.firstproject.db.dao.util.DatabaseFiller;
import ru.sberbank.firstproject.domain.City;
import ru.sberbank.firstproject.services.Parser;
import ru.sberbank.firstproject.services.Printer;
import ru.sberbank.firstproject.services.Sorter;
import ru.sberbank.firstproject.services.util.CityComparator;
import ru.sberbank.firstproject.services.util.DistrictAndCityComparator;

import java.io.File;
import java.util.List;
import java.util.Scanner;


public class Main {




    public static void main(String[] args) {


        DatabaseFiller.fillDatabase();
        System.out.println(CityDAO.getCityByName("Адыгейск"));
        CityDAO.deleteCityByName("Адыгейск");
        System.out.println(CityDAO.getCityByName("Адыгейск"));
        List<City> cities1 = CityDAO.getAllCities();
        cities1.forEach(System.out::println);

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

    private static void getAndExecuteCommands(List<City> cities) {
        Sorter sorter = new Sorter(cities);
        System.out.println("Введите команду:\n" +
                "1 - Список городов, отсартированный по алфавиту, без учета ригистра\n" +
                "2 - Список городов, отсартированный по федеральному округу и наименованию города внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра\n" +
                "3 - Город с самым большим населением\n" +
                "4 - Количество городов в разрезе регионов\n" +
                "5 - Выход\n");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    //Модуль 2
                    Printer.printResult(sorter.getCitiesListSortedByComparator(new CityComparator()));
                    break;
                case "2":
                    //Модуль 2
                    Printer.printResult(sorter.getCitiesListSortedByComparator(new DistrictAndCityComparator()));
                    break;
                case "3":
                    //Модуль 3
                    Printer.printResult(sorter.getMostPopulatedCity());
                    break;
                case "4":
                    //Модуль 4
                    Printer.printResult(sorter.getNumberOfCitiesWithinRegions());
                    break;
                case "5":
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    private static File chooseFile() {

        return new File("/Users/a19189114/IdeaProjects/firstproject/src/main/resources/testdata.txt");
       /* JFileChooser jFileChooser = new JFileChooser();
        while (true) {
            int ret = jFileChooser.showDialog(null, "Выбрать файл");
            if (ret == JFileChooser.APPROVE_OPTION) return jFileChooser.getSelectedFile();
        }*/
    }
}
