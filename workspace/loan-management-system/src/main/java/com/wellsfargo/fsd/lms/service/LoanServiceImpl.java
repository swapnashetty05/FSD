package com.wellsfargo.fsd.lms.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.lms.dao.LoanDAO;
import com.wellsfargo.fsd.lms.dao.LoanDAOJDBCImpl;
import com.wellsfargo.fsd.lms.entity.Loan;
import com.wellsfargo.fsd.lms.exceptions.LoanException;

public class LoanServiceImpl implements LoanService {

	LoanDAO loanDao;

	public LoanServiceImpl() {
		loanDao = new LoanDAOJDBCImpl();
	}

	private boolean isValidLoan(Loan loan) throws LoanException {
		boolean isValid = true;

		List<String> errMsg = new ArrayList<>();

		if (loan != null) {
			if (!isValidLoanId(loan.getLoanId())) {
				isValid = false;
				errMsg.add("Loan Id must be a positive or non repetative number");
			}
			if (!isValidRateOfInt(loan.getRateOfInterest())) {
				isValid = false;
				errMsg.add("ROI must be a positive or non repetative number");
			}

			if (!isValidPrincipal(loan.getPrincipal())) {
				isValid = false;
				errMsg.add("Principal must be a positive or non repetative number");
			}

			if (!isvalidDOD(loan.getDateOfDisbursement())) {
				isValid = false;
				errMsg.add("DOD must be a past date");
			}

			if (!isvalidStatus(loan.getStatus())) {
				isValid = false;
				errMsg.add("status must be a appropriate");
			}

			if (!isValidEmi(loan.getEmiCount())) {
				isValid = false;
				errMsg.add("emiCount must be a positive or non repetative number");
			}

			if (!errMsg.isEmpty()) {
				throw new LoanException(errMsg.toString());
			}

		} else {
			isValid = false;
		}
		return isValid;
	}

	private boolean isValidLoanId(Integer loanId) {
		return loanId != null && loanId > 0;
	}

	private boolean isValidRateOfInt(Double r) {

		return r != null && (r >= 0 || r <= 1);
	}

	private boolean isValidPrincipal(Double p) {

		return p != null && (p >= 0 || p <= 1);
	}

	private boolean isValidEmi(Integer emi) {
		return emi != null && emi > 0;
	}

	// it should not be past date
	private boolean isvalidDOD(LocalDate dod) {
		return dod == null || !dod.isAfter(LocalDate.now());
	}

	private boolean isvalidStatus(String status) {
		return status != null && (status.length() > 3 && status.length() < 10);
	}

	@Override
	public Loan validateAndAdd(Loan loan) throws LoanException {
		if(isValidLoan(loan)) {
			loanDao.add(loan);
			
		}
		return loan;
	}

	@Override
	public Loan validateAndSave(Loan loan) throws LoanException {
		if(isValidLoan(loan)) {
			loanDao.save(loan);
			
		}
		return loan;
	}

	@Override
	public boolean deleteLoan(int loanId) throws LoanException {
		
		return loanDao.deleteByID(loanId);
	}

	@Override
	public Loan getLoan(int loanId) throws LoanException {
		
		return loanDao.getId(loanId);
	}

	@Override
	public List<Loan> getAllLoan() throws LoanException {
		
		return loanDao.getAll();
	}

}
