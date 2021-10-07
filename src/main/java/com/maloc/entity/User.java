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
@Table(name="USER")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="login",unique=true)
	private String login;
	@Column(name="password")
	private String password;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_typeuser")
	private Type_User type_user;
	@Column(name="active")
	private boolean active;
	@OneToMany(mappedBy = "user")	
	private List<Session> sessions;
	@OneToMany(mappedBy = "created_by")	
	private List<Ticket> tickets_created;
	@OneToMany(mappedBy = "treated_by")	
	private List<Ticket> tickets_treated;
	@OneToMany(mappedBy = "user")	
	private List<User_ticket> User_tickets;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	public User(int id, String login, String password, Type_User type_user,
			boolean active) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.type_user = type_user;
		this.active = active;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Type_User getType_user() {
		return type_user;
	}
	public void setType_user(Type_User type_user) {
		this.type_user = type_user;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@JsonIgnore
	public List<Session> getSessions() {
		return sessions;
	}
	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	@JsonIgnore
	public List<Ticket> getTickets_created() {
		return tickets_created;
	}
	public void setTickets_created(List<Ticket> tickets_created) {
		this.tickets_created = tickets_created;
	}
	@JsonIgnore
	public List<Ticket> getTickets_treated() {
		return tickets_treated;
	}
	public void setTickets_treated(List<Ticket> tickets_treated) {
		this.tickets_treated = tickets_treated;
	}
	@JsonIgnore
	public List<User_ticket> getUser_tickets() {
		return User_tickets;
	}
	public void setUser_tickets(List<User_ticket> user_tickets) {
		User_tickets = user_tickets;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	

}
