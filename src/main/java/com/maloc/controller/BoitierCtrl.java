package com.maloc.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maloc.entity.Boitier;
import com.maloc.entity.Brancher;
import com.maloc.entity.Client;
import com.maloc.entity.Compte;
import com.maloc.entity.Engine;
import com.maloc.entity.Sim;
import com.maloc.entity.Type_boitier;
import com.maloc.entity.Type_client;
import com.maloc.entity.Type_engine;
import com.maloc.entity.Type_operateur;
import com.maloc.helper.ResponseRest;
import com.maloc.repository.IBoitierRepository;
import com.maloc.repository.IBrancherRepository;
import com.maloc.repository.IClientRepository;
import com.maloc.repository.ICompteRepository;
import com.maloc.repository.IEngineRepository;
import com.maloc.repository.ISessionRepository;
import com.maloc.repository.ISimRepository;
import com.maloc.repository.ITypeBoitierRepository;
import com.maloc.repository.ITypeClientRepository;
import com.maloc.repository.ITypeEngineRepository;
import com.maloc.repository.ITypeOperateurRepository;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@RestController
@CrossOrigin(origins = "*")
public class BoitierCtrl {
	@Autowired
	private IBoitierRepository boitierRepository;

	@Autowired
	private IClientRepository clientRepository;
	@Autowired
	private IBrancherRepository brancherRepository;
	@Autowired
	private ISessionRepository sessionRepository;
	@Autowired
	private ICompteRepository compteRepository;
	@Autowired
	private ISimRepository simRepository;
	@Autowired
	private IEngineRepository engineRepository;
	@Autowired
	private ITypeClientRepository typeClientRepository;
	@Autowired
	private ITypeEngineRepository typeEngineRepository;
	@Autowired
	private ITypeBoitierRepository typeBoitierRepository;
	@Autowired
	private ITypeOperateurRepository typeOperateurRepository;

	
	
    @Autowired
	@RequestMapping(value ="/type_boitier",method = RequestMethod.GET)
    ResponseEntity<List<Type_boitier>> listtype_boitier(){
		System.out.println("hello");
		List<Type_boitier> listtype_boitier=typeBoitierRepository.findAll();
		System.out.println(listtype_boitier);

		return new ResponseEntity<List<Type_boitier>>(listtype_boitier,HttpStatus.OK);
	} 
    @Autowired
	@RequestMapping(value ="/type_operateur",method = RequestMethod.GET)
    ResponseEntity<List<Type_operateur>> listtype_operateur(){
		System.out.println("hello");
		List<Type_operateur> listtype_operateur=typeOperateurRepository.findAll();
		System.out.println(listtype_operateur);

		return new ResponseEntity<List<Type_operateur>>(listtype_operateur,HttpStatus.OK);
	}
    @Autowired
  	@RequestMapping(value ="/brancher",method = RequestMethod.GET)
      ResponseEntity<List<Brancher>> listbrancher(){
  		System.out.println("hello");
  		List<Brancher> listbrancher  =brancherRepository.findAll();
  		System.out.println(listbrancher);

  		return new ResponseEntity<List<Brancher>>(listbrancher,HttpStatus.OK);
  	}
    
    @Autowired
	@RequestMapping(value ="/type_engine",method = RequestMethod.GET)
    ResponseEntity<List<Type_engine>> listtype_engine(){
		List<Type_engine> listtype_engine=typeEngineRepository.findAll();
		return new ResponseEntity<List<Type_engine>>(listtype_engine,HttpStatus.OK);
	}
	

