package com.wellsfargo.fsd.lms.dao;

import java.util.List;

import com.wellsfargo.fsd.lms.entity.Loan;
import com.wellsfargo.fsd.lms.exceptions.LoanException;

public interface LoanDAO {

	Loan add(Loan loan) throws LoanException;
	Loan save(Loan loan)throws LoanException;
	boolean deleteByID(int loanId)throws LoanException;
	
	List<Loan> getAll()throws LoanException;
	Loan getId(int loanId)throws LoanException;
	
}
