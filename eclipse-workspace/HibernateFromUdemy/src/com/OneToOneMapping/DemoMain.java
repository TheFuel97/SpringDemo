package com.OneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;

public class DemoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SessionFactory fact = new Configuration().configure().addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		Session ses = fact.openSession();
		
		try {
			Instructor ins = new Instructor("Ravi","Kumar","thakur898@gmail.com");
			
			InstructorDetail insDtl = new InstructorDetail("www.learncodewith/youtube.com","play footballlll!!!");
			//associate object.
			ins.setInsDtls(insDtl);
			
			ses.beginTransaction();
			
			System.out.println("Saving Instructor..."+ins);
			//save instructor.Note: it will also save the instructor details becasuse of CascadeType.ALL
			ses.save(ins);
			
			
			ses.getTransaction().commit();
			System.out.println("Done!!");
			
			//Demo of Bi Directional mapping.start...
//			int id=2;
//			InstructorDetail dtls = ses.get(InstructorDetail.class, id);
//			System.out.println(dtls.getInstructor());
			//End...
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			ses.close();
			fact.close();
		}

	}

}
