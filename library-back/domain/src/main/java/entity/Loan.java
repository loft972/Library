package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "LOAN")
// on indique comment est créé la clé primaire composé
@AssociationOverride(name = "pk.book", joinColumns = @JoinColumn(name = "BOOK_ID"))
@AssociationOverride(name = "pk.customer", joinColumns = @JoinColumn(name = "CUSTOMER_ID"))
public class Loan {

    private LoanId pk;
    private LocalDate beginDate;
    private LocalDate endDate;
    private LoanStatus status;

    @EmbeddedId //La clé composé est intégré depuis l'objet LoanId
    public LoanId getPk() {
        return pk;
    }

    public void setPk(LoanId pk) {
        this.pk = pk;
    }

    @Column(name = "BEGIN_DATE", nullable = false)
    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    @Column(name = "END_DATE", nullable = false)
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Loan loan)) return false;
        return Objects.equals(getPk(), loan.getPk()) && Objects.equals(getBeginDate(), loan.getBeginDate()) && Objects.equals(getEndDate(), loan.getEndDate()) && getStatus() == loan.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk(), getBeginDate(), getEndDate(), getStatus());
    }

    @Override
    public String toString() {
        return "Loan{" +
                "pk=" + pk +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }
}
