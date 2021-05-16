package ru.sberbank.firstproject.db.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.sberbank.firstproject.db.dao.util.CityDAOInterface;
import ru.sberbank.firstproject.db.dao.util.ConnectionCreator;
import ru.sberbank.firstproject.domain.City;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class CityDAO implements CityDAOInterface {

    public static void postCity(City city) {
        Session session = ConnectionCreator.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
        session.close();
    }

    public static void updateCity(City city) {
        Session session = ConnectionCreator.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(city);
        transaction.commit();
        session.close();
    }

    public static void deleteCityByName(String name) {
        Session session = ConnectionCreator.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createNamedQuery("DELETE").setParameter("name", name).executeUpdate();
        transaction.commit();
        session.close();
    }

    public static City getCityByName(String name) {
        try (Session session = ConnectionCreator.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            City city = session.createNamedQuery("findByName", City.class).setParameter("name", name).getSingleResult();
            transaction.commit();
            session.close();
            return city;
        }
        catch (NoResultException e) {
            return null;
        }
    }

    public static List<City> getAllCities() {
        Session session = ConnectionCreator.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaQuery<City> criteriaQuery = session.getCriteriaBuilder().createQuery(City.class);
        CriteriaQuery<City> all = criteriaQuery.select(criteriaQuery.from(City.class));
        List<City> cities = session.createQuery(all).getResultList();
        transaction.commit();
        session.close();
        return cities;
    }


}
