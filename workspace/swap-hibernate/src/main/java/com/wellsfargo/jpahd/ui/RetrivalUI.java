package com.wellsfargo.jpahd.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.wellsfargo.jpahd.entity.ContractEmployee;
import com.wellsfargo.jpahd.entity.Employee;
import com.wellsfargo.jpahd.entity.Manager;

public class RetrivalUI {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();
		
		final String eQry = "SELECT e FROM Employee e";
		final String mQry = "SELECT m FROM Manager m";
		final String ceQry = "SELECT e FROM ContractEmployee e";
		
		List<Employee> emps = em.createQuery(eQry, Employee.class).getResultList();
		
		for(Employee e : emps) {
			System.out.println(e.getFirstName());
		}
		
		List<Manager> mgrs = em.createQuery(mQry, Manager.class).getResultList();
		for(Manager m : mgrs) {
			System.out.println(m.getFirstName());
		}
		
		List<ContractEmployee> cemps = em.createQuery(ceQry, ContractEmployee.class).getResultList();
		for(ContractEmployee e : cemps) {
			System.out.println(e.getFirstName());
		}

		/*
		//retrive data on composition...
		List<Object[]> data1 = em.createQuery("SELECT e.firstName,e.address.doorNumber,e.address.city FROM Employee e").getResultList();
		for(Object[] row : data1) {
			System.out.println(row[0] + "\t" +row[1] +"\t"+row[2]);
		}
		System.out.println("---------------------------------------------");

		//retrive data on OneToOne (CROSS JOIN)
		List<Object[]> data2 = em.createQuery("SELECT e.firstName,e.salAccount.bank,e.salAccount.branch FROM Employee e").getResultList();
		for(Object[] row : data2) {
			System.out.println(row[0] + "\t" +row[1] +"\t"+row[2]);
		}
		System.out.println("---------------------------------------------");

		//retrive data on OneToOne (INNER JOIN)
		List<Object[]> data3 = em.createQuery("SELECT e.firstName,b.bank,b.branch FROM Employee e JOIN e.salAccount b").getResultList();
		for(Object[] row : data3) {
			System.out.println(row[0] + "\t" +row[1] +"\t"+row[2]);
		}
		System.out.println("---------------------------------------------");
				
		//retrive Aggregate data 
		List<Object[]> data4 = em.createQuery("SELECT d.deptName,COUNT(e),SUM(e.basic) FROM Department d JOIN d.employees e GROUP BY d.deptName").getResultList();
		for(Object[] row : data4) {
			System.out.println(row[0] + "\t" +row[1] +"\t"+row[2]);
		}
		System.out.println("---------------------------------------------");
		
		*/
		
		em.close();
	}

}
