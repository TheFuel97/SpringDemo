package com.OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class DeleteDemoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SessionFactory fact = new Configuration().configure().addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session ses = fact.openSession();
		
		try {
			
			ses.beginTransaction();
			
			int id = 2;
			InstructorDetail ins = ses.get(InstructorDetail.class, id);
			System.out.println("found instructor: "+ins);
			if(ins!=null) {
				System.out.println("Deleting ....");
				//NOte: It will delete data from both instructor and instructor_detail table because of
				//CascadeType.ALL
				//ins.getInstructor().setInsDtls(null);
				ses.delete(ins);
			}
			
			
			ses.getTransaction().commit();
			System.out.println("Done!!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
