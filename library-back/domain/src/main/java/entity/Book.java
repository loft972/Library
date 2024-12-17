package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private int totalExamplaries;
    private LocalDate creationDate;
    private Category category;
    private List<Loan> loans;

    @Column(name = "BOOK_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ISBN")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "TOTAL_EXAMPLARIES")
    public int getTotalExamplaries() {
        return totalExamplaries;
    }

    public void setTotalExamplaries(int totalExamplaries) {
        this.totalExamplaries = totalExamplaries;
    }

    @Column(name = "RELEASE_DATE")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
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
        return getTotalExamplaries() == book.getTotalExamplaries() && Objects.equals(getId(), book.getId()) && Objects.equals(getIsbn(), book.getIsbn()) && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getCreationDate(), book.getCreationDate()) && Objects.equals(getCategory(), book.getCategory()) && Objects.equals(getLoans(), book.getLoans());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getIsbn(), getTitle(), getAuthor(), getTotalExamplaries(), getCreationDate(), getCategory(), getLoans());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", totalExamplaries=" + totalExamplaries +
                ", creationDate=" + creationDate +
                ", category=" + category +
                ", loans=" + loans +
                '}';
    }
}
