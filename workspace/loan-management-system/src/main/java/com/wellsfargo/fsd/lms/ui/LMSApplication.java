package com.wellsfargo.fsd.lms.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.wellsfargo.fsd.lms.entity.Loan;
import com.wellsfargo.fsd.lms.exceptions.LoanException;
import com.wellsfargo.fsd.lms.service.LoanService;
import com.wellsfargo.fsd.lms.service.LoanServiceImpl;

public class LMSApplication {

	public static final Scanner scanner = new Scanner(System.in);
	public static final LoanService loanService = new LoanServiceImpl();

	public static void main(String[] args) {

		Menu[] menus = Menu.values();
		
		Menu menuSelected = null;
		
		while(menuSelected!= Menu.QUIT) {
			
			System.out.println("Please select operation: ");
			
			for(Menu m: menus) {
				System.out.println(m.ordinal() + "\t" +m);
			}
			System.out.println("Choices> ");
			int ch = scanner.nextInt();
			
			
			if(ch>=0 && ch < menus.length) {
				
				menuSelected = menus[ch];
				
				switch(menuSelected) {
				case ADD: doAdd(); break;
				case FIND: doFind();break;
				case LIST: doList();break;
				case DELETE: doDelete();break;
				}
				
			}
			else {
				System.out.println("Unkonown choice");
				menuSelected=null;
			}
		}
		
		scanner.close();
		System.out.println("APPLICATION TERMINATED");
	}

	private static void doAdd() {
		
		Loan loan = new Loan();
		
		System.out.println("LoanId > ");
		loan.setLoanId(scanner.nextInt());
		
		System.out.println("principal > ");
		loan.setPrincipal(scanner.nextDouble());
		
		System.out.println("ROI > ");
		loan.setRateOfInterest(scanner.nextDouble());
		
		System.out.println("emi count > ");
		loan.setEmiCount(scanner.nextInt());
		
		System.out.println("status > ");
		loan.setStatus(scanner.next());
		
		System.out.println("Disbursement date (yyyy-mm-dd)> ");
		loan.setDateOfDisbursement(LocalDate.parse(scanner.next()));
		
		
		try {
			
			loanService.validateAndAdd(loan);
				System.out.println("Loan is Added");
			
		} catch (LoanException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void doFind() {
		System.out.println("LoanId > ");
		int loanID = scanner.nextInt();

		Loan loan;
		try {
			loan = loanService.getLoan(loanID);
			if(loan == null) {
				System.out.println("No such record found");
			}
			else {
				System.out.println(loan);
			}
		} catch (LoanException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	private static void doDelete() {
		
		System.out.println("LoanId > ");
		int loanID = scanner.nextInt();

		
		try {
			boolean isDeleted = loanService.deleteLoan(loanID);
			if(!isDeleted) {
				System.out.println("No such record found");
			}
			else {
				System.out.println("Loan is deleted");
			}
		} catch (LoanException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void doList() {

		try {
			List<Loan>  loans= loanService.getAllLoan();
			if(loans == null) {
				System.out.println("No such record found");
			}
			else {
				for(Loan l: loans) {
				System.out.println(l);
				}
			}
		} catch (LoanException e) {
			System.out.println(e.getMessage());
		}
	}

}
