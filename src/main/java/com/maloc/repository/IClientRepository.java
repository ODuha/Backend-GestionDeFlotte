package com.maloc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maloc.entity.Client;
import com.maloc.entity.User;
@Repository
public interface IClientRepository  extends JpaRepository<Client, Serializable> {

	
	@Query("select c from Client c where c.cine=:x OR c.rc=:x OR c.nom_societe=:x OR c.nom=:x")
	public Client getClient_exist(@Param("x") String param);
}
