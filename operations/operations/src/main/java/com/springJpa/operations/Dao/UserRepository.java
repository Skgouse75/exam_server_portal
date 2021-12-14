package com.springJpa.operations.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springJpa.operations.entity.User;

public interface UserRepository extends CrudRepository<User,Integer>{

	public List<User>findByName(String name);
	
	public List<User>findByNameAndCit(String name,String cit);
	
	@Query("select u FROM User u")
    public List<User>getAllUser();
	
	 @Query("select u FROM User u WHERE u.name=:n and u.cit=:c")
	 List<User>getUserByName(@Param("n")String name , @Param("c")String cit);
	
	 
	 //native query
	 @Query(value="select * from User",nativeQuery=true)
	 List<User>getuser();
	 
	
}
