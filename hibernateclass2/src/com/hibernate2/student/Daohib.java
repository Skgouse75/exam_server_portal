package com.hibernate2.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Daohib {
	public void insert() {
		Configuration con=new Configuration();
		con.configure();
		SessionFactory sf=con.buildSessionFactory();
		Session s=sf.openSession();
		org.hibernate.Transaction t=s.beginTransaction();
		Stdpojo std= new Stdpojo();
		std.setId(1);
		std.setName("ram");
		std.setAge(22);
		std.setMarks(88);
		s.save(std);
		t.commit();
		s.close();
		
	}

}
