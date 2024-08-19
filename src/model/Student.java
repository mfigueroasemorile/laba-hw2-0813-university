package model;

public class Student extends Human {
    private Major major;
    private String shift;

    public Student(String ssn, String firstName, Major major) {
        super(firstName, ssn);
        this.firstName = firstName;
        this.ssn = ssn;
        this.major = major;
    }


    public String getFirstName() {
        return firstName;
    }

    public Major getMajor() {
        return major;
    }

    public String getShift() {
        return shift;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public void enrollStudent(Major major){
        this.major = major;
        System.out.println("Student "+this.firstName+ " was successfully enroled to "+ major.getName());
    }

    @Override
    public void goToUniversity() {
        System.out.println("Student " +this.firstName+ " is going to study");
    }

    @Override
    public String toString(){
        return "ssn='" + ssn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", major='" + (major != null ? major.getName() : "No major assigned" + '\'');
    }
}
