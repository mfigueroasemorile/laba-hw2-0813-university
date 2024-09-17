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
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static constants.MenuConstants.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MenuService {

    static {
        System.out.println("---------------------------------------------------------");
        System.out.println("Welcome to University system.\n" +
                "Here you have a menu to interact with our functionality.\n" +
                "Enjoy!");
        System.out.println("---------------------------------------------------------\n\n");
    }

    private static final Logger LOGGER = LogManager.getLogger(MenuService.class);
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
                LOGGER.info("Displaying menu options.\n");

                System.out.println("1. Create new student");
                System.out.println("2. Create new subject");
                System.out.println("3. Enroll student to subject");
                System.out.println("4. Display subject per student");
                System.out.println("5. Display available subjects");
                System.out.println("6. Set new exam");
                System.out.println("7. Create book list");
                System.out.println("8. Assign professor to subject");
                System.out.println("9. Student queue");
                System.out.println("10. Display all students");
                System.out.println("0. Exit");
                System.out.print("Select an option: ");

                option = scanner.nextInt();
                LOGGER.info("User selected option: " + option + "\n");

                switch (option) {
                    case CREATE_STUDENT:
                        Student student = studentService.createStudent();
                        //Implementation of Predicate:
                        Predicate<Student> studentExists = s1 -> s1.getFirstName().equals(student.getFirstName());
                        boolean exists = students.stream().anyMatch(studentExists);
                        if (exists){
                            System.out.println("This student already exists");
                            LOGGER.error("Attempted to create a duplicate student: " + student.toString() + "\n");
                        } else {
                            students.add(student);
                            System.out.println("Student created successfully.");
                            LOGGER.info("Student created: " + student.toString() + "\n");
                        }
                        break;
                    case CREATE_SUBJECT:
                        Subject subject = subjectService.createSubject();
                        System.out.println("Subject created");
                        System.out.println(subject.toString());
                        subjects.add(subject);
                        LOGGER.info("Subject created: " + subject.toString() + "\n");
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
                        //Implementation of BiConsumer to enrroll student to subject:
                        BiConsumer<Student,Subject> enrollStudent = (st, sj) ->selectedStudent.enrollToSubject(selectedSubject);
                        enrollStudent.accept(selectedStudent,selectedSubject);
//                        studentService.enrollStudentToSubject(selectedStudent, selectedSubject);

                        System.out.println("Student " + selectedStudent.getFirstName() + " was successfully enrolled to " + selectedSubject.getName());
                        LOGGER.info("Student " + selectedStudent.getFirstName() + " enrolled to " + selectedSubject.getName() + "\n");
                        break;
                    case DISPLAY_SUBJECT_STUDENT:
                        System.out.println("Insert student name: ");
                        String name = scanner.next();
                        Student s = studentService.searchStudentByName(name, students);
                        if (s == null) {
                            LOGGER.info("Student doesn't exist exception" + "\n");
                            throw new StudentNullException("Student doesn't exist exception");
                        }
                        System.out.println("---------------------Subjects---------------------");
                        studentService.displayStudentSubject(s);
                        LOGGER.info("Displayed subjects for student: " + s.getFirstName() + "\n");
                        break;
                    case DISPLAY_SUBJECTS:
                        subjectService.displaySubjectList(subjects);
                        LOGGER.info("Displayed available subjects.\n");
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
                        LOGGER.info("Exam set for subject: " + subjName + "\n");
                        break;
                    case CREATE_BOOKLIST:
                        Student st = new Student("123", "Chandler");
                        List<Book> bookList = new ArrayList<>();
                        Book b = new Book("Harry Potter", "JK Rowling");
                        st.setBookList(bookService.createBookList(bookList, b));
                        studentService.displayStudentBookList(st);
                        LOGGER.info("Displayed book list for student: " + st.getFirstName() + "\n");
                        break;

                    case ASSIGN_PROFESSOR:
                        System.out.println("Insert professor ssn: ");
                        String ssnp1 = scanner.next();
                        System.out.println("Insert professor name: ");
                        String namep1 = scanner.next();
                        System.out.println("Insert subject name: ");
                        String s1 = scanner.next();
                        Professor p1 = new Professor(ssnp1, namep1);
                        Subject subjSelected = subjectService.searchSubjectByName(s1, subjects);
                        if (subjSelected != null){
                            subjectService.assignProfessorToSubject(subjSelected,p1,subjectProfessorMap);
                            System.out.println("---------------------------------------------");
                            subjectProfessorMap.forEach((subj, professor) ->{
                                LOGGER.info("Professor: " + professor.getFirstName() + " assigned to " + subj.getName());
                            });
                            System.out.println("---------------------------------------------");

                        } else {
                            LOGGER.error("Subject does not exist");
                        }
                        break;
                    case STUDENTS_QUEUE:
                        Book harryPotter = new Book("Harry Potter", "JKR");
                        Student subj1 = new Student("1233", "Saul");
                        Student subj2 = new Student("4567", "Gustavo");
                        harryPotter.addStudentToQueue(subj1);
                        harryPotter.addStudentToQueue(subj2);
                        harryPotter.getStudentsFromQueue();
                        break;
                    case DISPLAY_STUDENTS:
                        studentService.displayStudents(students);
                        break;
                    case EXIT:
                        LOGGER.info("System shutting down.\n");
                        break;
                    default:
                        LOGGER.info("Invalid option selected: " + option + "\n");
                        System.out.println("Invalid option, please choose an option between 1 and 7.");
                }
            } while (option != 0);

        } catch (IOException | StudentNullException | StudentNotEnrolledException | StudentBookListEmptyException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e){
            System.out.println(e.getMessage());
            LOGGER.error("Invalid option");
            System.out.println("Invalid option, please enter a number");
            this.displayMenu();
        }
    }

    public static void main(String[] args) throws StudentNullException, StudentNotEnrolledException, StudentBookListEmptyException, InvalidSubjectException {

/*        PeopleLinkedList<Student> studentsLinkedList = new PeopleLinkedList<>();
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
        studentsLinkedList.displayList(studentsLinkedList);*/
        MenuService menuService = new MenuService();
        menuService.displayMenu();
    }

}