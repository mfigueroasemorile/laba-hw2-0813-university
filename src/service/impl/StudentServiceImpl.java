package service.impl;

import model.Book;
import model.Student;
import model.Subject;
import service.StudentService;

import java.util.List;
import java.util.Scanner;

public final class StudentServiceImpl implements StudentService {

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
    public Student searchStudentByName(String name, List<Student> students){
        for (Student student : students) {
            if (student.getFirstName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void displayStudentSubject(Student student){
        List<Subject> subjects = student.getCurrentsSubjects();
        if(subjects.isEmpty()){
        for(Subject s : subjects) {
            System.out.println(s.getName());
        }
        } else {
            System.out.println("Student is not enroled to any subject");
        }
    }

    @Override
    public void displayStudentBookList(Student s){
        if(s.getBookList().isEmpty()){
            System.out.println("Student book list is empty");
        } else {
            for(Book b : s.getBookList()){
                System.out.println(b.getTitle());
            }
        }
    }
}
