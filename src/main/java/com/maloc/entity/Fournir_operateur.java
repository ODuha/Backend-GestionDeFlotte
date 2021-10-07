package com.maloc.entity;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name="Fournir_operateur")
public class Fournir_operateur implements Serializable { 

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="qte")
	private long qte;
	@Column(name="prix")
	private long prix;
	@Column(name="date_achat")
	private Date date_achat;
	@Column(name="id_maloc")
	private long id_maloc;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="id_typeoperateur")
	private Type_operateur type_operateur;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="id_fournisseur")
	private Fournisseur fournisseurs;
	@OneToMany(mappedBy = "importation")	
	private List<Sim> sims ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getQte() {
		return qte;
	}
	public void setQte(long qte) {
		this.qte = qte;
	}
	public long getPrix() {
		return prix;
	}
	public void setPrix(long prix) {
		this.prix = prix;
	}
	public Date getDate_achat() {
		return date_achat;
	}
	public void setDate_achat(Date date_achat) {
		this.date_achat = date_achat;
	}
	public long getId_maloc() {
		return id_maloc;
	}
	public void setId_maloc(long id_maloc) {
		this.id_maloc = id_maloc;
	}
	public Type_operateur getType_operateur() {
		return type_operateur;
	}
	public void setType_operateur(Type_operateur type_operateur) {
		this.type_operateur = type_operateur;
	}
	public Fournisseur getFournisseurs() {
		return fournisseurs;
	}
	public void setFournisseurs(Fournisseur fournisseurs) {
		this.fournisseurs = fournisseurs;
	}
	@JsonIgnore
	public List<Sim> getSims() {
		return sims;
	}
	public void setSims(List<Sim> sims) {
		this.sims = sims;
	}
	
}
