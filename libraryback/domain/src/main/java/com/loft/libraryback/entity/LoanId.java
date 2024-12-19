package com.loft.libraryback.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class LoanId {

    private Book book;
    private Customer customer;
    private LocalDateTime creationDateTime;

    public LoanId() {}

    public LoanId(Book book, Customer customer) {
        this.book = book;
        this.customer = customer;
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
        if (!(o instanceof LoanId loanId)) return false;
        return Objects.equals(getBook(), loanId.getBook()) && Objects.equals(getCustomer(), loanId.getCustomer()) && Objects.equals(getCreationDateTime(), loanId.getCreationDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBook(), getCustomer(), getCreationDateTime());
    }
}
