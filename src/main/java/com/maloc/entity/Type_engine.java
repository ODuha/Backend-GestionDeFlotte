package com.maloc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="TYPE_ENGINE")
public class Type_engine implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public Type_engine(long id, String type, long id_maloc) {
	super();
	this.id = id;
	this.type = type;
	this.id_maloc = id_maloc;
}
public Type_engine() {
	super();
	// TODO Auto-generated constructor stub
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public long getId_maloc() {
	return id_maloc;
}
public void setId_maloc(long id_maloc) {
	id_maloc = id_maloc;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="TYPE")
	private String type;
	@Column(name="id_maloc")
	private long id_maloc;
	@OneToMany(mappedBy = "typeengine")	
	private List<Engine> Engines;
	public List<Engine> getEngines() {
		return Engines;
	}
	@JsonIgnore
	public void setEngines(List<Engine> engines) {
		Engines = engines;
	}

}
