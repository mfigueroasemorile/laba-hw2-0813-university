package model;

import java.util.List;
import java.util.Objects;

public class Campus {

    private long campusId;
    private String name;



    private List<Major>  majors;
    private List<Employee> employees;

    public Campus(String name) {
        this.name = name;
    }

    public void setCampusId(long campusId) {
        this.campusId = campusId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public long getCampusId() {
        return campusId;
    }

    public String getName() {
        return name;
    }

    public List<Major> getMajors() {
        return majors;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Campus campus = (Campus) object;
        return campusId == campus.campusId && Objects.equals(name, campus.name) && Objects.equals(majors, campus.majors) && Objects.equals(employees, campus.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(campusId, name, majors, employees);
    }


}
