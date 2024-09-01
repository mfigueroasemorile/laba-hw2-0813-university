package service.impl;

import exception.StudentBookListEmptyException;
import exception.StudentNotEnrolledException;
import model.Book;
import model.Student;
import model.Subject;
import service.IStudentService;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public final class StudentServiceImpl implements IStudentService {

    @Override
    public Student createStudent(){
        Scanner scanner = new Scanner(System.in);
        String name;
        String ssn;
        System.out.println("Insert ssn: ");
        ssn = scanner.next();
        System.out.println("Insert name: ");
        name = scanner.next();
        Student student = new Student(ssn,name);
        return student;
    }

    @Override
    public void enrollStudentToSubject (Student student, Subject subject){
        student.enrollToSubject(subject);
    }

    @Override
    public Student searchStudentByName(String name, Set<Student> students){
        for (Student student : students) {
            if (student.getFirstName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void displayStudentSubject(Student student) throws StudentNotEnrolledException {
        List<Subject> subjects = student.getCurrentsSubjects();
        if(!subjects.isEmpty()){
        for(Subject s : subjects) {
            System.out.println(s.getName());
        }
        } else {
            System.out.println("Student is not enroled to any subject");
            throw new StudentNotEnrolledException("Student is not enroled to any subject exception");
        }
    }

    @Override
    public void displayStudentBookList(Student s) throws StudentBookListEmptyException {
        if(s.getBookList().isEmpty()){
            //System.out.println("Student book list is empty");
            throw new StudentBookListEmptyException("Student book list is empty exception");
        } else {
            for(Book b : s.getBookList()){
                System.out.println(b.getTitle());
            }
        }
    }
}
