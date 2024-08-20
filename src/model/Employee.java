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
        System.out.println("Employee " + this.getFirstName() + " is going to university to work as a " + (this.role != null ? role.getRoleName()+"\n" : "generic worker"+"\n"));
    }

    @Override
    public String toString(){
        return
                "ssn='" + ssn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", role=" + (role != null ? role.getRoleName() : "No Role Assigned");
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        Employee employee = (Employee) object;
        return  (ssn != null ? ssn.equals(employee.ssn) : employee.ssn == null) &&
                (firstName != null ? firstName.equals(employee.firstName) : employee.firstName == null) &&
                (role != null ? role.equals(employee.role) : employee.role == null);
    }

    @Override
    public int hashCode() {
        int result = ssn.hashCode();
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}

