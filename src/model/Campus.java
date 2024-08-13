package model;

import java.util.List;

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


}
