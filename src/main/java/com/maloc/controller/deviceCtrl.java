package com.maloc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
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

import com.maloc.helper.ResponseRest;
import com.maloc.model.devices_infos;
import com.maloc.repository.ISessionRepository;
import java.sql.*;

@RestController
@Controller
@CrossOrigin(origins = "*")
public class deviceCtrl {

	@Autowired
	public ISessionRepository isessionRep;

	public static Connection con = null;
	
	@RequestMapping(value = "/bo/{apikey}/deletedevice", method = RequestMethod.DELETE)
	@ResponseBody
	@Transactional
	private Map<String, Object> deletedevice(@PathVariable Integer apikey,@RequestParam long id_vehicle) {
		if(isessionRep.getUser_byApiKey(apikey) != null)
		{
			try {
			con = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/ems_maloc1?useSSL=false",
							"root", "");
			Statement stmt = (Statement) con.createStatement();;
			int d = stmt.executeUpdate("update vehicle set to_delete=1 where id="+id_vehicle+";");
			return ResponseRest.success(true, "succes");
			} catch (SQLException e) {
				return ResponseRest.error(null, "error");
				
			}
		}
		return ResponseRest.error(null, "error");
	}
	@RequestMapping(value = "/bo/{apikey}/updatedevicesim", method = RequestMethod.PUT)
	@ResponseBody
	@Transactional
	private Map<String, Object> updatedevicesim(@PathVariable Integer apikey,@RequestBody devices_infos device_info) {
		if(isessionRep.getUser_byApiKey(apikey) != null)
		{
			System.out.println(device_info.isNo_yellow());
			try {
			con = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/ems_maloc1?useSSL=false",
							"root", "");
			Statement stmt = (Statement) con.createStatement();;
			int d = stmt.executeUpdate("update device set sim='"+device_info.getSim()+"' , no_yellow='"+(device_info.isNo_yellow()?1:0)+"' where imei='"+device_info.getImei()+"';");
			System.out.println("update device set sim='"+device_info.getSim()+"' where imei='"+device_info.getImei()+"';");
			return ResponseRest.success(true, "succes");
			} catch (SQLException e) {
				e.printStackTrace();
				return ResponseRest.error(null, "error");
				
			}
		}
		return ResponseRest.error(null, "error");
	}
}
