package service;

import model.Student;
import model.Subject;

import java.util.List;

public interface StudentService {
    Student createStudent();
    void enrollStudentToSubject (Student student, Subject subject);
    Student searchStudentByName(String name, List<Student> students);
    void displayStudentSubject(Student student);
    void displayStudentBookList(Student s);
}
