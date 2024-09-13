package model;

import java.util.Date;
import Enum.ExamType;
import lombok.Data;

@Data
public class Exam {

    private Professor proffesor;
    private String date;
    private String classroom;
    private ExamType examType;

    public Exam(Professor proffesor, String date, String classroom){
        this.proffesor = proffesor;
        this.date = date;
        this.classroom = classroom;
    }



}
