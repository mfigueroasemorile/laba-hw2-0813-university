package model;

import lombok.Data;
import Enum.BookType;
import java.util.*;

@Data
public class Book {

    private long id;
    private String title;
    private String author;
    private Queue<Student> studentQueueBook = new LinkedList<>();
    private BookType type;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void addStudentToQueue(Student student){
        this.studentQueueBook.offer(student);
    }

    public void getStudentsFromQueue() {
        System.out.println("---------------------------------------------");
        while (!studentQueueBook.isEmpty()) {
            Student student = studentQueueBook.poll();
            System.out.println(student.getFirstName());
        }
    }
}
