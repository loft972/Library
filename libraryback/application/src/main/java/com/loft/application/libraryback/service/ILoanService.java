package com.loft.application.libraryback.service;

import com.loft.domain.libraryback.entity.Loan;
import com.loft.domain.libraryback.entity.LoanStatus;
import com.loft.domain.libraryback.entity.SimpleLoanDto;

import java.time.LocalDate;
import java.util.List;

public interface ILoanService {

    public List<Loan> findAllLoansByEndDateBefore(LocalDate maxEndDate);
    public List<Loan> getAllOpenLoansOfThisCustomer(String email, LoanStatus status);
    public Loan getOpenedLoan(SimpleLoanDto simpleLoanDto);
    public boolean checkIfLoanExists(SimpleLoanDto simpleLoanDto);
    public Loan saveLoan(Loan loan);
    public void closeLoan(Loan loan);
}
