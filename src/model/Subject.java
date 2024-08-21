package model;

import java.util.List;

public class Subject {
    private long id;
    private String name;
    private Professor professor;
    private List<Student> students;
    private String shift;
    private int hoursPerWeek;

    public Subject(String name, Professor professor, int hoursPerWeek) {
        this.name = name;
        this.professor = professor;
        this.hoursPerWeek = hoursPerWeek;
    }

    public Subject(String name) {
        this.name = name;
    }

    public Subject(){

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getShift() {
        return shift;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", professor=" + professor +
                ", students=" + students +
                ", shift='" + shift + '\'' +
                ", hoursPerWeek=" + hoursPerWeek +
                '}';
    }
}
