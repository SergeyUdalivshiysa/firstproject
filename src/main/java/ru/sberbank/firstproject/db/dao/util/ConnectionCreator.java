package ru.sberbank.firstproject.db.dao.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sberbank.firstproject.domain.City;



public class ConnectionCreator {

    public static SessionFactory getSessionFactory() {
        Configuration cfg = new Configuration()
                .addAnnotatedClass(City.class)
                .setProperty("hibernate.connection.url", PropertiesManager.URL)
                .setProperty("hibernate.connection.driver_class", PropertiesManager.DRIVER_CLASS);
        return cfg.buildSessionFactory();
    }
}
