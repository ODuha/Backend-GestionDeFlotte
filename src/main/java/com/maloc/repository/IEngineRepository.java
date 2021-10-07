package com.maloc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maloc.entity.Engine;


public interface IEngineRepository extends JpaRepository<Engine, Serializable> {

}
