package com.maloc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maloc.entity.Type_boitier;
@Repository
public interface ITypeBoitierRepository extends JpaRepository<Type_boitier, Serializable>{

}
