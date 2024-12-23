package com.loft.application.libraryback.service;

import com.loft.application.libraryback.repository.ILoanRepository;
import com.loft.domain.libraryback.entity.Loan;
import com.loft.domain.libraryback.entity.LoanStatus;
import com.loft.domain.libraryback.entity.SimpleLoanDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service("loanService")
@Transactional
public class LoanServiceImpl implements ILoanService{

    private final ILoanRepository loanRepository;

    public LoanServiceImpl(ILoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public List<Loan> findAllLoansByEndDateBefore(LocalDate maxEndDate) {
        return loanRepository.findByEndDateBefore(maxEndDate);
    }

    @Override
    public List<Loan> getAllOpenLoansOfThisCustomer(String email, LoanStatus status) {
        return loanRepository.getAllOpenLoansOfThisCustomer(email, status);
    }

    @Override
    public Loan getOpenedLoan(SimpleLoanDto simpleLoanDto) {
        return loanRepository.getLoanByCriteria(simpleLoanDto.getBookId(), simpleLoanDto.getCustomerId(), LoanStatus.OPEN);
    }

    @Override
    public boolean checkIfLoanExists(SimpleLoanDto simpleLoanDto) {
        Loan loan = loanRepository.getLoanByCriteria(simpleLoanDto.getBookId(), simpleLoanDto.getCustomerId(), LoanStatus.OPEN);
        if(loan != null){
            return true;
        }
        return false;
    }

    @Override
    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    /**
     * On fera de la suppression logique, car le statut de l'objet Loan est positionné à CLOSE
     * @param loan
     */
    @Override
    public void closeLoan(Loan loan) {
        loanRepository.save(loan);
    }
}
