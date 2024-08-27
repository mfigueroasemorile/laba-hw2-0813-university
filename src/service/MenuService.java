package service;

import exception.*;
import model.*;
import service.impl.BookServiceImpl;
import service.impl.StudentServiceImpl;
import service.impl.SubjectServiceImpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static constants.MenuConstants.*;

public class MenuService {

    static {
        System.out.println("---------------------------------------------------------");
        System.out.println("Welcome to University system.\n" +
                "Here you have a menu to interact with our functionality.\n" +
                "Enjoy!");
        System.out.println("---------------------------------------------------------\n\n");
    }

    private List<Student> students = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();

    StudentService studentService = new StudentServiceImpl();
    SubjectService subjectService = new SubjectServiceImpl();
    BookService bookService = new BookServiceImpl();

    public void displayMenu() throws StudentNullException, StudentNotEnrolledException, StudentBookListEmptyException, InvalidSubjectException {
        try (BufferedWriter logWriter = new BufferedWriter(new FileWriter("logfile.txt", true))) {

            int option;
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("--------- MENU ---------");
                logWriter.write("Displaying menu options.\n");

                System.out.println("1. Create new student");
                System.out.println("2. Create new subject");
                System.out.println("3. Enroll student to subject");
                System.out.println("4. Display subject per student");
                System.out.println("5. Display available subjects");
                System.out.println("6. Set new exam");
                System.out.println("7. Create book list");
                System.out.println("0. Exit");
                System.out.print("Select an option: ");

                option = scanner.nextInt();
                logWriter.write("User selected option: " + option + "\n");

                switch (option) {
                    case CREATE_STUDENT:
                        Student student = studentService.createStudent();
                        System.out.println("Student created");
                        System.out.println(student.toString());
                        students.add(student);
                        logWriter.write("Student created: " + student.toString() + "\n");
                        break;
                    case CREATE_SUBJECT:
                        Subject subject = subjectService.createSubject();
                        System.out.println("Subject created");
                        System.out.println(subject.toString());
                        subjects.add(subject);
                        logWriter.write("Subject created: " + subject.toString() + "\n");
                        break;
                    case ENROLL_STUDENT:
                        System.out.println("Insert student: ");
                        String studentName = scanner.next();
                        Student selectedStudent = studentService.searchStudentByName(studentName, students);

                        if (selectedStudent == null) {
                            throw new StudentNullException("Student dosen't exists");
                        }
                        System.out.println("Insert subject: ");
                        String subjectName = scanner.next();
                        Subject selectedSubject = subjectService.searchSubjectByName(subjectName, subjects);
                        if (selectedSubject == null) {
                            System.out.println("Subject not found");
                            throw new InvalidSubjectException("Subject doesn't exists");
                        }
                        studentService.enrollStudentToSubject(selectedStudent, selectedSubject);
                        System.out.println("Student " + selectedStudent.getFirstName() + " was successfully enrolled to " + selectedSubject.getName());
                        logWriter.write("Student " + selectedStudent.getFirstName() + " enrolled to " + selectedSubject.getName() + "\n");
                        break;
                    case DISPLAY_SUBJECT_STUDENT:
                        System.out.println("Insert student name: ");
                        String name = scanner.next();
                        Student s = studentService.searchStudentByName(name, students);
                        if (s == null) {
                            logWriter.write("Student doesn't exist exception" + "\n");
                            throw new StudentNullException("Student doesn't exist exception");
                        }
                        System.out.println("---------------------Subjects---------------------");
                        studentService.displayStudentSubject(s);
                        logWriter.write("Displayed subjects for student: " + s.getFirstName() + "\n");
                        break;
                    case DISPLAY_SUBJECTS:
                        subjectService.displaySubjectList(subjects);
                        logWriter.write("Displayed available subjects.\n");
                        break;
                    case SET_EXAM:
                        Professor professorCharlie = new Professor("5456654", "Charlie");
                        System.out.println("Insert subject: ");
                        String subjName = scanner.next();
                        System.out.println("Insert date (YYYY-MM-DD): ");
                        String examDate = scanner.next();
                        System.out.println("Insert classroom: ");
                        String examClassroom = scanner.next();
                        Exam exam = new Exam(professorCharlie, examDate, examClassroom);
                        subjects = subjectService.createExam(exam, subjects, subjName);
                        System.out.println("-----------Next exams--------------");
                        for (Subject subj : subjects) {
                            if (subj.getExam() != null) {
                                System.out.println("Subject: " + subj.getName());
                                System.out.println("Date: " + subj.getExam().getDate());
                                System.out.println("Professor: " + subj.getExam().getProffesor());
                                System.out.println("Classroom: " + subj.getExam().getClassroom());
                                System.out.println("---------------------------------");
                            }
                        }
                        logWriter.write("Exam set for subject: " + subjName + "\n");
                        break;
                    case CREATE_BOOKLIST:
                        Student st = new Student("123", "Chandler");
                        List<Book> bookList = new ArrayList<>();
                        Book b = new Book("Harry Potter", "JK Rowling");
                        studentService.displayStudentBookList(st);
                        logWriter.write("Displayed book list for student: " + st.getFirstName() + "\n");
                        break;
                    case EXIT:
                        System.out.println("Shutting down");
                        logWriter.write("System shutting down.\n");
                        break;
                    default:
                        System.out.println("Invalid option, please choose an option between 1 and 7.");
                        logWriter.write("Invalid option selected: " + option + "\n");
                }
            } while (option != 0);

        } catch (IOException | StudentNullException | StudentNotEnrolledException | StudentBookListEmptyException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws StudentNullException, StudentNotEnrolledException, StudentBookListEmptyException, InvalidSubjectException {
        MenuService menuService = new MenuService();
        menuService.displayMenu();
    }

}