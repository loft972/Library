package com.loft.libraryback.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public class Loan {

    private LoanId pk = new LoanId();
    private LocalDate beginDate;
    private LocalDate endDate;
    private LoanStatus loanStatus;

    @EmbeddedId // indique que la clé primaire est clé via l'objet LoanId
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
    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }
}
