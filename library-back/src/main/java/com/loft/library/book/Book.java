package com.loft.library.book;

import com.loft.library.category.Category;
import com.loft.library.loan.Loan;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BOOK")
public class Book {

    private Integer id;
    private String title;
    private String isbn;
    private LocalDate releaseDate;
    private LocalDate registerDate;
    private Integer totalExamplaries;
    private String author;
    private Category category;
    Set<Loan> loans = new HashSet<Loan>();


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOK_ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "TITLE", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "ISBN", nullable = false, unique = true)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Column(name = "RELEASE_DATE", nullable = false)
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Column(name = "REGISTER_DATE", nullable = false)
    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
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
    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    @Column(name = "TOTAL_EXAMPLARIES")
    public Integer getTotalExamplaries() {
        return totalExamplaries;
    }

    public void setTotalExamplaries(Integer totalExamplaries) {
        this.totalExamplaries = totalExamplaries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(getId(), book.getId()) && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getIsbn(), book.getIsbn()) && Objects.equals(getReleaseDate(), book.getReleaseDate()) && Objects.equals(getRegisterDate(), book.getRegisterDate()) && Objects.equals(getTotalExamplaries(), book.getTotalExamplaries()) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getCategory(), book.getCategory()) && Objects.equals(getLoans(), book.getLoans());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getIsbn(), getReleaseDate(), getRegisterDate(), getTotalExamplaries(), getAuthor(), getCategory(), getLoans());
    }
}
