import model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        University university = new University();
        university.setName("LA model.University");
        university.setLocation(new Address("Washington St", "Los Angeles, California", "55555"));


        Campus campus = new Campus("Lawyer campus");

        List<Major> majorsList = new ArrayList<>();
        majorsList.add(new Major("Law"));
        majorsList.add(new Major("IT"));
        campus.setMajors(majorsList);
        Role administrative = new Role("administrative");
        Employee martin = new Employee("58945948","Martin");
        martin.setRole(administrative);


        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(martin);
        campus.setEmployees(employeeList);

        //Assign subject to professor
        /*Professor professor = new Professor("88555858", "Tom");
        Subject math = new Subject("Math");
        professor.assignSubject(math);*/


        //Enroll student to Major
        /*charlie.enrollStudent(itDegree);*/

        //Proffesor going to work
        Professor professorJohn = new Professor("5978694", "John");
        professorJohn.goToUniversity();

        //Administrative going to work
        Employee admCharlie = new Employee("9858548", "Charlie");
        admCharlie.setRole(administrative);
        admCharlie.goToUniversity();

        //Student going to study
        Major itDegree = new Major();
        itDegree.setName("IT DEGREE");
        Student emily = new Student("9858784", "Emily", itDegree);
        emily.goToUniversity();

        //Employee toString
        System.out.println(admCharlie.toString());

        //Student toString
        System.out.println(emily.toString());

        //Book toString
        Book book = new Book("Harry Potter", "J.K. Rowling");
        System.out.println(book.toString());

        Employee employee1 = new Employee("123456", "Carlos");
        Employee employee2 = new Employee("123456", "Carlos");

        System.out.println(employee1.equals(employee2));
        System.out.println(employee1.hashCode() + ";" + employee2.hashCode());

        Book book1 = new Book("Harry Potter", "J.K. Rowling");
        Book book2 = new Book("Harry Potter", "J.K. Rowling");

        System.out.println(book1.equals(book2));
        System.out.println(book1.hashCode() + ";" + book2.hashCode());

        Student student1 = new Student("8956286", "Miranda", itDegree);
        Student student2 = new Student("8956286", "Miranda", itDegree);

        System.out.println(student2.equals(student1));
        System.out.println(student2.hashCode() + ";" + student1.hashCode());

    }
}