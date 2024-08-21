import model.*;
import service.MenuService;

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



        /*----------------------------------------------------------
        //Professor going to work
        System.out.println("------------Professor goToUniverity()------------\n");
        Professor professorJohn = new Professor("5978694", "John");
        professorJohn.goToUniversity();

        //Administrative going to work
        System.out.println("------------Administrative goToUniverity()------------\n");
        Employee admCharlie = new Employee("9858548", "Charlie");
        admCharlie.setRole(administrative);
        admCharlie.goToUniversity();

        //Student going to study
        System.out.println("------------Student goToUniverity()------------\n");
        Major itDegree = new Major();
        itDegree.setName("IT DEGREE");
        Student emily = new Student("9858784", "Emily", itDegree);
        emily.goToUniversity();

        //Employee toString
        System.out.println("------------Employee toString()------------\n");
        System.out.println(admCharlie.toString()+"\n");

        //Student toString
        System.out.println("------------Student toString()------------\n");
        System.out.println(emily.toString()+"\n");

        //Book toString
        System.out.println("------------Book toString------------"+"\n");
        Book book = new Book("Harry Potter", "J.K. Rowling");
        System.out.println(book.toString()+"\n");

        //Employee
        Employee employee1 = new Employee("123456", "Carlosss");
        Employee employee2 = new Employee("123456", "Carlos");

        System.out.println("------------Employee equals()------------\n");
        System.out.println(employee1.equals(employee2)+"\n");
        System.out.println("------------Employee hashCode()------------\n");
        System.out.println(employee1.hashCode() + ";" + employee2.hashCode()+"\n");

        //Book
        Book book1 = new Book("Harry Potterrr", "J.K. Rowling");
        Book book2 = new Book("Harry Potter", "J.K. Rowling");

        System.out.println("------------Book equals()------------\n");
        System.out.println(book1.equals(book2)+"\n");
        System.out.println("------------Book hashCode()------------\n");
        System.out.println(book1.hashCode() + ";" + book2.hashCode()+"\n");

        //Student
        Student student1 = new Student("8956286", "Miranda", itDegree);
        Student student2 = new Student("8956286", "Miranda", itDegree);

        System.out.println("------------Student equals()------------\n");
        System.out.println(student2.equals(student1)+"\n");
        System.out.println("------------Student hashCode()------------\n");
        System.out.println(student2.hashCode() + ";" + student1.hashCode()+"\n");

        //Campus
        Campus campus1 = new Campus("IT CAMPUS");
        Campus campus2 = new Campus("IT CAMPUS");

        System.out.println("------------Campus equals()------------\n");
        System.out.println(campus1.equals(campus2)+"\n");
        System.out.println("------------Campus hashCode()------------\n");
        System.out.println(campus1.hashCode() + ";" + campus2.hashCode() +"\n");
*/
        MenuService menuService = new MenuService();
        menuService.displayMenu();
    }
}