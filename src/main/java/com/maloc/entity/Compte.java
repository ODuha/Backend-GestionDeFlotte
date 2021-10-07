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
@Table(name="COMPTE")
public class Compte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="login" , nullable=false)
	private String login;
	@Column(name="password" , nullable=false)
	private String password;
	@Column(name="email")
	private String email;
	@Column(name="tel")
	private String tel;
	@Column(name="observation")
	private String observation;
	@Column(name="id_maloc")
	private long id_maloc;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_client")
	private Client client ;
	@OneToMany(mappedBy = "compte")	
	private List<Brancher> branches;
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(long id, String login, String password, String email,
			String tel, String observation, long id_maloc, Client client,
			List<Brancher> branches) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
		this.tel = tel;
		this.observation = observation;
		this.id_maloc = id_maloc;
		this.client = client;
		this.branches = branches;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	@JsonIgnore
	public List<Brancher> getBranches() {
		return branches;
	}

	public void setBranches(List<Brancher> branches) {
		this.branches = branches;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
