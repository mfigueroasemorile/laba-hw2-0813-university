package model;

import java.util.*;

public class Book {

    private long id;
    private String title;
    private String author;
    private Queue<Student> studentQueueBook = new LinkedList<>();

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString(){
        return  "id='" + id + '\'' +
                ", book title='" + title  + '\'' +
                ", author ='" + author  + '\'';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Book book = (Book) object;
        return  id == book.id &&
                (title != null ? title.equals(book.title) : book.title == null) &&
                (author != null ? author.equals(book.author) : book.author == null);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;

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
