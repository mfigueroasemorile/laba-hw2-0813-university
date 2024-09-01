package service;

import exception.*;
import generic.People;
import generic.PeopleLinkedList;
import model.*;
import service.impl.BookServiceImpl;
import service.impl.StudentServiceImpl;
import service.impl.SubjectServiceImpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static constants.MenuConstants.*;

public class MenuService {

    static {
        System.out.println("---------------------------------------------------------");
        System.out.println("Welcome to University system.\n" +
                "Here you have a menu to interact with our functionality.\n" +
                "Enjoy!");
        System.out.println("---------------------------------------------------------\n\n");
    }

    private Set<Student> students = new HashSet<>();
    private List<Subject> subjects = new ArrayList<>();
    private Map<Subject, Professor> subjectProfessorMap = new HashMap<>();
    IStudentService studentService = new StudentServiceImpl();
    ISubjectService subjectService = new SubjectServiceImpl();
    IBookService bookService = new BookServiceImpl();

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
                System.out.println("8. Assign professor to subject");
                System.out.println("0. Exit");
                System.out.print("Select an option: ");

                option = scanner.nextInt();
                logWriter.write("User selected option: " + option + "\n");

                switch (option) {
                    case CREATE_STUDENT:
                        Student student = studentService.createStudent();
                        if (students.contains(student)){
                            System.out.println("A student with this SSN already exists.");
                            logWriter.write("Attempted to create a duplicate student: " + student.toString() + "\n");
                        } else {
                            students.add(student);
                            System.out.println("Student created successfully.");
                            logWriter.write("Student created: " + student.toString() + "\n");
                        }
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
                        st.setBookList(bookService.createBookList(bookList, b));
                        studentService.displayStudentBookList(st);
                        logWriter.write("Displayed book list for student: " + st.getFirstName() + "\n");
                        break;

                    case ASSIGN_PROFESSOR:
                        Professor p1 = new Professor("54321", "Louis");
                        Professor p2 = new Professor("12345", "Walter");
                        Subject math = new Subject("Math");
                        Subject law = new Subject("Law");
                        subjectService.assignProfessorToSubject(math,p1,subjectProfessorMap);
                        subjectService.assignProfessorToSubject(law,p2,subjectProfessorMap);
                        System.out.println("---------------------------------------------");
                        for (Map.Entry<Subject, Professor> entry : subjectProfessorMap.entrySet()) {
                            System.out.println(entry.getKey().getName() + ":" + entry.getValue().getFirstName());
                        }
                        System.out.println("---------------------------------------------");
                        break;
                    case STUDENTS_QUEUE:
                        Book harryPotter = new Book("Harry Potter", "JKR");
                        Student s1 = new Student("1233", "Saul");
                        Student s2 = new Student("4567", "Gustavo");
                        harryPotter.addStudentToQueue(s1);
                        harryPotter.addStudentToQueue(s2);
                        harryPotter.getStudentsFromQueue();
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
        } catch (InputMismatchException e){
            System.out.println(e.getMessage());
            System.out.println("Invalid option, please enter a number");
            this.displayMenu();
        }
    }

    public static void main(String[] args) throws StudentNullException, StudentNotEnrolledException, StudentBookListEmptyException, InvalidSubjectException {

        PeopleLinkedList<Student> studentsLinkedList = new PeopleLinkedList<>();
        Student s1 = new Student("12345", "Michael");
        Student s2 = new Student("43221", "Richard");
        Student s3 = new Student("78945", "Emily");

        System.out.println("Adding 3 students\n");
        studentsLinkedList.add(0,s1);
        studentsLinkedList.add(1,s2);
        studentsLinkedList.add(2,s3);

        studentsLinkedList.displayList(studentsLinkedList);

        System.out.println("Removing index 1\n");
        studentsLinkedList.remove(1);
        studentsLinkedList.displayList(studentsLinkedList);

        System.out.println("Removing Emily\n");
        studentsLinkedList.remove(s3);
        studentsLinkedList.displayList(studentsLinkedList);

        System.out.println("Getting first index\n");
        System.out.println(studentsLinkedList.get(0));

        System.out.println("\nSet student in first place\n");
        studentsLinkedList.set(0,s2);
        studentsLinkedList.displayList(studentsLinkedList);
        /*MenuService menuService = new MenuService();
        menuService.displayMenu();*/
    }

}