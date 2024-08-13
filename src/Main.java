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

        Employee martin = new Employee("58945948","Martin","Johnson");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(martin);
        campus.setEmployees(employeeList);

        //Major
        Major itDegree = new Major();
        itDegree.setName("IT DEGREE");

        //Students list
        Student charlie = new Student("Charlie", "Charlies", itDegree);
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(charlie);

        //Assign subject to professor
        Professor professor = new Professor("88555858", "Tom", "Hanks");
        Subject math = new Subject("Math");
        professor.assignSubject(math);


        //Enroll student to Major
        charlie.enrollStudent(itDegree);
    }
}