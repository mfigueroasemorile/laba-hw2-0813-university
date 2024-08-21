package service;

import model.Student;
import model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MenuService {

    private List<Student> students = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();

    StudentService studentService = new StudentService();
    SubjectService subjectService = new SubjectService();
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("--------- MENU ---------");
            System.out.println("1. Create new student");
            System.out.println("2. Create new subject");
            System.out.println("3. Enroll student to subject");
            System.out.println("4. Show subject per student");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            option = scanner.nextInt();


            switch (option) {
                case 1:
                    Student student = studentService.createStudent();
                    System.out.println("Student created");
                    System.out.println(student.toString());
                    students.add(student);
                    break;
                case 2:
                    Subject subject = subjectService.createSubject();
                    System.out.println("Subject created");
                    System.out.println(subject.toString());
                    subjects.add(subject);
                    break;
                case 3:
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
                    }
                    studentService.enrollStudentToSubject(selectedStudent, selectedSubject);
                    System.out.println("Student " + selectedStudent.getFirstName() + " was succesfully enroled to "+ selectedSubject.getName());
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción entre 1 y 6.");
            }
        } while (option != 6);

        scanner.close();
    }

    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        menuService.displayMenu();
    }
}

