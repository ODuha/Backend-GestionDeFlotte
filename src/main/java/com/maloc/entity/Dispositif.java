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
@Table(name="DISPOSITIF")
public class Dispositif implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column(name="TYPE")
	private String Type;
	@Column(name="id_maloc")
	private long id_maloc;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_typedispositif")
	private Type_dispositif typedispositif;
	@OneToMany(mappedBy = "dispositif")	
	private List<Dispositif_engine> Dispositif_engines;
	public Dispositif(long id, String type, long idmaloc) {
		super();
		this.id = id;
		Type = type;
		id_maloc = id_maloc;
	}
	public Dispositif() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public long getId_maloc() {
		return id_maloc;
	}
	public void setIdmaloc(long id_maloc) {
		id_maloc = id_maloc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Type_dispositif getTypedispositif() {
		return typedispositif;
	}
	public void setTypedispositif(Type_dispositif typedispositif) {
		this.typedispositif = typedispositif;
	}
	@JsonIgnore
	public List<Dispositif_engine> getDispositif_engines() {
		return Dispositif_engines;
	}
	public void setDispositif_engines(List<Dispositif_engine> dispositif_engines) {
		Dispositif_engines = dispositif_engines;
	}
	public void setId_maloc(long id_maloc) {
		this.id_maloc = id_maloc;
	}

}
