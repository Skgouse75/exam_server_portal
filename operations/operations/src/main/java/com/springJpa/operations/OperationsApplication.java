package com.springJpa.operations;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springJpa.operations.Dao.UserRepository;
import com.springJpa.operations.entity.User;

@SpringBootApplication
public class OperationsApplication {

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(OperationsApplication.class, args);
	
	UserRepository userrepository=context.getBean(UserRepository.class);
	
	/*User user=new User();
	user.setName("hh");
	user.setCit("guntur");
	user.setStatus("user1");
	
	User user1=userrepository.save(user);
	System.out.println(user1);*/
	 List<User> alluser=  userrepository.getAllUser();
	 alluser.forEach(e->{
		 
	 System.out.println(e);
	 });
     
	 
	 System.out.println("--------------------");
 List<User>userbyname=userrepository.getUserByName("hh","guntur"); 
   userbyname.forEach(e->{
   System.out.println(e);
   });
	
   
   System.out.println("++++++++++++++++");
   userrepository.getuser().forEach(e->{System.out.println(e);});
   
   
   
   
   
   
   
   
	}
}
