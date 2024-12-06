package com.loft.library.loan;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "LOAN")
@AssociationOverrides({
        @AssociationOverride(name = "pk.book", joinColumns = @JoinColumn(name = "BOOK_ID")),
        @AssociationOverride(name = "pk.customer", joinColumns = @JoinColumn(name = "CUSTOMER_ID"))
})
public class Loan implements Serializable {

    private static final long serialVersionUID = 144293603488149743L;
    private LoanId pk = new LoanId();
    private LocalDate beginDate;
    private LocalDate endDate;
    private LoanStatus status;

    // gestion de clef primaire composé et de migration de clef étrangère
    @EmbeddedId
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
        if (this == o) return true;
        if (!(o instanceof Loan loan)) return false;
        return Objects.equals(getPk(), loan.getPk()) && Objects.equals(getBeginDate(), loan.getBeginDate()) && Objects.equals(getEndDate(), loan.getEndDate()) && getStatus() == loan.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk(), getBeginDate(), getEndDate(), getStatus());
    }
}
