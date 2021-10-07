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
@Table(name="TYPE_OPERATEUR")

public class Type_operateur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="nomoperateur")
	private String nomoperateur;
	@Column(name="observation")
	private String observation;
	@Column(name="seuilalerte", columnDefinition = "integer default 15")
	private int seuilAlerte;
	@Column(name="IDmaloc")
	private long idmaloc;
	@OneToMany(mappedBy = "type_operateur")	
	private List<Sim> sims;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_fournisseur")
	private Fournisseur fournisseur;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomoperateur() {
		return nomoperateur;
	}
	public void setNomoperateur(String nomoperateur) {
		this.nomoperateur = nomoperateur;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public int getSeuilAlerte() {
		return seuilAlerte;
	}
	public void setSeuilAlerte(int seuilAlerte) {
		this.seuilAlerte = seuilAlerte;
	}
	public long getIdmaloc() {
		return idmaloc;
	}
	public void setIdmaloc(long idmaloc) {
		this.idmaloc = idmaloc;
	}
	@JsonIgnore
	public List<Sim> getSims() {
		return sims;
	}
	public void setSims(List<Sim> sims) {
		this.sims = sims;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
