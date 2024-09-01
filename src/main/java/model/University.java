package model;

import java.util.List;

public class University {


    private String name;
    private List<Campus> campus;
    private Address location;
    private List<Student> students;
    private Employee director;

    private static final Address DEFAULT_LOCATION;
    private static final Employee DEFAULT_DIRECTOR;
    static {
        DEFAULT_LOCATION = new Address("123 Lexington Ave", "Los Angeles", "US");
        DEFAULT_DIRECTOR = new Employee("1566654", "Eduard");
    }
    public University(String name, Address location) {
        this.name = name;
        this.location = DEFAULT_LOCATION;
        this.director = DEFAULT_DIRECTOR;
    }

    public University(){
        this.location = DEFAULT_LOCATION;
        this.director = DEFAULT_DIRECTOR;
    }

    public Address getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public List<Campus> getCampus() {
        return campus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCampus(List<Campus> campus) {
        this.campus = campus;
    }

    public void setLocation(Address location) {
        this.location = location;
    }
}
