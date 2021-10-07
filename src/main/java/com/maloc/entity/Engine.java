package com.maloc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="ENGINE")
public class Engine implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="matricule")
	private String matricule;
	@Column(name="marque")
	private String marque;
	@Column(name="model")
	private String model ;
	@Column(name="numeroChassi")
	private long numeroChassi;
	@Column(name="id_maloc")
	private long id_maloc;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_typeengine")
	private Type_engine typeengine;
	@OneToMany(mappedBy = "engine")	
	private List<Brancher> branches;
	public Engine(long id, String matricule, String marque, String model,
			long numeroChassi, long id_maloc, Type_engine typeengine,
			List<Brancher> branches) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.marque = marque;
		this.model = model;
		this.numeroChassi = numeroChassi;
		this.id_maloc = id_maloc;
		this.typeengine = typeengine;
		this.branches = branches;
	}
	
	public Engine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public long getNumeroChassi() {
		return numeroChassi;
	}
	public void setNumeroChassi(long numeroChassi) {
		this.numeroChassi = numeroChassi;
	}
	public long getId_maloc() {
		return id_maloc;
	}
	public void setIdMaloc(long id_maloc) {
		this.id_maloc = id_maloc;
	}
	public Type_engine getTypeengine() {
		return typeengine;
	}
	public void setTypeengine(Type_engine typeengine) {
		this.typeengine = typeengine;
	}
	@JsonIgnore
	public List<Brancher> getBranches() {
		return branches;
	}
	public void setBranches(List<Brancher> branches) {
		this.branches = branches;
	}
	

}
