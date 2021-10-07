package com.maloc.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="SCRIPT")
public class Script implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getScript() {
		return Script;
	}
	public void setScript(String script) {
		Script = script;
	}
	public String getVersionM() {
		return VersionM;
	}
	public void setVersionM(String versionM) {
		VersionM = versionM;
	}

	
	public Script() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Script(long id, String name, String script, String versionM,
			Date dateM, long idmaloc, List<Type_boitier> typeboitier) {
		super();
		this.id = id;
		Name = name;
		Script = script;
		VersionM = versionM;
		DateM = dateM;
		Idmaloc = idmaloc;
		this.typeboitier = typeboitier;
	}
	public Date getDateM() {
		return DateM;
	}
	public void setDateM(Date dateM) {
		DateM = dateM;
	}
	public long getIdmaloc() {
		return Idmaloc;
	}
	public void setIdmaloc(long idmaloc) {
		Idmaloc = idmaloc;
	}
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="NAME")
	private String Name;
	@Column(name="SCRIPT")
	private String Script;
	@Column(name="VERSIONMAJ")
	private String VersionM;
	@Column(name="DATEMAJ")
	private Date DateM;
	@Column( name="IDmaloc")
	private long Idmaloc;
	@OneToMany(mappedBy = "script")	
	private List<Type_boitier> typeboitier;
	@JsonIgnore
	public List<Type_boitier> getTypeboitier() {
		return typeboitier;
	}
	public void setTypeboitier(List<Type_boitier> typeboitier) {
		this.typeboitier = typeboitier;
	}

}
