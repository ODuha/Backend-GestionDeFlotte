package com.maloc.entity;



import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="USER_LOG")
public class User_Log implements Serializable  { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public User_Log(long id, Date date, long action, long idmaloc) {
		super();
		this.id = id;
		this.date = date;
		this.action = action;
		Idmaloc = idmaloc;
	}
	public User_Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getAction() {
		return action;
	}
	public void setAction(long action) {
		this.action = action;
	}
	public long getIdmaloc() {
		return Idmaloc;
	}
	public void setIdmaloc(long idmaloc) {
		Idmaloc = idmaloc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="DATE")
	private Date date;
	@Column(name="ACTION")
	private long action;
	@Column(name="IDmaloc")
    private long Idmaloc;

}
