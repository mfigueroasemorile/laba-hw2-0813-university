package service.impl;

import model.Book;
import service.IBookService;

import java.util.List;

public final class BookServiceImpl implements IBookService {

    @Override
    public Book createNewBook(String title, String author){
        return new Book(title, author);
    }

    @Override
    public Book updateBook(Book book, Book updatedBook){
        book.setAuthor(updatedBook.getAuthor());
        book.setId(updatedBook.getId());
        book.setTitle(updatedBook.getTitle());

        return book;
    }
    @Override
    public List<Book> createBookList(List<Book> bookList, Book book){
        for(Book b : bookList){
            if(b.equals(book)){
                System.out.println("The list wasn't updated because the book is already in the list");
                return bookList;
            }
        }
        bookList.add(book);
        System.out.println("List updated.");
        return bookList;
    }
}
