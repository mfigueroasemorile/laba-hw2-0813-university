package model;

public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private Major major;
    private String shift;
    //Preguntar: cuando es recomendable usar atributos publicos?

    public Student(String firstName, String lastName, Major major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Major getMajor() {
        return major;
    }

    public String getShift() {
        return shift;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
