package com.maloc.entity;

import java.io.Serializable;

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
@Table(name="USER_TICKET")
public class User_ticket implements Serializable  {
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_user")
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_ticket")
	private Ticket ticket;
	public User_ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User_ticket(int id, User user, Ticket ticket) {
		super();
		this.id = id;
		this.user = user;
		this.ticket = ticket;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
