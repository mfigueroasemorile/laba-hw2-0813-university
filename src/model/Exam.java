package model;

import java.util.Date;

public class Exam {

    private Professor proffesor;
    private String date;
    private String classroom;

    public Exam(Professor proffesor, String date, String classroom){
        this.proffesor = proffesor;
        this.date = date;
        this.classroom = classroom;
    }
    public Professor getProffesor() {
        return proffesor;
    }

    public void setProffesor(Professor proffesor) {
        this.proffesor = proffesor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }


}
