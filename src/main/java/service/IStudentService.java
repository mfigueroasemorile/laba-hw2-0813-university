package service;

import exception.StudentBookListEmptyException;
import exception.StudentNotEnrolledException;
import model.Book;
import model.Student;
import model.Subject;

import java.util.List;
import java.util.Set;

public interface IStudentService {
    Student createStudent();
    void enrollStudentToSubject (Student student, Subject subject);
    Student searchStudentByName(String name, Set<Student> students);
    void displayStudentSubject(Student student) throws StudentNotEnrolledException;
    void displayStudentBookList(Student s) throws StudentBookListEmptyException;
    void displayStudents (Set<Student> students);
    void assignBookToStudent(Book book, Student student);
}
