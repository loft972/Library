package com.loft.libraryback.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "BOOK")
public class Book {

    private Integer id;
    private String isbn;
    private String title;
    private LocalDate releaseDate;
    private LocalDate registerDate;
    private Integer totalExamplaries;
    private String author;
    private Category category;
    private List<Loan> loans;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOK_ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "ISBN", nullable = false, unique = true)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Column(name = "TITLE", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "RELEASE_DATE")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Column(name = "REGISTER_DATE")
    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    @Column(name = "TOTAL_EXAMPLARIES")
    public Integer getTotalExamplaries() {
        return totalExamplaries;
    }

    public void setTotalExamplaries(Integer totalExamplaries) {
        this.totalExamplaries = totalExamplaries;
    }

    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "CAT_CODE", referencedColumnName = "CODE")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.book", cascade = CascadeType.ALL)
    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        return Objects.equals(getId(), book.getId()) && Objects.equals(getIsbn(), book.getIsbn()) && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getReleaseDate(), book.getReleaseDate()) && Objects.equals(getRegisterDate(), book.getRegisterDate()) && Objects.equals(getTotalExamplaries(), book.getTotalExamplaries()) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getCategory(), book.getCategory()) && Objects.equals(getLoans(), book.getLoans());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIsbn(), getTitle(), getReleaseDate(), getRegisterDate(), getTotalExamplaries(), getAuthor(), getCategory(), getLoans());
    }
}
