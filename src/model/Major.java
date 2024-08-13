package model;

import java.util.List;

public class Major {
    private long id;
    private String name;
    private List<Subject> subjects;

    public Major(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }
    public Major(){
    }

    public Major(String name){
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
