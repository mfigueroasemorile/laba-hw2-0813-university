package model;

public class Employee {


    private String ssn;
    private String firstName;
    private String lastName;
    private Address address;
    private Role role;

    public Employee(String ssn, String firstName, String lastName) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getSsn() {
        return ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public Role getRole() {
        return role;
    }


}
