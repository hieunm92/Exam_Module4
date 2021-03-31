package com.c1020g1.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Min(value = 1 )
    private double landArea;
    @Min(value = 1)
    private int population;
    @Min(value = 1)
    private int gdp;
    private String cityDescription;

    @ManyToOne
    private Nation nation;

    public City() {
    }

    public City(Long id, String name, double landArea, int population, int gdp, String cityDescription, Nation nation) {
        this.id = id;
        this.name = name;
        this.landArea = landArea;
        this.population = population;
        this.gdp = gdp;
        this.cityDescription = cityDescription;
        this.nation = nation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLandArea() {
        return landArea;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getGdp() {
        return gdp;
    }

    public void setGdp(int gdp) {
        this.gdp = gdp;
    }

    public String getCityDescription() {
        return cityDescription;
    }

    public void setCityDescription(String cityDescription) {
        this.cityDescription = cityDescription;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }
}
