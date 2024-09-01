package model;

public abstract class Human {
    protected String ssn;
    protected String firstName;
    protected String lastName;
    protected Address Address;

    public Human(String ssn, String firstName) {
        this.ssn = ssn;
        this.firstName = firstName;
    }

    public abstract void goToUniversity();
}
