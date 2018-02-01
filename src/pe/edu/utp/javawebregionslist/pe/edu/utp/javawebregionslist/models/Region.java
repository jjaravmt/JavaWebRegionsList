package pe.edu.utp.javawebregionslist.pe.edu.utp.javawebregionslist.models;

public class Region {
    private int id;
    private String name;

    public Region() {
        this.id=id;
        this.name=name;
    }

    public Region(int Id, String name) {
        this.id=id;
        this.name=name;
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
}
