package com.maloc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maloc.entity.Type_client;
@Repository
public interface ITypeClientRepository extends JpaRepository<Type_client, Serializable> {

}
