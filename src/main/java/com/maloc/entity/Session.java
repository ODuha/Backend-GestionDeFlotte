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
@Table(name="SESSION")
public class Session implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="date_connexion",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date date_connexion;
	@Column(name="keyAPI")
	private int key;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_user")
	private User user;
	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Session(int id, Date date_connexion, int key, User user) {
		super();
		this.id = id;
		this.date_connexion = date_connexion;
		this.key = key;
		this.user = user;
	}
	public Session(int key, User user) {
		super();
		this.key = key;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate_connexion() {
		return date_connexion;
	}
	public void setDate_connexion(Date date_connexion) {
		this.date_connexion = date_connexion;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}	
