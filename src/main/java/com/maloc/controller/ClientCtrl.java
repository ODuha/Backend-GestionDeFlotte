package com.maloc.controller;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maloc.entity.Client;
import com.maloc.entity.Compte;
import com.maloc.entity.Type_client;
import com.maloc.helper.ResponseRest;
import com.maloc.repository.IClientRepository;
import com.maloc.repository.ICompteRepository;
import com.maloc.repository.ISessionRepository;
import com.maloc.repository.ITypeClientRepository;

@RestController
@CrossOrigin(origins = "*")
public class ClientCtrl {

	@Autowired
	private IClientRepository clientRepository;
	@Autowired
	private ISessionRepository sessionRepository;
	@Autowired
	private ICompteRepository compteRepository;
	@Autowired
	private ITypeClientRepository typeClientRepository;
	

	@RequestMapping(value ="/client",method = RequestMethod.GET)
	public ResponseEntity<List<Client>> listclient(){
		List<Client> listclient=clientRepository.findAll();
		return new ResponseEntity<List<Client>>(listclient,HttpStatus.OK);
	}
	@RequestMapping(value ="/compte",method = RequestMethod.GET)
	public ResponseEntity<List<Compte>> listcompte(){
		System.out.println("hey");
		List<Compte> listcompte=compteRepository.findAll();
		System.out.println(listcompte);

		return new ResponseEntity<List<Compte>>(listcompte,HttpStatus.OK);

	}
	
	@RequestMapping(value = "/bo/{apikey}/client_exist", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	private Map<String, Object> client_exist(@PathVariable Integer apikey,@RequestParam String s) {
		System.out.println(s);
		if(sessionRepository.getUser_byApiKey(apikey) != null)
		{

			Client c = clientRepository.getClient_exist(s);
			if(c != null)
			{
					
			return ResponseRest.success(c, "success");
			}
			else
			return ResponseRest.success(false, "success");
		}
		return ResponseRest.error("Erreur APIKEY not found", "erreur");
	}
	@RequestMapping(value = "/bo/{apikey}/compte_exist", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	private Map<String, Object> compte_exist(@PathVariable Integer apikey,@RequestParam String login) {
		
		if(sessionRepository.getUser_byApiKey(apikey) != null)
		{

			Compte c = compteRepository.getCompte_exist(login);
			if(c != null)
			{
			return ResponseRest.success(c, "success");
			}
			else
			return ResponseRest.success(false, "success");
		}
		return ResponseRest.error("Erreur APIKEY not found", "erreur");
	}
	@RequestMapping(value = "/bo/{apikey}/add_client", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	private Map<String, Object> add_client(@PathVariable Integer apikey,@RequestBody Map<String,Object> map) {
		System.out.println(map.toString());
		if(sessionRepository.getUser_byApiKey(apikey) != null)
		{
			Type_client type = typeClientRepository.findOne(Long.parseLong(map.get("type").toString()));
			Client client = new Client();
			client.setActif((byte)1);
			client.setTypeclient(type);
			client.setEmail(map.get("email").toString());
			client.setTel(map.get("tel").toString());
			client.setAdresse(map.get("adresse").toString());
			
			switch (Integer.parseInt(type.getId()+"")) {
			case 1:
				client.setNom(map.get("nom").toString());
				client.setPrenom(map.get("prenom").toString());
				client.setCine(map.get("cine").toString());
				break;
			default:
				client.setNom_societe(map.get("nom_societe").toString());
				client.setRc(map.get("rc").toString());
				break;
			}
			client = clientRepository.saveAndFlush(client);
		
			List<Map<String,Object>> maps = (List<Map<String, Object>>) map.get("comptes");
			for(Map<String,Object> m : maps)
			{
				Compte compte = new Compte();
				compte.setClient(client);
				compte.setEmail(m.get("email").toString());
				compte.setLogin(m.get("login").toString());
				compte.setTel(m.get("tel").toString());
				compte.setPassword(m.get("password").toString());
				compte = compteRepository.saveAndFlush(compte);
			}
			return ResponseRest.success(client, "success");
			
		}


		return ResponseRest.error("Erreur APIKEY not found", "erreur");
		
	}
	@RequestMapping(value = "/bo/{apikey}/update_client", method = RequestMethod.PUT)
	@ResponseBody
	@Transactional
	private Client update_client(@PathVariable Integer apikey,@RequestBody Client client) {
		System.out.println(client.toString());
		if(sessionRepository.getUser_byApiKey(apikey) != null)
		{
		
		
			
			Long id=client.getId();
			

			Client c = clientRepository.findOne(id);
			System.out.println(id);

			c.setNom(client.getNom());
			c.setPrenom(client.getPrenom());
			c.setCine(client.getCine());
			c.setEmail(client.getEmail());
			c.setTel(client.getTel());
			c.setAdresse(client.getAdresse());
			
		
				
		
				c.setNom_societe(client.getNom_societe());
				c.setRc(client.getRc());
			
			
			client = clientRepository.saveAndFlush(c);
		
		
			}
		
		return client;
	}
	
	@RequestMapping(value = "/bo/{apikey}/desactiver", method = RequestMethod.PUT)
	@ResponseBody
	@Transactional
	private Client desactiver(@PathVariable Integer apikey,@RequestBody Client client) {
		System.out.println(client.toString());
		if(sessionRepository.getUser_byApiKey(apikey) != null)
		{
		
		
			
			Long id=client.getId();
			

			Client c = clientRepository.findOne(id);
			System.out.println(id);

			
		
		
			}
		
		return client;
	}
	
	
	

	
}
