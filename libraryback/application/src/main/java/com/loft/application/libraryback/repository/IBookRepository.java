package com.loft.application.libraryback.repository;

import com.loft.domain.libraryback.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

    public Book findByIsbnIgnoreCase(String isbn);

    public List<Book> findByTitleLikeIgnoreCase(String title);

        @Query("Select b"
        + "FROM Book b"
        + "INNER JOIN b.category cat"
        + "WHERE cat.code = :code")
    public List<Book> findByCategory(@Param("code") String codeCategory);
}
