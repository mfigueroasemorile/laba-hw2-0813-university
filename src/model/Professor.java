package model;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Employee{

    private List<Subject> subjects;
    private String shift;

    public Professor(String ssn, String firstName) {
        super(ssn, firstName);
        this.setRole(new Role("professor"));
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

    public void assignSubject(Subject subject){
        List<Subject> assignedSubjects = new ArrayList<>();
        assignedSubjects.add(subject);
        this.subjects = assignedSubjects;
        System.out.println("Professor "+ this.getFirstName()+" was succesfully assigned to subject "+ subject.getName());
    }
}
