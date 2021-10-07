package com.maloc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maloc.entity.Sim;


public interface ISimRepository extends JpaRepository<Sim, Serializable> {

}
