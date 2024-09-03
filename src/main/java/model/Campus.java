package model;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Campus {

    private long campusId;
    private String name;
    private List<Major>  majors;
    private List<Employee> employees;

    public Campus(String name) {
        this.name = name;
    }
}
