package com.maloc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Protocol implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Protocol() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Protocol(String name, long id_maloc, String decoder) {
		super();
		this.name = name;
		this.id_maloc = id_maloc;
		this.decoder = decoder;
	}


	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="id_maloc", nullable = true)
	private long id_maloc;
	
	@OneToMany(mappedBy = "protocol")	
	private List<Type_boitier> type_boitiers;
	

	@Column(name="decoder")
	private String decoder;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getIdmaloc() {
		return id_maloc;
	}


	public void setIdmaloc(long id_maloc) {
		this.id_maloc = id_maloc;
	}


	@JsonIgnore // ignorer la liste lors du select de la liste des protocoles 
	public List<Type_boitier> getTypes_boitier() {
		return type_boitiers;
	}


	public void setTypes_boitier(List<Type_boitier> types_boitier) {
		this.type_boitiers = types_boitier;
	}


	public String getDecoder() {
		return decoder;
	}


	public void setDecoder(String decoder) {
		this.decoder = decoder;
	}
	
}