    @RequestMapping(value = "/bo/{apikey}/installation", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	private Map<String, Object> installation(@PathVariable Integer apikey,@RequestBody Map<String,Object> map){ 
    	if(sessionRepository.getUser_byApiKey(apikey) != null)
		{
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		System.out.println(map);
    		Map<String,Object> boitier_m = (Map<String,Object>)map.get("id_boitier");
    		Map<String,Object> type_boitier_m = (Map<String,Object>)boitier_m.get("type_boitier");
    		Map<String,Object> compte_m = (Map<String,Object>) map.get("id_compte");
    		Map<String,Object> sim_m = (Map<String,Object>) map.get("id_sim");
    		Map<String,Object> type_operateur_m = (Map<String,Object>) sim_m.get("type_operateur");

    		Map<String,Object> engine_m = (Map<String,Object>) map.get("id_engine");
    		Map<String,Object> type_engine_m = (Map<String,Object>) engine_m.get("type_engine");
    		
    		Boitier boitier = new Boitier();
    		boitier.setImei(Long.parseLong(boitier_m.get("imei").toString()));
    		Type_boitier type_boitier = typeBoitierRepository.findOne(Long.parseLong(type_boitier_m.get("id").toString()));
    		boitier.setType_boitier(type_boitier);
    		boitier.setTeste((byte)1);
    		boitier=boitierRepository.saveAndFlush(boitier);
    		Compte compte = compteRepository.findOne(Long.parseLong(compte_m.get("id").toString()));
    		Sim sim = new Sim();
    		sim.setTest((byte)1);
    		sim.setTel(sim_m.get("tel").toString());
    		Type_operateur type_operateur = typeOperateurRepository.findOne(Long.parseLong(type_operateur_m.get("id").toString()));
    		sim.setType_operateur(type_operateur);
    		sim = simRepository.saveAndFlush(sim);
    		Engine engine = new Engine();
        	engine.setMarque(engine_m.get("marque").toString());
        	engine.setMatricule(engine_m.get("matricule").toString());
        	engine.setModel(engine_m.get("model").toString());
        	Type_engine type_engine=typeEngineRepository.findOne(Long.parseLong(type_engine_m.get("id").toString()));
        	engine.setTypeengine(type_engine);
        	engine = engineRepository.saveAndFlush(engine);
        	Brancher brancher = new Brancher();
        	brancher.setBoitier(boitier);
        	brancher.setCompte(compte);
        	brancher.setEngine(engine);
        	
        	try {
				brancher.setDate_installation(sdf.parse(map.get("date_installation").toString()));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        	brancher.setSim(sim);
        	brancher = brancherRepository.saveAndFlush(brancher);
        	
    		return ResponseRest.success(brancher, "success");
        	
		}
    	else
    	{
    		Map<String,Object> map_deconnecte = new HashMap<String, Object>();
    		map_deconnecte.put("deconnect", true);
    		return ResponseRest.error(map_deconnecte, "error user deconnected !");
    	}
    		
    }
	
	/*
	@RequestMapping(value = "/bo/{apikey}/add_boitier", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	private Map<String, Object> add_boitier(@PathVariable Integer apikey,@RequestBody Map<String,Object> map) {
		System.out.println(map.toString());
		 Boitier boitier = new Boitier();
		if(sessionRepository.getUser_byApiKey(apikey) != null)
		{
            
			Type_boitier type = typeBoitierRepository.findOne(Long.parseLong(map.get("observation").toString()));
           
			boitier.setImei((Integer) map.get("imei"));
		    boitier.setType_boitier(type);
			boitier = boitierRepository.saveAndFlush(boitier);
			
			Sim sim = new Sim();
			sim.setTel(map.get("tel").toString());
			sim = simRepository.saveAndFlush(sim);
			Type_operateur type_operateur= new Type_operateur();
			type_operateur.setNomoperateur(map.get("nomoperateur").toString());
			type_operateur = typeOperateurRepository.saveAndFlush(type_operateur);
			Engine engine = new Engine();
			engine.setMatricule(map.get("matricule").toString());
			engine.setMarque(map.get("marque").toString());
			engine.setModel(map.get("model").toString());
			engine = engineRepository.saveAndFlush(engine);
			
			
			Compte compte = compteRepository.findOne((map.get("login").toString()));
			compte = compteRepository.saveAndFlush(compte);
			
        	List<Map<String,Object>> map1 = (List<Map<String, Object>>) map.get("branches");
			for(Map<String,Object> m : map1)
			{
				Brancher brancher = new Brancher();
				brancher.setDate_installation((m.get("date_instalation")).toString());
	            brancher.setBoitier(boitier);
	            brancher.setSim(sim);
	            brancher.setEngine(engine);
	            brancher.setCompte(compte);
				brancher = brancherRepository.saveAndFlush(brancher);
			}
			
			return ResponseRest.success("su", "success");
			
	
	}
	
		return ResponseRest.error("Erreur APIKEY not found", "erreur");
		
	}*/
}
