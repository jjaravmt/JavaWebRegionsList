package pe.edu.utp.javawebregionslist.pe.edu.utp.javawebregionslist.models;

import java.util.List;

public class Region {
    private int id;
    private String name;
    private List<Country> countries;

    public Region() {
        this.id=id;
        this.name=name;
    }

    public Region(int Id, String name) {
        this.id=id;
        this.name=name;
    }

    public Region(int id, String name, List<Country> countries) {
        this.id = id;
        this.name = name;
        this.countries = countries;
    }

    public int getId() {
        return id;
    }

    public Region setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Region setName(String name) {
        this.name = name;
        return this;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public Region setCountries(List<Country> countries) {
        this.countries = countries;
        return this;
    }
}
