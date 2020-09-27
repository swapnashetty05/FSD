package com.wellsfargo.fsd.lms.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.lms.entity.Loan;

@Repository
public interface LoanDao extends JpaRepository<Loan, Integer> {
	 @Query("SELECT l FROM Loan l WHERE l.status=?1") 
	List<Loan> findAllByStatus(String status);

	@Query("SELECt l FROM Loan l WHERE l.dateOfDisbursment BETWEEN :start and :end")
	List<Loan> findAllHavingDOBInRange(@DateTimeFormat(iso = ISO.DATE) LocalDate start,
			@DateTimeFormat(iso = ISO.DATE) LocalDate end);
}
