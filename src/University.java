import java.util.List;

public class University {

    public University(String name, Address location) {
        this.name = name;
        this.location = location;
    }

    public University(){

    }

    private String name;
    private List<Campus> campus;
    private Address location;

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
