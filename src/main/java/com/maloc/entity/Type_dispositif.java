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
@Table(name="TYPE_DISPOSITIF")
public class Type_dispositif implements Serializable   {    



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
	@Column(name="description")
	private String description;
	@Column(name="qterestante")
	private int qteRestante;
	@OneToMany(mappedBy = "typedispositif")	
	private List<Dispositif> dispositifs;
	@OneToMany(mappedBy = "type_dispositif")	
	private List<Fournir_dispo> fournirs;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_fournisseur")
	private Fournisseur fournisseur;
	@Column(name="SEUIL")
	private int seuil;
	@Column(name="id_maloc")
	private long id_maloc;
	public Type_dispositif(long id, String type, String description,
			int qteRestante, int seuil, long id_maloc) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.qteRestante = qteRestante;
		this.seuil = seuil;
		id_maloc = id_maloc;
	}
	public Type_dispositif() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@JsonIgnore

	public long getId() {
		return id;
	}
	@JsonIgnore
	public List<Dispositif> getDispositifs() {
		return dispositifs;
	}
	public void setDispositifs(List<Dispositif> dispositifs) {
		this.dispositifs = dispositifs;
	}
	@JsonIgnore
	public List<Fournir_dispo> getFournirs() {
		return fournirs;
	}
	public void setFournirs(List<Fournir_dispo> fournirs) {
		this.fournirs = fournirs;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public long getId_maloc() {
		return id_maloc;
	}
	public void setId_maloc(long id_maloc) {
		this.id_maloc = id_maloc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQteRestante() {
		return qteRestante;
	}
	public void setQteRestante(int qteRestante) {
		this.qteRestante = qteRestante;
	}
	public int getSeuil() {
		return seuil;
	}
	public void setSeuil(int seuil) {
		this.seuil = seuil;
	}
	public long getIdmaloc() {
		return id_maloc;
	}
	public void setIdmaloc(long id_maloc) {
		id_maloc = id_maloc;
	}
	
	}
	
	
	
	


