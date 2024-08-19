package model;

public class Employee extends Human{

    private Role role;
    public Employee(String ssn, String firstName) {
        super(ssn,firstName);
        this.ssn = ssn;
        this.firstName = firstName;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSsn() {
        return ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public void goToUniversity() {
        System.out.println("Employee " + this.getFirstName() + " is going to university to work as a " + (this.role != null ? role.getRoleName() : "generic worker"));
    }

    @Override
    public String toString(){
        return
                "ssn='" + ssn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", role=" + (role != null ? role.getRoleName() : "No Role Assigned");
    }
}

