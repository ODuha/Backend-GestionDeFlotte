package com.maloc.model;

import java.util.Date;

public class devices_infos {

	private long id;
	private String internal_code;
	private long id_etat;
	private long imei;
	private String name;
	private long sim;
	private Date date_server;
	private Date end_date;
	private Date start_date;
	private int nbr_vehicle;
	private String protocol_name;
	private String type_name;
	private boolean no_yellow;
	
	
	public devices_infos(long id, String internal_code, long id_etat,
			long imei, String name, long sim, Date date_server, Date end_date,
			Date start_date, int nbr_vehicle, String protocol_name,
			String type_name) {
		super();
		this.id = id;
		this.internal_code = internal_code;
		this.id_etat = id_etat;
		this.imei = imei;
		this.name = name;
		this.sim = sim;
		this.date_server = date_server;
		this.end_date = end_date;
		this.start_date = start_date;
		this.nbr_vehicle = nbr_vehicle;
		this.protocol_name = protocol_name;
		this.type_name = type_name;
	}
	public devices_infos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getInternal_code() {
		return internal_code;
	}
	public void setInternal_code(String internal_code) {
		this.internal_code = internal_code;
	}
	public long getId_etat() {
		return id_etat;
	}
	public void setId_etat(long id_etat) {
		this.id_etat = id_etat;
	}
	public long getImei() {
		return imei;
	}
	public void setImei(long imei) {
		this.imei = imei;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSim() {
		return sim;
	}
	public void setSim(long sim) {
		this.sim = sim;
	}
	public Date getDate_server() {
		return date_server;
	}
	public void setDate_server(Date date_server) {
		this.date_server = date_server;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getProtocol_name() {
		return protocol_name;
	}
	public void setProtocol_name(String protocol_name) {
		this.protocol_name = protocol_name;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public int getNbr_vehicle() {
		return nbr_vehicle;
	}
	public void setNbr_vehicle(int nbr_vehicle) {
		this.nbr_vehicle = nbr_vehicle;
	}
	public boolean isNo_yellow() {
		return no_yellow;
	}
	public void setNo_yellow(boolean no_yellow) {
		this.no_yellow = no_yellow;
	}
	
	
	
}
