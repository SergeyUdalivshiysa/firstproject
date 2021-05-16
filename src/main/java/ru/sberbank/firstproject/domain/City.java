package ru.sberbank.firstproject.domain;

import org.hibernate.annotations.NamedQueries;
import javax.persistence.*;
import java.util.Objects;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "DELETE", query = "delete from City c where c.name = :name"),
        @NamedQuery(name = "findByName", query = "select c from City c where c.name = :name")
})
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String region;
    private String district;
    private int population;
    private int foundation;


    public City(String name, String region, String district, int population, int foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public City() {

    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return population == city.population && foundation == city.foundation && Objects.equals(name, city.name) && Objects.equals(region, city.region) && Objects.equals(district, city.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region, district, population, foundation);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", yearOfFoundation=" + foundation +
                '}';
    }

}
