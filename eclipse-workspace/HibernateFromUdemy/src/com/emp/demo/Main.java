package com.emp.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory fact = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session ses = fact.openSession();
		//Save data in employee table.Start...
//		Employee emp = new Employee(913007,"Akhil Kumar","Shandilya","Cognizant");
//		Transaction tx = ses.beginTransaction();
//		ses.save(emp);
//		System.out.println("Employee is saved...");
//		tx.commit();
		
		//End...
		//Fetch data from employee table.Start....
		Transaction tx1 = ses.beginTransaction();
		Employee ee = ses.get(Employee.class, 1);
		System.out.println("Fetched emp is.. "+ee);
		tx1.commit();
		ses.close();
		fact.close();

	}

}
