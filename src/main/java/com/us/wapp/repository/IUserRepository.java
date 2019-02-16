package com.us.wapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.us.wapp.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	@Query("select count(e)>0 from User e where e.email=:email")
	boolean existByEmail(@Param("email") String email);
	
	@Query("select u from User u where u.email=:email AND u.password=:password")
	User loginUser(@Param("email") String email, @Param("password") String password);
	
	@Query("select e from User e where e.email=:email")
	User findByEmail(@Param("email") String email);
	
}
