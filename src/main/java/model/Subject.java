package model;

import lombok.Data;

import java.util.List;
import Enum.SubjectCategory;
@Data
public class Subject {
    private long id;
    private String name;
    private Professor professor;
    private List<Student> students;
    private String shift;
    private int hoursPerWeek;
    private Exam exam;
    private SubjectCategory subjectCategory;

    public Subject(String name, Professor professor, int hoursPerWeek) {
        this.name = name;
        this.professor = professor;
        this.hoursPerWeek = hoursPerWeek;
    }

    public Subject(String name) {
        this.name = name;
    }

    public Subject(){}
}
