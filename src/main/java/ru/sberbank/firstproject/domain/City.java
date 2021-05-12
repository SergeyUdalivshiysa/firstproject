package ru.sberbank.firstproject.domain;

public class City {
    private int id;
    private String name;
    private String region;
    private String district;
    private int population;
    private int foundation;

    public City(int id, String name, String region, String district, int population, int foundation) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public int getId() {
        return id;
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
