package service;

import model.Book;
import model.Student;

import java.util.List;

public interface BookService {
    Book createNewBook(String title, String author);
    Book updateBook(Book book, Book updatedBook);
    List<Book> createBookList(List<Book> bookList, Book book);
}
