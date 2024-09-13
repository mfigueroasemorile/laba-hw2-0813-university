package model;

import java.util.ArrayList;
import java.util.List;
import Enum.StudentStatus;
public class Student extends Human {
    private Major major;
    private String shift;
    private List<Subject> currentsSubjects = new ArrayList<>();
    private List<Book> bookList = new ArrayList<>();
    private StudentStatus status;

    public Student(String ssn, String firstName, Major major) {
        super(firstName, ssn);
        this.firstName = firstName;
        this.ssn = ssn;
        this.major = major;
    }
    public Student(String ssn, String firstName) {
        super(firstName, ssn);
        this.firstName = firstName;
        this.ssn = ssn;
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

    public List<Subject> getCurrentsSubjects() {
        return currentsSubjects;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
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


    public void setCurrentsSubjects(List<Subject> currentsSubjects) {
        this.currentsSubjects = currentsSubjects;
    }

    public void enrollStudent(Major major){
        this.major = major;
        System.out.println("Student "+this.firstName+ " was successfully enroled to "+ major.getName());
    }

    public void enrollToSubject(Subject subject){
        currentsSubjects.add(subject);
    }


    @Override
    public void goToUniversity() {
        System.out.println("Student " +this.firstName+ " is going to study\n");
    }

    @Override
    public String toString(){
        return "ssn='" + ssn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", major='" + (major != null ? major.getName() : "No major assigned" + '\'');
    }

    @Override
    public boolean equals(Object object){
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Student student = (Student) object;
        return  (ssn != null ? ssn.equals(student.ssn) : student.ssn == null) &&
                (firstName != null ? firstName.equals(student.firstName) : student.firstName == null) &&
                (major != null ? major.equals(student.major) : student.major == null);

    }

    @Override
    public int hashCode() {
        int result = ssn.hashCode();
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        return result;
    }

}
