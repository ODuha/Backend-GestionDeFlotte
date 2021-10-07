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
@Table(name="Dispositif_engine")
public class Dispositif_engine implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Dispositif_engine(Date date_instalation, Date date_echeance,
			long id_dmaloc) {
		super();
		this.date_instalation = date_instalation;
		this.date_echeance = date_echeance;
		id_maloc = id_maloc;
	}
	public Dispositif_engine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Date getDate_instalation() {
		return date_instalation;
	}
	public void setDate_instalation(Date date_instalation) {
		this.date_instalation = date_instalation;
	}
	public Date getDate_echeance() {
		return date_echeance;
	}
	public void setDate_echeance(Date date_echeance) {
		this.date_echeance = date_echeance;
	}
	public long getIdmaloc() {
		return id_maloc;
	}
	public void setIdmaloc(long id_maloc) {
		id_maloc = id_maloc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public Dispositif_engine(long id, Date date_instalation,
			Date date_echeance, long idmaloc, Dispositif dispositif) {
		super();
		this.id = id;
		this.date_instalation = date_instalation;
		this.date_echeance = date_echeance;
		id_maloc = id_maloc;
		this.dispositif = dispositif;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Dispositif getDispositif() {
		return dispositif;
	}
	public void setDispositif(Dispositif dispositif) {
		this.dispositif = dispositif;
	}
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="date_instalation")
	private Date date_instalation;
	@Column(name="date_echeance")
	private Date date_echeance;
	@Column(name="id_maloc")
	private long id_maloc;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_dispositif")
	private Dispositif dispositif;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_engine")
	private Engine engine;

}
