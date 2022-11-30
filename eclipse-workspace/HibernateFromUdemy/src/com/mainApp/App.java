package com.mainApp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class App {

	public static void main(String[] args) {
		
		//Create session factory.
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session.
		Session ses = factory.openSession();
		
		try {
			//create student obhect.
			System.out.println("Creating new studnet object");
			Student st = new Student(361,"John","Paul","Paul44@gmail.com");
			
			//start transaction.
			ses.beginTransaction();
			//save student .
			ses.save(st);
			//commit transaction.
		   ses.getTransaction().commit();
//			
			//Retriving object using HQL and Update student using both query and setter method.Start....
//			List<Student> s = ses.createQuery("from Student").getResultList();
			//List<Student> s = ses.createQuery("from Student s where"+" s.lastName='Takur' OR s.firstName='John' AND s.email LIKE '%gmail.com'")
//					.getResultList();
		   //Updating using query ...
//			//ses.createQuery("update Student s set s.email='ravikumar97@gmail.com' where s.firstName='Ravi'").executeUpdate();
		   //Updating using student object...
//			Student ss = ses.get(Student.class, 12);
//			ss.setLastName("Kumar");
//			ses.getTransaction().commit();
//			System.out.println(ss);
			//END...
			//Retrieve student object from db.Start..
//			System.out.println(st.getId()+" is new id...");
//			Session ss = factory.openSession();
//			ss.beginTransaction();
//			Student stud = ss.get(Student.class, st.getId());
//			System.out.println("Student is:: "+stud);
			//ss.getTransaction().commit();
			//End....
			//Delete Student object data by both ways[HQL and stu object].Start..
			
			//Student str = ses.get(Student.class, 36);
			//ses.delete(str);
		
			int i = ses.createQuery("delete from Student where id=361").executeUpdate();
			System.out.println("Deleted ... "+i);
			ses.getTransaction().commit();
			//END..
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		finally {
			ses.close();
			factory.close();
		}
		
		
		
	}

}
