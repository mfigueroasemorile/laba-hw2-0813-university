package model;

import java.util.List;

public class Book {

    private long id;
    private String title;
    private String author;

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

}
