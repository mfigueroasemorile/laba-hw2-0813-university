import model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        University university = new University();

        university.setName("LA model.University");
        university.setLocation(new Address("Washington St", "Los Angeles, California", "55555"));

        Campus campus = new Campus("Lawyer campus");

        Employee martin = new Employee("58945948","Martin","Johnson");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(martin);
        campus.setEmployees(employeeList);

        List<Student> studentsList = new ArrayList<>();
        campus.setEmployees(employeeList);

        //Assign subject to professor
        Professor professor = new Professor("88555858", "Tom", "Hanks");
        Subject math = new Subject("Math");
        professor.assignSubject(math);


        //Enroll student to Major
        Major itDegree = new Major();

        Student charlie = new Student("Charlie", "Charlies", itDegree);
        itDegree.setName("IT DEGREE");
        charlie.enrollStudent(itDegree);
    }
}