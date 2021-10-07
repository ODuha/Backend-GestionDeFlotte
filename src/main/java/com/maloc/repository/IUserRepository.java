package com.maloc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maloc.entity.User;
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	
	@Query("select u from User u where u.login=:x and u.password=:y and u.active=true")
	public User login(@Param("x") String login,@Param("y") String password);
	

}
