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
@Table(name="Fournir_dispo")
public class Fournir_dispo implements Serializable {	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public Fournir_dispo() {
		super();
		// TODO Auto-generated constructor stub
	}
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
@Column(name="IDmaloc")
private long Idmaloc;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name ="id_typedispositif")
private Type_dispositif type_dispositif;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name ="id_fournisseur")
private Fournisseur fournisseur;
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
public Fournir_dispo(long id, long qte, long prix, Date date_achat, long idmaloc) {
	super();
	this.id = id;
	this.qte = qte;
	this.prix = prix;
	this.date_achat = date_achat;
	Idmaloc = idmaloc;
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
public long getIdmaloc() {
	return Idmaloc;
}
public void setIdmaloc(long idmaloc) {
	Idmaloc = idmaloc;
}

}
