package com.maloc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maloc.entity.Type_operateur;

@Repository
public interface ITypeOperateurRepository extends JpaRepository<Type_operateur, Serializable>{

}
