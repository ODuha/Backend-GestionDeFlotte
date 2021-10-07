package com.maloc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="FOURNISSEUR")
public class Fournisseur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="type")
	private String type;
	@Column(name="pays")
	private String pays;
	@Column(name="email")
	private String email;
	@Column(name="ntel")
	private String ntel;
	@Column(name="observation")
	private String observation;
	@Column(name="IDmaloc",nullable=true)
	private long idmaloc;
	@OneToMany(mappedBy = "fournisseur")	
	private List<Fournir_dispo> fournir_dispos;
	@OneToMany(mappedBy = "fournisseurs")	
	private List<Fournir_operateur> fournir_operateurs;
	@OneToMany(mappedBy = "fournisseur")	
	private List<Fournir_boitier> fournir_boitiers;
	@OneToMany(mappedBy = "fournisseur")	
	private List<Type_operateur> type_operateurs; 
	@OneToMany(mappedBy = "fournisseur")	
	private List<Type_boitier> type_boitiers;
	@OneToMany(mappedBy = "fournisseur")	
	private List<Type_dispositif> type_dispositifs;
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fournisseur(long id, String type, String pays, String email,
			String ntel, String observation, long idmaloc,
			List<Fournir_dispo> fournir_dispos,
			List<Fournir_operateur> fournir_operateurs,
			List<Fournir_boitier> fournir_boitiers,
			List<Type_operateur> type_operateurs,
			List<Type_boitier> type_boitiers,
			List<Type_dispositif> type_dispositifs) {
		super();
		this.id = id;
		this.type = type;
		this.pays = pays;
		this.email = email;
		this.ntel = ntel;
		this.observation = observation;
		this.idmaloc = idmaloc;
		this.fournir_dispos = fournir_dispos;
		this.fournir_operateurs = fournir_operateurs;
		this.fournir_boitiers = fournir_boitiers;
		this.type_operateurs = type_operateurs;
		this.type_boitiers = type_boitiers;
		this.type_dispositifs = type_dispositifs;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNtel() {
		return ntel;
	}
	public void setNtel(String ntel) {
		this.ntel = ntel;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public long getIdmaloc() {
		return idmaloc;
	}
	public void setIdmaloc(long idmaloc) {
		this.idmaloc = idmaloc;
	}
	@JsonIgnore
	public List<Fournir_dispo> getFournir_dispos() {
		return fournir_dispos;
	}
	public void setFournir_dispos(List<Fournir_dispo> fournir_dispos) {
		this.fournir_dispos = fournir_dispos;
	}
	@JsonIgnore
	public List<Fournir_operateur> getFournir_operateurs() {
		return fournir_operateurs;
	}
	public void setFournir_operateurs(List<Fournir_operateur> fournir_operateurs) {
		this.fournir_operateurs = fournir_operateurs;
	}
	@JsonIgnore
	public List<Fournir_boitier> getFournir_boitiers() {
		return fournir_boitiers;
	}
	public void setFournir_boitiers(List<Fournir_boitier> fournir_boitiers) {
		this.fournir_boitiers = fournir_boitiers;
	}
	@JsonIgnore
	public List<Type_operateur> getType_operateurs() {
		return type_operateurs;
	}
	public void setType_operateurs(List<Type_operateur> type_operateurs) {
		this.type_operateurs = type_operateurs;
	}
	@JsonIgnore
	public List<Type_boitier> getType_boitiers() {
		return type_boitiers;
	}
	public void setType_boitiers(List<Type_boitier> type_boitiers) {
		this.type_boitiers = type_boitiers;
	}
	@JsonIgnore
	public List<Type_dispositif> getType_dispositifs() {
		return type_dispositifs;
	}
	public void setType_dispositifs(List<Type_dispositif> type_dispositifs) {
		this.type_dispositifs = type_dispositifs;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
	


}
