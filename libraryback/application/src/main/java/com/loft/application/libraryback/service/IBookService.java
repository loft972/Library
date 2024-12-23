package com.loft.application.libraryback.service;

import com.loft.domain.libraryback.entity.Book;

import java.util.List;

public interface IBookService {

    public Book saveBook(Book book);
    public Book updateBook(Book book);
    public void deleteBook(Integer bookId);
    public List<Book> findBookByTitleOrPartTitle(String title);
    public Book findBookByIsbn(String isbn);
    public boolean checkIfIdExists(Integer id);
    public List<Book> getBookByCategory(String category);
}
