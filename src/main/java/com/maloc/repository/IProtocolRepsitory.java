package com.maloc.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maloc.entity.Protocol;
@Repository
public interface IProtocolRepsitory extends JpaRepository<Protocol, Serializable> {


	@Query("select p from Protocol p")
	public 	Page<Protocol> getProtocol_table(Pageable P);
}
