package model;

import lombok.Data;

@Data
public abstract class Human {
    protected String ssn;
    protected String firstName;
    protected String lastName;
    protected Address Address;

    public Human(String ssn, String firstName) {
        this.ssn = ssn;
        this.firstName = firstName;
    }
    public Human (){}

    public abstract void goToUniversity();
}
