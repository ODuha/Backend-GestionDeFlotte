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
@Table(name="TYPE_BOITIER")
public class Type_boitier implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
@Column(name="Serie")
private String serie;
@Column(name="observation")
private String observation;
@Column(name="seuil")
private long seuil;
@Column(name="port")
private long port;


@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name ="id_protocol")
private Protocol protocol;

@Column(name="id_maloc")
private long id_maloc;
@OneToMany(mappedBy = "type_boitiers")	
private List<Boitier> boitiers;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name ="id_script")
private Script script;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name ="id_fournisseur")
private Fournisseur fournisseur;
public Type_boitier() {
	super();
	// TODO Auto-generated constructor stub
}
public Type_boitier(long id, String serie, String observation, long seuil, long port, Protocol protocol, long id_maloc,
		List<Boitier> boitiers, Script script, Fournisseur fournisseur) {
	super();
	this.id = id;
	this.serie = serie;
	this.observation = observation;
	this.seuil = seuil;
	this.port = port;
	this.protocol = protocol;
	this.id_maloc = id_maloc;
	this.boitiers = boitiers;
	this.script = script;
	this.fournisseur = fournisseur;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getSerie() {
	return serie;
}
public void setSerie(String serie) {
	this.serie = serie;
}
public String getObservation() {
	return observation;
}
public void setObservation(String observation) {
	this.observation = observation;
}
public long getSeuil() {
	return seuil;
}
public void setSeuil(long seuil) {
	this.seuil = seuil;
}
public long getPort() {
	return port;
}
public void setPort(long port) {
	this.port = port;
}
public Protocol getProtocol() {
	return protocol;
}
public void setProtocol(Protocol protocol) {
	this.protocol = protocol;
}
public long getId_maloc() {
	return id_maloc;
}
public void setId_maloc(long id_maloc) {
	this.id_maloc = id_maloc;
}
@JsonIgnore
public List<Boitier> getBoitiers() {
	return boitiers;
}
public void setBoitiers(List<Boitier> boitiers) {
	this.boitiers = boitiers;
}
public Script getScript() {
	return script;
}
public void setScript(Script script) {
	this.script = script;
}
public Fournisseur getFournisseur() {
	return fournisseur;
}
public void setFournisseur(Fournisseur fournisseur) {
	this.fournisseur = fournisseur;
}



}
