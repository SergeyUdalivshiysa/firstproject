package ru.sberbank.firstproject.db.dao.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private static Properties properties = new Properties();
    public final static String URL;
    public final static String DRIVER_CLASS;


    static {
        try {
            properties.load(new FileReader("src/main/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        URL = properties.getProperty("hibernate.connection.url");
        DRIVER_CLASS = properties.getProperty("hibernate.connection.driver_class");
    }




}
