package com.maloc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maloc.entity.Session;
import com.maloc.entity.User;
@Repository
public interface ISessionRepository extends JpaRepository<Session, Serializable> {

	@Query("select s from Session s where s.user.id=:x and s.key=:y")
	public Session session_ofconnecteduser(@Param("x") Long id,@Param("y") int key);
	
	@Query("select s.user from Session s where s.key=:y")
	public User getUser_byApiKey(@Param("y") int key);
	
	
}
