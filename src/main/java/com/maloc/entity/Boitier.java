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
@Table(name="BOITIER")
public class Boitier implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID= 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="imei")
	private long imei;
	@Column(name="port")
	private int port;
	@Column(name="version")
	private String version;
	@Column(name="panne")
	private byte panne ;
	@Column(name="teste")
	private byte teste;
	@Column(name="etat")
	private String etat ;
	@Column(name="etatMMA")
	private int etatMMA ;
	@Column(name="configFileUploaded")
	private byte configFileUploaded ;
	@Column(name="observation")
	private String observation ;
	@Column(name="id_maloc")
	private long id_maloc;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_typeboitier")
	private Type_boitier type_boitiers;
	@OneToMany(mappedBy = "boitier")	
	private List<Brancher> branches;
	
	
	
	
	public Boitier(long id, long imei, int port, String version, byte panne, byte teste, String etat, int etatMMA,
			byte configFileUploaded, String observation, long id_maloc, Type_boitier type_boitiers,
			List<Brancher> branches) {
		super();
		this.id = id;
		this.imei = imei;
		this.port = port;
		this.version = version;
		this.panne = panne;
		this.teste = teste;
		this.etat = etat;
		this.etatMMA = etatMMA;
		this.configFileUploaded = configFileUploaded;
		this.observation = observation;
		this.id_maloc = id_maloc;
		this.type_boitiers = type_boitiers;
		this.branches = branches;
	}

	public Boitier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getImei() {
		return imei;
	}

	public void setImei(long imei) {
		this.imei = imei;
	}

	public byte getPanne() {
		return panne;
	}

	public void setPanne(byte panne) {
		this.panne = panne;
	}

	public byte getTeste() {
		return teste;
	}

	public void setTeste(byte teste) {
		this.teste = teste;
	}

	public byte getConfigFileUploaded() {
		return configFileUploaded;
	}

	public void setConfigFileUploaded(byte configFileUploaded) {
		this.configFileUploaded = configFileUploaded;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public int getEtatMMA() {
		return etatMMA;
	}
	public void setEtatMMA(int etatMMA) {
		this.etatMMA = etatMMA;
	}
	
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public long getId_maloc() {
		return id_maloc;
	}
	public void setId_maloc(long id_maloc) {
		this.id_maloc = id_maloc;
	}
	public Type_boitier getType_boitiers() {
		return type_boitiers;
	}
	public void setType_boitiers(Type_boitier type_boitiers) {
		this.type_boitiers = type_boitiers;
	}
	public Type_boitier getType_boitier() {
		return type_boitiers;
	}
	public void setType_boitier(Type_boitier type_boitier) {
		this.type_boitiers = type_boitier;
	}
	@JsonIgnore
	public List<Brancher> getBranches() {
		return branches;
	}
	public void setBranches(List<Brancher> branches) {
		this.branches = branches;
	}
	

	

	
	

}
