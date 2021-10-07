package com.maloc.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="TICKET")
public class Ticket  implements Serializable  {
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="date_creation",nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	private Date date_creation;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_created_by")
	private User created_by;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="id_treated_by" , nullable=true)
	private User treated_by;
	@Column(name="description")
	private String description;
	@Column(name="date_fin_traitement",nullable = true)
	private Date date_fin_traitement;
	@Column(name="etat",nullable = false)
	private short etat;
	@Column(nullable = false, columnDefinition = "tinyint(1) default 0")
	private Byte  treated;
	@Column(name="note",nullable=true)
	private String note;
	@OneToMany(mappedBy = "ticket")	
	private List<User_ticket> User_tickets;
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(int id, Date date_creation, User created_by,
			String description, Date date_fin_traitement, short etat,
			User treated_by, Byte treated, String note,
			List<User_ticket> user_tickets) {
		super();
		this.id = id;
		this.date_creation = date_creation;
		this.created_by = created_by;
		this.description = description;
		this.date_fin_traitement = date_fin_traitement;
		this.etat = etat;
		this.treated_by = treated_by;
		this.treated = treated;
		this.note = note;
		User_tickets = user_tickets;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public User getCreated_by() {
		return created_by;
	}
	public void setCreated_by(User created_by) {
		this.created_by = created_by;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate_fin_traitement() {
		return date_fin_traitement;
	}
	public void setDate_fin_traitement(Date date_fin_traitement) {
		this.date_fin_traitement = date_fin_traitement;
	}
	public short getEtat() {
		return etat;
	}
	public void setEtat(short etat) {
		this.etat = etat;
	}
	public User getTreated_by() {
		return treated_by;
	}
	public void setTreated_by(User treated_by) {
		this.treated_by = treated_by;
	}
	public Byte getTreated() {
		return treated;
	}
	public void setTreated(Byte treated) {
		this.treated = treated;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
