package com.maloc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maloc.entity.Brancher;

public interface IBrancherRepository extends JpaRepository<Brancher, Serializable>  {

}
