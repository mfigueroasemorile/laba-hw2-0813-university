package model;

import java.util.List;

public class Professor extends Employee{

    private List<Subject> subjects;
    private String shift;

    public Professor(String ssn, String firstName, String lastName, List<Subject> subjects, String shift) {
        super(ssn, firstName, lastName);
        this.subjects = subjects;
        this.shift = shift;
    }
    public List<Subject> getSubjects() {
        return subjects;
    }

    public String getShift() {
        return shift;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}
