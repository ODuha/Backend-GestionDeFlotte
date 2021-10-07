package com.maloc.controller;

import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import com.maloc.entity.Session;
import com.maloc.entity.User;
import com.maloc.helper.ResponseRest;
import com.maloc.repository.ISessionRepository;
import com.maloc.repository.IUserRepository;

@RestController
@Controller
@CrossOrigin(origins = "*")
public class UserCtrl {
	@Autowired
	public IUserRepository iUserRep;
	@Autowired
	public ISessionRepository isessionRep;
	
	
	@RequestMapping(value = "/bo/{apikey}/adduser", method = RequestMethod.POST)
	@ResponseBody
	//@Transactional
	private Map<String, Object> adduser(@PathVariable Integer apikey, @RequestBody User b) {
		if(isessionRep.getUser_byApiKey(apikey) != null)
			return ResponseRest.success(iUserRep.saveAndFlush(b), "success");
		return ResponseRest.error(null, "error");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	//@Transactional
	private Map<String, Object> login(@RequestBody Map<String, Object> map) {
		ResponseRest RR = new ResponseRest();
		Map<String,Object> map_to_return = new HashMap<String, Object>();
		String login = map.get("username").toString();
		String password = map.get("password").toString();
		 User u = iUserRep.login(login, password);
		if (u == null) {
			return ResponseRest.error(null, "erreur de connexion !");
			
		} else {
			Integer keyapi = getApikey(u);
			map_to_return.put("key", keyapi);
			map_to_return.put("user", u);
			isessionRep.save(new Session(keyapi, u));
			map_to_return.put("active", u.isActive());
			map_to_return.put("type_user", u.getType_user());
			return ResponseRest.success(map_to_return, "erreur de connexion !");
		}

	}

	/*@RequestMapping(value = "/isconnected", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public boolean isConnected(@RequestBody Map<String, Object> map) {
		Long id_user = (Long) map.get("id_user");
		int key = (Integer) map.get("key");
		if (iSessionRep.session_ofconnecteduser(id_user, key) == null)
			return false;
		else
			return true;
	}*/

	public static Integer getApikey(User u) {
		try {
			String apikey = "" + u.getId() + u.getLogin()
					+ new Date().getTime()
					+ (int) ((Math.random() * (1000000 - 1)) + 1);
			byte[] bytesOfMessage = apikey.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] thedigest = md.digest(bytesOfMessage);
			return thedigest.hashCode();
		} catch (Exception e) {
			return null;
		}
	}

	@RequestMapping(value = "/findalluser", method = RequestMethod.GET)
	@ResponseBody
	//@Transactional
	private List<User> findall() {
		return iUserRep.findAll();
	}

}
