package com.maloc.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maloc.entity.Compte;
import com.maloc.entity.User;
@Repository
public interface ICompteRepository  extends JpaRepository<Compte, Serializable> {

	@Query("select c from Compte c where c.client.id=id_client")
	public List<Compte> getComptes_byClient(@Param("id_client") long id);
	
	@Query("select c from Compte c where c.login=:login")
	public Compte getCompte_exist(@Param("login") String login);
}
