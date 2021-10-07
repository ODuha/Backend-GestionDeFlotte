package com.maloc.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="SIM")

public class Sim  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="NSeriesSIM")
	private long NSeriesSIM;
	@Column(name="tel")
	private String tel;
	@Column(name="etat")
	private String etat;
	@Column(name="teste")
	private byte test;
	@Column(name="panne")
	private byte panne;
	@Column(name="proprietaire")
	private String proprietaire;
	@Column(name="pin")
	private long pin;
	@Column(name="puk")
	private long puk;
	@Column(name="volumdata")
	private long volumdata;
	@Column(name="date_activation")
	private Date date_activation;
	@Column(name="id_maloc")
	private long id_maloc;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_operateur")
	private Type_operateur type_operateur;
	@OneToMany(mappedBy = "sim")	
	private List<Brancher> branche;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_importation")
	private Fournir_operateur importation;
	public Sim() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sim(long id, long nSeriesSIM, String tel, String etat, byte test, byte panne, String proprietaire,
			long pin, long puk, long volumdata, Date date_activation, long id_maloc, Type_operateur type_operateur,
			List<Brancher> branche, Fournir_operateur importation) {
		super();
		this.id = id;
		NSeriesSIM = nSeriesSIM;
		this.tel = tel;
		this.etat = etat;
		this.test = test;
		this.panne = panne;
		this.proprietaire = proprietaire;
		this.pin = pin;
		this.puk = puk;
		this.volumdata = volumdata;
		this.date_activation = date_activation;
		this.id_maloc = id_maloc;
		this.type_operateur = type_operateur;
		this.branche = branche;
		this.importation = importation;
	}
	public Date getDate_activation() {
		return date_activation;
	}
	public void setDate_activation(Date date_activation) {
		this.date_activation = date_activation;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNSeriesSIM() {
		return NSeriesSIM;
	}
	public void setNSeriesSIM(long nSeriesSIM) {
		NSeriesSIM = nSeriesSIM;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
    
	public byte getTest() {
		return test;
	}
	public void setTest(byte test) {
		this.test = test;
	}
	public byte getPanne() {
		return panne;
	}
	public void setPanne(byte panne) {
		this.panne = panne;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}
	public long getPin() {
		return pin;
	}
	public void setPin(long pin) {
		this.pin = pin;
	}
	public long getPuk() {
		return puk;
	}
	public void setPuk(long puk) {
		this.puk = puk;
	}
	public long getVolumdata() {
		return volumdata;
	}
	public void setVolumdata(long volumdata) {
		this.volumdata = volumdata;
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
	@JsonIgnore
	public List<Brancher> getBranche() {
		return branche;
	}
	public void setBranche(List<Brancher> branche) {
		this.branche = branche;
	}
	public Fournir_operateur getImportation() {
		return importation;
	}
	public void setImportation(Fournir_operateur importation) {
		this.importation = importation;
	}
	

	
	
	
	
	
	

}
