package com.maloc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maloc.entity.Engine;
import com.maloc.entity.Type_engine;

public interface ITypeEngineRepository extends JpaRepository<Type_engine, Serializable>{

}
