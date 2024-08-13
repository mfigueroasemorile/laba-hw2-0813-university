import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        University university = new University();

        university.setName("LA University");
        university.setLocation(new Address("Washington St", "Los Angeles, California", "55555"));

        Campus campus = new Campus("Lawyer campus");

        Employee martin = new Employee("58945948","Martin","Johnson");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(martin);
        campus.setEmployees(employeeList);

        List<Student> studentsList = new ArrayList<>();
        Major itDegree = new Major();
        itDegree.setName("IT DEGREE");
        Student charlie = new Student("Charlie", "Charlies", itDegree);
        studentsList.add(charlie);
    }
}