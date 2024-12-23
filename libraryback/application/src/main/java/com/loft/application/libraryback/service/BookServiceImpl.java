package com.loft.application.libraryback.service;

import com.loft.application.libraryback.repository.IBookRepository;
import com.loft.domain.libraryback.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("bookService")
@Transactional
public class BookServiceImpl implements IBookService{

    private final IBookRepository repository;

    public BookServiceImpl(IBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book saveBook(Book book) {
        return repository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return repository.save(book);
    }

    @Override
    public void deleteBook(Integer bookId) {
        repository.deleteById(bookId);
    }

    @Override
    public List<Book> findBookByTitleOrPartTitle(String title) {
        return repository.findByTitleLikeIgnoreCase("%" + title + "%");
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return repository.findByIsbnIgnoreCase(isbn);
    }

    @Override
    public boolean checkIfIdExists(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public List<Book> getBookByCategory(String codeCategory) {
        return repository.findByCategory(codeCategory);
    }
}
