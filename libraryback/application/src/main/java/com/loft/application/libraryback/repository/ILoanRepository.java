package com.loft.application.libraryback.repository;

import com.loft.domain.libraryback.entity.Loan;
import com.loft.domain.libraryback.entity.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ILoanRepository extends JpaRepository<Loan, Integer> {

    public List<Loan> findByEndDateBefore(LocalDate maxEndDate);

        @Query("SELECT lo"
        + "FROM Loan lo "
        + "INNE JOIN lo.pk.customer c"
        + "WHERE UPPER(c.email) = UPPER(?1) "
        + " AND lo.status = ?2")
    public List<Loan> getAllOpenLoansOfThisCustomer(String email, LoanStatus status);


        @Query("SELECT lo "
        + "FROM LOAN lo "
        + "INNER JOIN lo.pk.book b "
        + "INNER JOIN lo.pk.customer c "
        + "WHERE b.id = ?1"
        + "AND c.id = ?2"
        + "AND lo.status = ?3 ")
    public Loan getLoanByCriteria(Integer bookId, Integer CustomerId, LoanStatus status);
}
