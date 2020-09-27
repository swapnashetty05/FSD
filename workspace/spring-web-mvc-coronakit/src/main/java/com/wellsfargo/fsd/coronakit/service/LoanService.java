package com.wellsfargo.fsd.coronakit.service;

import java.util.List;
import com.wellsfargo.fsd.coronakit.entity.Loan;
import com.wellsfargo.fsd.coronakit.exception.LoanException;

public interface LoanService {
	Loan add(Loan loan) throws LoanException;

	Loan save(Loan loan) throws LoanException;

	boolean deleteLoan(int loanId) throws LoanException;

	Loan getLoan(int loanId);

	List<Loan> getAllLoans();
	
	List<Loan> getAllLoans(String status);
}
