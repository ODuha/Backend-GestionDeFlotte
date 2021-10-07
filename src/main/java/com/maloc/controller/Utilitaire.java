package com.maloc.controller;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maloc.entity.User;
import com.maloc.helper.ResponseRest;
import com.maloc.repository.IClientRepository;
import com.maloc.repository.ICompteRepository;
import com.maloc.repository.ISessionRepository;
import com.maloc.repository.IUserRepository;

@RestController
@Controller
@CrossOrigin(origins = "*")
public class Utilitaire {
	
	@Autowired
	public IUserRepository iUserRep;
	@Autowired
	public ISessionRepository iSessionRep;
	@Autowired
	public IClientRepository iClientRep;
	@Autowired
	public ICompteRepository iCompteRep;
	
	@RequestMapping(value = "/bo/{apikey}/getclients", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getClients(@PathVariable Integer apikey) {
		System.out.println("je suis la !");
		if(iSessionRep.getUser_byApiKey(apikey) != null)
			return ResponseRest.success(iClientRep.findAll(), "success");
		return ResponseRest.error(null, "error");
	}
	@RequestMapping(value = "/bo/{apikey}/getclientcomptes", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	private Map<String, Object> getClientComptes(@PathVariable Integer apikey,@RequestParam long id_client) {
		if(iSessionRep.getUser_byApiKey(apikey) != null)
			return ResponseRest.success(iCompteRep.getComptes_byClient(id_client), "success");
		return ResponseRest.error(null, "error");
	}

}
