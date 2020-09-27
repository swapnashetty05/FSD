package com.wellsfargo.fsd.coronakit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.coronakit.dao.LoanDao;
import com.wellsfargo.fsd.coronakit.entity.Loan;
import com.wellsfargo.fsd.coronakit.exception.LoanException;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanDao loanRepo;
	
	@Override
	@Transactional
	public Loan add(Loan loan) throws LoanException {
		if(loan!=null) {
			if(loanRepo.existsById(loan.getLoanId())) {
				throw new LoanException("Loan Id already used!");
			}
			
			loanRepo.save(loan);
		}
		return loan;
	}

	@Override
	public Loan save(Loan loan) throws LoanException {
		if(loan!=null) {
			if(!loanRepo.existsById(loan.getLoanId())) {
				throw new LoanException("Loan Not Found");
			}
			
			loanRepo.save(loan);
		}
		return loan;
	}

	@Override
	@Transactional
	public boolean deleteLoan(int loanId) throws LoanException {
		if(!loanRepo.existsById(loanId)) {
			throw new LoanException("Loan Not Found");
		}
		
		loanRepo.deleteById(loanId);
		return true;
	}

	@Override
	public Loan getLoan(int loanId) {
		return loanRepo.findById(loanId).orElse(null);
	}

	@Override
	public List<Loan> getAllLoans() {
		return loanRepo.findAll();
	}
	
	@Override
	public List<Loan> getAllLoans(String status) {
		if (status != null) {
            return loanRepo.findAllByStatus(status);
        }
        return loanRepo.findAll();
	}
}

