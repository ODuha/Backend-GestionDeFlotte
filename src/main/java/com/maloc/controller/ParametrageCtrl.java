package com.maloc.controller;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maloc.entity.Protocol;
import com.maloc.entity.Type_operateur;
import com.maloc.helper.ResponseRest;
import com.maloc.repository.IProtocolRepsitory;
import com.maloc.repository.ISessionRepository;

@RestController
@RequestMapping(value = "/bo/{apikey}")
@Controller
@CrossOrigin(origins = "*")
public class ParametrageCtrl {
	@Autowired
	public IProtocolRepsitory iProtocolRep;
	@Autowired
	public ISessionRepository isessionRep;
	
	
	@RequestMapping(value = "/addprotocol", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	private Map<String, Object> addProtocl(@PathVariable Integer apikey, @RequestBody Protocol b) {
		if(isessionRep.getUser_byApiKey(apikey) != null)
			return ResponseRest.success(iProtocolRep.saveAndFlush(b), "success");
		return ResponseRest.error(null, "error");
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/getprotocols", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	private Map<String, Object> getProcotols(@PathVariable Integer apikey, @RequestParam int p,@RequestParam int r) {
		if(isessionRep.getUser_byApiKey(apikey) != null)
		{
			return ResponseRest.success(iProtocolRep.getProtocol_table(new PageRequest(p, r)), "success");
		}
			
		return ResponseRest.error(null, "error");
	}
	

}
