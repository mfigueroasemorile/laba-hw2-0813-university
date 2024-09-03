package model;

import lombok.Data;

@Data
public class Employee extends Human{

    private Role role;
    public Employee(String ssn, String firstName) {
        super(ssn,firstName);
        this.ssn = ssn;
        this.firstName = firstName;
    }

    @Override
    public void goToUniversity() {
        System.out.println("Employee " + this.getFirstName() + " is going to university to work as a " + (this.role != null ? role.getRoleName()+"\n" : "generic worker"+"\n"));
    }

}

