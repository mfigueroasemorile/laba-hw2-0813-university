package service;

import model.Major;
import model.Student;
import model.Subject;

import java.util.List;
import java.util.Scanner;

public class StudentService {

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

    public void enrollStudentToSubject (Student student, Subject subject){
        student.enrollToSubject(subject);
    }

    public Student searchStudentByName(String name, List<Student> students){
        for (Student student : students) {
            if (student.getFirstName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }
}
