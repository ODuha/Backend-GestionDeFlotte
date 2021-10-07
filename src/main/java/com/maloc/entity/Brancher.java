package com.maloc.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="BRANCHER")
public class Brancher implements Serializable {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="date_installation")
	private Date date_installation;
	@Column(name="date_echeance")
	private Date date_echeance;
	@Column(name="date_retir",nullable=true)
	private Date date_retir;
	@Column(name="id_maloc")
	private long id_maloc;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_boitier")
	private Boitier boitier;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_engine",nullable=true)
	private Engine engine;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_compte",nullable=true)
	private Compte compte;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_sim")
	private Sim sim;
	public Brancher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Brancher(long id, Date date_installation, Date date_echeance, Date date_retir, long id_maloc, Boitier boitier,
			Engine engine, Compte compte, Sim sim) {
		super();
		this.id = id;
		this.date_installation = date_installation;
		this.date_echeance = date_echeance;
		this.date_retir = date_retir;
		this.id_maloc = id_maloc;
		this.boitier = boitier;
		this.engine = engine;
		this.compte = compte;
		this.sim = sim;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	

	public Date getDate_installation() {
		return date_installation;
	}
	public void setDate_installation(Date date_installation) {
		this.date_installation = date_installation;
	}
	public Date getDate_echeance() {
		return date_echeance;
	}
	public void setDate_echeance(Date date_echeance) {
		this.date_echeance = date_echeance;
	}
	public Date getDate_retir() {
		return date_retir;
	}
	public void setDate_retir(Date date_retir) {
		this.date_retir = date_retir;
	}
	public long getId_maloc() {
		return id_maloc;
	}
	public void setId_maloc(long id_maloc) {
		this.id_maloc = id_maloc;
	}
	public Boitier getBoitier() {
		return boitier;
	}
	public void setBoitier(Boitier boitier) {
		this.boitier = boitier;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Sim getSim() {
		return sim;
	}
	public void setSim(Sim sim) {
		this.sim = sim;
	}
	
	

}
