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
@Table(name="TYPE_CLIENT")
public class Type_client implements Serializable {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="type")
	private String type;
	@Column(name="id_maloc")
	private long id_maloc;
	@OneToMany(mappedBy = "typeclient")	
	private List<Client> Clients;
	public Type_client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Type_client(long id, String type, long id_maloc, List<Client> clients) {
		super();
		this.id = id;
		this.type = type;
		this.id_maloc = id_maloc;
		Clients = clients;
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
	public long getId_maloc() {
		return id_maloc;
	}
	public void setId_maloc(long id_maloc) {
		this.id_maloc = id_maloc;
	}
	@JsonIgnore
	public List<Client> getClients() {
		return Clients;
	}
	public void setClients(List<Client> clients) {
		Clients = clients;
	}
	
	
	
	

}
