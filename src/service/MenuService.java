package service;

import model.Exam;
import model.Professor;
import model.Student;
import model.Subject;
import service.impl.StudentServiceImpl;
import service.impl.SubjectServiceImpl;

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
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("--------- MENU ---------");
            System.out.println("1. Create new student");
            System.out.println("2. Create new subject");
            System.out.println("3. Enroll student to subject");
            System.out.println("4. Display subject per student");
            System.out.println("5. Display available subjects");
            System.out.println("6. Set new exam");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");

            option = scanner.nextInt();


            switch (option) {
                case CREATE_STUDENT:
                    Student student = studentService.createStudent();
                    System.out.println("Student created");
                    System.out.println(student.toString());
                    students.add(student);
                    break;
                case CREATE_SUBJECT:
                    Subject subject = subjectService.createSubject();
                    System.out.println("Subject created");
                    System.out.println(subject.toString());
                    subjects.add(subject);
                    break;
                case ENROLL_STUDENT:
                    System.out.println("Insert student: ");
                    String studentName = scanner.next();
                    Student selectedStudent = studentService.searchStudentByName(studentName, students);

                    if (selectedStudent == null) {
                        System.out.println("Student not found");
                        break;
                    }
                    System.out.println("Insert subject: ");
                    String subjectName = scanner.next();
                    Subject selectedSubject = subjectService.searchSubjectByName(subjectName, subjects);
                    if (selectedSubject == null){
                        System.out.println("Subject not found");
                        break;
                    }
                    studentService.enrollStudentToSubject(selectedStudent, selectedSubject);
                    System.out.println("Student " + selectedStudent.getFirstName() + " was succesfully enroled to "+ selectedSubject.getName());
                    break;
                case DISPLAY_SUBJECT_STUDENT:
                    System.out.println("Insert student name: ");
                    String name = scanner.next();
                    Student s = studentService.searchStudentByName(name, students);
                    if (s == null) {
                        System.out.println("Student not found");
                        break;
                    }
                    System.out.println("---------------------Subjects---------------------");
                    studentService.displayStudentSubject(s);
                    break;
                case DISPLAY_SUBJECTS:
                    subjectService.displaySubjectList(subjects);
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
                    for (Subject subj: subjects){
                        if(subj.getExam() != null){
                            System.out.println("Subject: " + subj.getName());
                            System.out.println("Date: " + subj.getExam().getDate());
                            System.out.println("Proffesor: " +subj.getExam().getProffesor());
                            System.out.println("Classroom: " +subj.getExam().getClassroom());
                            System.out.println("---------------------------------");
                        }
                    }
                    break;
                case 8:
                    System.out.println("Shutting down");
                    break;
                default:
                    System.out.println("Invalid option, please choose an option between 1 and 8.");
            }
        } while (option != 8);

        scanner.close();
    }

    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        menuService.displayMenu();
    }
}

