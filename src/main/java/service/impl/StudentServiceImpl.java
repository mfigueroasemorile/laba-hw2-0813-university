package service.impl;

import exception.StudentBookListEmptyException;
import exception.StudentNotEnrolledException;
import lambda.Assigner;
import model.Book;
import model.Student;
import model.Subject;
import service.IStudentService;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import java.util.function.Consumer;

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
        Assigner<Student, Subject> subjectAssigner = (std, subj) -> std.enrollToSubject(subj);
        subjectAssigner.assign(student, subject);
    }

    @Override
    public Student searchStudentByName(String name, Set<Student> students){
        return students.stream()
                .filter(student -> student.getFirstName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void displayStudentSubject(Student student) throws StudentNotEnrolledException {
        List<Subject> subjects = student.getCurrentsSubjects();
        if(!subjects.isEmpty()){
            subjects.stream()
                    .map(Subject::getName)
                    .forEach(System.out::println);
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
            s.getBookList().stream()
                    .map(Book::getTitle)
                    .forEach(System.out::println);
            for(Book b : s.getBookList()){
                System.out.println(b.getTitle());
            }
        }
    }

    @Override
    public void displayStudents(Set<Student> students){

        //Implementation of Consumer to display all available students
        Consumer<Student> displayStudentInfo = st -> {
            System.out.println("Name: " + st.getFirstName());
            System.out.println("SSN: " + st.getSsn());
            };
        students.forEach(displayStudentInfo);

    }

    @Override
    public void assignBookToStudent(Book book, Student student){
        Assigner<Book, Student> bookAssigner = (b, s) -> {
            List<Book> bookList = s.getBookList();
            bookList.add(b);
            s.setBookList(bookList);
            System.out.println("Book " + b.getTitle() + " assigned to " + s.getFirstName());
        };
        bookAssigner.assign(book, student);
    }
}
