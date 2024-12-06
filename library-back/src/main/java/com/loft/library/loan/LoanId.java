package com.loft.library.loan;

import com.loft.library.book.Book;
import com.loft.library.customer.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class LoanId {

    private static final long serialVersionUID = 3912193101593832821L;
    private Book book;
    private Customer customer;
    private LocalDateTime creationDateTime;

    public LoanId() {
        super();
    }

    public LoanId(Book book, Customer customer) {
        super();
        this.book = book;
        this.customer = customer;
        this.creationDateTime = LocalDateTime.now();
    }

    @ManyToOne
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToOne
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name = "CREATION_DATE_TIME")
    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoanId loan)) return false;
        return Objects.equals(getBook(), loan.getBook()) && Objects.equals(getCustomer(), loan.getCustomer()) && Objects.equals(getCreationDateTime(), loan.getCreationDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBook(), getCustomer(), getCreationDateTime());
    }
}
