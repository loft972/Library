package entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    private Integer id;
    private String lastName;
    private String firstName;
    private String job;
    private String adresse;
    private String email;
    private String creationDate;
    private List<Loan> loans;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "LAST_NAME", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "FIRST_NAME", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "JOB", nullable = false)
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Column(name = "ADDRESS", nullable = false)
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Column(name = "EMAIL", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "CREATION_DATE", nullable = false)
    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.customer", cascade = CascadeType.ALL)
    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(getId(), customer.getId()) && Objects.equals(getLastName(), customer.getLastName()) && Objects.equals(getFirstName(), customer.getFirstName()) && Objects.equals(getJob(), customer.getJob()) && Objects.equals(getAdresse(), customer.getAdresse()) && Objects.equals(getEmail(), customer.getEmail()) && Objects.equals(getCreationDate(), customer.getCreationDate()) && Objects.equals(getLoans(), customer.getLoans());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLastName(), getFirstName(), getJob(), getAdresse(), getEmail(), getCreationDate(), getLoans());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", job='" + job + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", loans=" + loans +
                '}';
    }
}
