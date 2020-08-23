package com.wellsfargo.fsd.lms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.lms.entity.Loan;
import com.wellsfargo.fsd.lms.exceptions.LoanException;

public class LoanDAOJDBCImpl implements LoanDAO {

	private static final String INS_LN_QRY = "INSERT into loans(loanId,p,r,emis,dob,status) values (?,?,?,?,?,?)";
	private static final String UPD_LN_QRY = "UPDATE loans SET p=?,r=?,emis=?,dob=?,status=? where loanId=? ";
	private static final String DEL_LN_QRY = "DELETE from loans where loanId=? ";
	private static final String GET_BY_ID_LN_QRY = "SELECT loanId,p,r,emis,dob,status FROM loans where loanId=?";
	private static final String GET_ALL_LN_QRY = "SELECT loanId,p,r,emis,dob,status FROM loans";

	public Loan add(Loan loan) throws LoanException {
		if (loan != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_LN_QRY);) {

				pst.setInt(1, loan.getLoanId());
				pst.setDouble(2, loan.getPrincipal());
				pst.setDouble(3, loan.getRateOfInterest());
				pst.setInt(4, loan.getEmiCount());
				pst.setDate(5, Date.valueOf(loan.getDateOfDisbursement()));
				pst.setString(6, loan.getStatus());

				pst.executeUpdate();

			} catch (SQLException exp) {
				throw new LoanException("An error occured in connection, couldnt add");
			}
		}
		return loan;
	}

	public Loan save(Loan loan) throws LoanException {
		if (loan != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_LN_QRY);) {

				pst.setInt(6, loan.getLoanId());
				pst.setDouble(1, loan.getPrincipal());
				pst.setDouble(2, loan.getRateOfInterest());
				pst.setInt(3, loan.getEmiCount());
				pst.setDate(4, Date.valueOf(loan.getDateOfDisbursement()));
				pst.setString(5, loan.getStatus());

				pst.executeUpdate();

			} catch (SQLException exp) {
				throw new LoanException("An error occured in connection, couldnt save");
			}
		}
		return loan;
	}

	public boolean deleteByID(int loanId) throws LoanException {
		boolean isDeleted = false;

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_LN_QRY);) {

			pst.setInt(1, loanId);

			int rowsCount = pst.executeUpdate();
			isDeleted = rowsCount > 0;

		} catch (SQLException exp) {
			throw new LoanException("An error occured in connection, couldnt delete");
		}

		return isDeleted;
	}

	public List<Loan> getAll() throws LoanException {

		List<Loan> loans = new ArrayList<>();
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_ALL_LN_QRY);) {

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Loan loan = new Loan();
				loan.setLoanId(rs.getInt(1));
				loan.setPrincipal(rs.getDouble(2));
				loan.setRateOfInterest(rs.getDouble(3));
				loan.setEmiCount(rs.getInt(4));
				Date d = rs.getDate(5);
				loan.setDateOfDisbursement(d==null?null:d.toLocalDate());
				loan.setStatus(rs.getString(6));

				loans.add(loan);
			}

		} catch (SQLException exp) {
			throw new LoanException("An error occured in connection, couldnt getall loan");
		}

		return loans;
	}

	public Loan getId(int loanId) throws LoanException {
		Loan loan = null;

		
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(GET_BY_ID_LN_QRY);) {

			pst.setInt(1, loanId);

			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				loan = new Loan();
				loan.setLoanId(rs.getInt(1));
				loan.setPrincipal(rs.getDouble(2));
				loan.setRateOfInterest(rs.getDouble(3));
				loan.setEmiCount(rs.getInt(4));
				Date d = rs.getDate(5);
				loan.setDateOfDisbursement(d==null?null:d.toLocalDate());
				loan.setStatus(rs.getString(6));

			}

		} catch (SQLException exp) {
			throw new LoanException("An error occured in connection, couldnt  loan by id");
		}

		return loan;
	}

}
