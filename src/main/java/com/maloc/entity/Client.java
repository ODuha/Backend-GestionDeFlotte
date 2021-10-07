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
@Table(name="CLIENT")
public class Client  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="cine")
	private String cine;
	@Column(name="rc")
	private String rc;
	@Column(name="nom_societe")
	private String nom_societe;
	@Column(name="tel")
	private String tel;
	@Column(name="email")
	private String email;
	@Column(name="id_maloc")
	private long id_maloc;
	@OneToMany(mappedBy = "client")	
	private List<Compte> comptes;
	@Column(name="adresse")
	private String adresse;
	@Column(name="verifie",columnDefinition = "tinyint(1) default 0")
	private byte verifie;
	@Column(name="actif" ,columnDefinition = "tinyint(1) default 1")
	private byte actif;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_typeclient")
	private Type_client typeclient;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(long id, String nom, String prenom, String cine, String rc,
			String nom_societe, String tel, String email, long id_maloc,
			List<Compte> comptes, String adresse, byte verifie, byte actif,
			Type_client typeclient) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cine = cine;
		this.rc = rc;
		this.nom_societe = nom_societe;
		this.tel = tel;
		this.email = email;
		this.id_maloc = id_maloc;
		this.comptes = comptes;
		this.adresse = adresse;
		this.verifie = verifie;
		this.actif = actif;
		this.typeclient = typeclient;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCine() {
		return cine;
	}
	public void setCine(String cine) {
		this.cine = cine;
	}
	public String getRc() {
		return rc;
	}
	public void setRc(String rc) {
		this.rc = rc;
	}
	public String getNom_societe() {
		return nom_societe;
	}
	public void setNom_societe(String nom_societe) {
		this.nom_societe = nom_societe;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getId_maloc() {
		return id_maloc;
	}
	public void setId_maloc(long id_maloc) {
		this.id_maloc = id_maloc;
	}
	@JsonIgnore
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public byte getVerifie() {
		return verifie;
	}
	public void setVerifie(byte verifie) {
		this.verifie = verifie;
	}
	public byte getActif() {
		return actif;
	}
	public void setActif(byte actif) {
		this.actif = actif;
	}
	public Type_client getTypeclient() {
		return typeclient;
	}
	public void setTypeclient(Type_client typeclient) {
		this.typeclient = typeclient;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	

}
