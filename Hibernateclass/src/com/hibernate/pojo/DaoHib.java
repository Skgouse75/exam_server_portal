package com.hibernate.pojo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DaoHib {
	
	/*public void insert() {
		Configuration con=new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf=con.buildSessionFactory();
		Session s=sf.openSession();
		org.hibernate.Transaction t=s.beginTransaction();
		Emppojo h=new Emppojo();
		h.setAge(28);
		h.setEid(4);
		h.setName("som");
		s.save(h);
		t.commit();
		s.close();
	}
}*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////	

/*public void update(){
	
	Configuration con=new Configuration();
	con.configure();
	SessionFactory st=con.buildSessionFactory();
	Session s=st.openSession();
	
	Emppojo emp=(Emppojo)s.load(Emppojo.class, 2);
	System.out.println("initial value before");
	System.out.println(emp.getAge());
	System.out.println(emp.getEid());
	System.out.println(emp.getName());
	org.hibernate.Transaction t=s.beginTransaction();
	emp.setAge(22);
	emp.setEid(1);
	emp.setName("ram");
	s.update(emp);
	t.commit();
	s.close();	
}

}*/
/////////////////////////////////////////////////////////////////////////////////////////////////////////

/*public void delete(){
	
	Configuration con=new Configuration();
	con.configure();
	SessionFactory st=con.buildSessionFactory();
	Session s=st.openSession();
	
	Emppojo emp=(Emppojo)s.load(Emppojo.class, 2);
	System.out.println("initial value before");
	System.out.println(emp.getAge());
	System.out.println(emp.getEid());
	System.out.println(emp.getName());
	org.hibernate.Transaction t=s.beginTransaction();
	s.delete(emp);
	t.commit();
	s.close();	
}
}*/
/////////////////////////////////////////////////////////////////////////////////////////////////////	
 public void getAll() {
	 Configuration con=new Configuration ();
	 con.configure();
	 SessionFactory sf=con.buildSessionFactory();
	Session s= sf.openSession();
	//String hqlquery="from Emppojo";
	String hqlquery="select emp.name,emp.age";
	Query q=s.createQuery(hqlquery);
	List<Emppojo>emp=q.list();
	Iterator<Emppojo> k=emp.iterator();
	while(k.hasNext())
	{
		Emppojo e=k.next();
		System.out.println(e.getEid()+"=="+e.getName()+"=="+e.getAge());
	}
	
 }
}

	
	
	
	
	



