package com.maloc.entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="Fournir_boitier")
public class Fournir_boitier implements Serializable
{ /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_fournisseur")
	private Fournisseur fournisseur;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_boitier")
	private Type_boitier type_boitier;
	public Fournir_boitier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fournir_boitier(long id, long qte, long prix, Date date_achat, long id_maloc, Fournisseur fournisseur,
			Type_boitier type_boitier) {
		super();
		this.id = id;
		this.qte = qte;
		this.prix = prix;
		this.date_achat = date_achat;
		this.id_maloc = id_maloc;
		this.fournisseur = fournisseur;
		this.type_boitier = type_boitier;
	}
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
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Type_boitier getType_boitier() {
		return type_boitier;
	}
	public void setType_boitier(Type_boitier type_boitier) {
		this.type_boitier = type_boitier;
	}
	
	

}
