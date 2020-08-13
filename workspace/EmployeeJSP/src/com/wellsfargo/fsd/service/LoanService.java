package com.wellsfargo.fsd.service;

import com.wellsfargo.fsd.Model.Loan;

public class LoanService {

	public void computeEmi(Loan loan) {
		loan.setEmi(loan.getPrinciple() *loan.getEmiCount());
	}
}
