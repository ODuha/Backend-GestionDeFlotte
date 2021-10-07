package com.maloc.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_SERVICE",
discriminatorType=DiscriminatorType.STRING)
@Table(name="SERVICE")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="date_instalation")
	private Date date_instalation;
	@Column(name="date_echeance")
	private Date date_echeance;
	@Column(name="date_retir",nullable=true)
	private Date date_retir;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_brancher")
	private Brancher branche;
	public Service(long id, Date date_instalation, Date date_echeance,
			Date date_retir, Brancher branche) {
		super();
		this.id = id;
		this.date_instalation = date_instalation;
		this.date_echeance = date_echeance;
		this.date_retir = date_retir;
		this.branche = branche;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Date getDate_retir() {
		return date_retir;
	}
	public void setDate_retir(Date date_retir) {
		this.date_retir = date_retir;
	}
	public Brancher getBranche() {
		return branche;
	}
	public void setBranche(Brancher branche) {
		this.branche = branche;
	}
	

}
