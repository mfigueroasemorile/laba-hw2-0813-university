package service;

import model.Book;

import java.util.List;

public interface BookService {
    Book createNewBook(String title, String author);
    Book udateBook(Book book, Book updatedBook);
    List<Book> createBookList(List<Book> bookList, Book book);
}
