package com.maloc.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maloc.entity.Boitier;
import com.maloc.entity.Client;
import com.maloc.entity.Compte;

@Repository
public interface IBoitierRepository extends JpaRepository<Boitier, Serializable>
 {
	
}
