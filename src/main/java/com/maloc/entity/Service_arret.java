package com.maloc.entity;

import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="arret")
public class Service_arret extends Service {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Service_arret(long id, Date date_instalation, Date date_echeance,
			Date date_retir, Brancher branche) {
		super(id, date_instalation, date_echeance, date_retir, branche);
		// TODO Auto-generated constructor stub
	}
}
