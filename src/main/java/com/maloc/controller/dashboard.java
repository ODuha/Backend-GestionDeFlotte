package com.maloc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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

import com.maloc.entity.User;
import com.maloc.helper.ResponseRest;
import com.maloc.model.devices_infos;
import com.maloc.repository.ISessionRepository;

@RestController
@Controller
@CrossOrigin(origins = "*")
public class dashboard {

	@Autowired
	public ISessionRepository isessionRep;

	public static Connection con = null;

	@RequestMapping(value = "/bo/{apikey}/osinfos", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	private Map<String, Object> osinfos(@PathVariable Integer apikey) {
		if (isessionRep.getUser_byApiKey(apikey) != null) {
			Process p;
			BufferedReader in;
			String line;
			Map<String, Object> map = new HashMap<String, Object>();
			Long id_p_maloc_api = null;
			Long id_p_engine = null;
			Long id_p_job = null;
			Long FIN_WAIT1 = (long)0;
			Long FIN_WAIT2 = (long)0;
			Long CLOSE_WAIT = (long)0;
			Long LISTEN = (long)0;
			Long Foreign = (long)0;
			Long LAST_ACK = (long)0;
			Long ESTABLISHED = (long)0;
			Long TIME_WAIT = (long)0;
			Long established=(long)0;
			Long SYN_RECV=(long)0;
			try {
				p = Runtime
						.getRuntime()
						.exec(new String[] { "/bin/sh", "-c",
								"ps -x | netstat -ant | awk '{print $6}' | sort | uniq -c | sort -n" });

				in = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				line = null;
				while ((line = in.readLine()) != null) {
					line = line.replace(" ", "");
					if(line.contains("Foreign"))
					{
						Foreign = Long.parseLong(line.split(Pattern
								.quote("Foreign"))[0]);
					}
					else if(line.contains("FIN_WAIT1"))
					{
						FIN_WAIT1 = Long.parseLong(line.split(Pattern
								.quote("FIN_WAIT1"))[0]);
					}
					else if(line.contains("LISTEN"))
					{
						LISTEN = Long.parseLong(line.split(Pattern
								.quote("LISTEN"))[0]);
					}
					else if(line.contains("established"))
					{
						established = Long.parseLong(line.split(Pattern
								.quote("established"))[0]);
					}
					else if(line.contains("LAST_ACK"))
					{
						LAST_ACK = Long.parseLong(line.split(Pattern
								.quote("LAST_ACK"))[0]);
					}
					else if(line.contains("SYN_RECV"))
					{
						SYN_RECV = Long.parseLong(line.split(Pattern
								.quote("SYN_RECV"))[0]);
					}
					else if(line.contains("TIME_WAIT"))
					{
						TIME_WAIT = Long.parseLong(line.split(Pattern
								.quote("TIME_WAIT"))[0]);
					}
					else if(line.contains("ESTABLISHED"))
					{
						ESTABLISHED = Long.parseLong(line.split(Pattern
								.quote("ESTABLISHED"))[0]);
					}
					else if(line.contains("CLOSE_WAIT"))
					{
						CLOSE_WAIT = Long.parseLong(line.split(Pattern
								.quote("CLOSE_WAIT"))[0]);
					}
					else if(line.contains("FIN_WAIT2"))
					{
						FIN_WAIT2 = Long.parseLong(line.split(Pattern
								.quote("FIN_WAIT2"))[0]);
						
					}

				}
			} catch (IOException ex) {

			}
			map.put("FIN_WAIT2", FIN_WAIT2);
			map.put("CLOSE_WAIT", CLOSE_WAIT);
			map.put("ESTABLISHED", ESTABLISHED);
			map.put("SYN_RECV", SYN_RECV);
			map.put("LAST_ACK", LAST_ACK);
			map.put("TIME_WAIT", TIME_WAIT);
			map.put("established", established);
			map.put("LISTEN", LISTEN);
			map.put("Foreign", Foreign);
			map.put("FIN_WAIT1", FIN_WAIT1);
			
			

			try {
				p = Runtime.getRuntime().exec(
						new String[] { "/bin/sh", "-c",
								"ps -x | grep /home/work/maloc_api/dist.jar" });

				in = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				line = null;
				while ((line = in.readLine()) != null) {
					if (line.contains("java -jar /home/work/maloc_api/dist.jar")) {

						try {
							id_p_maloc_api = Long.parseLong(line.split(Pattern
									.quote("?"))[0].replace(" ", ""));
						} catch (Exception ex) {
							id_p_maloc_api = Long.parseLong(line.split(Pattern
									.quote("pts"))[0].replace(" ", ""));
						}
						System.out.println(id_p_maloc_api);
					}
				}
			} catch (IOException ex) {

			}
			try {
				p = Runtime
						.getRuntime()
						.exec(new String[] { "/bin/sh", "-c",
								"ps -x | grep /home/work/new_engine/nabil/NEW_ENGINE.jar" });

				in = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				line = null;
				while ((line = in.readLine()) != null) {
					if (line.contains("java -jar /home/work/new_engine/nabil/NEW_ENGINE.jar")) {
						try {
							id_p_engine = Long.parseLong(line.split(Pattern
									.quote("?"))[0].replace(" ", ""));
						} catch (Exception ex) {
							id_p_engine = Long.parseLong(line.split(Pattern
									.quote("pts"))[0].replace(" ", ""));
						}
						System.out.println(id_p_engine);
					}
				}
			} catch (IOException ex) {

			}
			try {
				p = Runtime.getRuntime().exec(
						new String[] { "/bin/sh", "-c",
								"ps -x | grep /home/work/job/maloc_job.jar" });

				in = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				line = null;
				while ((line = in.readLine()) != null) {
					if (line.contains("java -jar /home/work/job/maloc_job.jar")) {
						try {
							id_p_job = Long.parseLong(line.split(Pattern
									.quote("?"))[0].replace(" ", ""));
						} catch (Exception ex) {
							id_p_job = Long.parseLong(line.split(Pattern
									.quote("pts"))[0].replace(" ", ""));
						}
					}
				}
			} catch (IOException ex) {

			}
			if (id_p_maloc_api != null) {

				try {
					p = Runtime.getRuntime().exec(
							new String[] { "/bin/sh", "-c",
									"ps -o thcount " + id_p_maloc_api });

					in = new BufferedReader(new InputStreamReader(
							p.getInputStream()));
					line = null;
					while ((line = in.readLine()) != null) {
						if (!line.contains("THCNT"))
							map.put("maloc_api_count",
									Integer.parseInt(line.replace(" ", "")));
					}
				} catch (IOException ex) {

				}

				map.put("maloc_api_etat", true);
			} else {

				map.put("maloc_api_etat", false);
			}
			if (id_p_engine != null) {

				try {
					p = Runtime.getRuntime().exec(
							new String[] { "/bin/sh", "-c",
									"ps -o thcount " + id_p_engine });

					in = new BufferedReader(new InputStreamReader(
							p.getInputStream()));
					line = null;
					while ((line = in.readLine()) != null) {
						if (!line.contains("THCNT"))
							map.put("maloc_engine_count",
									Integer.parseInt(line.replace(" ", "")));
					}
				} catch (IOException ex) {

				}

				map.put("maloc_engine_etat", true);
			} else {

				map.put("maloc_engine_etat", false);
			}
			if (id_p_job != null) {

				try {
					p = Runtime.getRuntime().exec(
							new String[] { "/bin/sh", "-c",
									"ps -o thcount " + id_p_job });

					in = new BufferedReader(new InputStreamReader(
							p.getInputStream()));
					line = null;
					while ((line = in.readLine()) != null) {
						if (!line.contains("THCNT"))
							map.put("maloc_job_count",
									Integer.parseInt(line.replace(" ", "")));
					}
				} catch (IOException ex) {

				}

				map.put("maloc_job_etat", true);
			} else {
				map.put("maloc_job_etat", false);
			}

			return ResponseRest.success(map, "success");
		}
		return ResponseRest.error(null, "error");
	}

	@RequestMapping(value = "/bo/{apikey}/infosboitier", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	private Map<String, Object> infosboitier(@PathVariable Integer apikey) {
		if (isessionRep.getUser_byApiKey(apikey) != null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = (Connection) DriverManager
						.getConnection(
								"jdbc:mysql://localhost:3306/ems_maloc1?useSSL=false",
								"root", "");
				Statement stmt = (Statement) con.createStatement();
				ResultSet rs = (ResultSet) stmt
						.executeQuery("select v.id,v.internal_code , v.id_etat , d.imei , dp.name , dt.name , a.name , d.sim ,d.date_server ,vd.end_date "
								+ ", (select count(*) from vehicle where id_account=v.id_account and to_delete=0) as 'nombre_vehicle' , vd.start_date , d.no_yellow "
								+ " from vehicle v "
								+ "INNER JOIN account a ON v.id_account = a.id "
								+ "INNER JOIN vehicle_device vd ON v.id = vd.id_vehicle "
								+ "INNER JOIN device d ON d.id = vd.id_device "
								+ "INNER JOIN device_type dt ON dt.id = d.id_device_type "
								+ "INNER JOIN device_protocol dp ON dp.id = d.id_device_protocol "
								+ " where v.to_delete=0");
				int nbr_devices = 0;
				int nbr_bloqued_devices = 0;
				int nbr_desabonned_devices = 0;
				int nbr_operationnel_devices = 0;
				long d = new Date().getTime();

				List<devices_infos> devices_infos_l = new ArrayList<devices_infos>();
				while (rs.next()) {
					nbr_devices++;
					long id_vehicle = rs.getLong("v.id");
					String internal_code = rs.getString("v.internal_code");
					long id_etat = rs.getLong("v.id_etat");
					long imei = rs.getLong("d.imei");
					String name = rs.getString("a.name");
					long sim = rs.getLong("d.sim");
					Date date_server = rs.getTimestamp("d.date_server");
					Date end_date = rs.getDate("vd.end_date");
					Date start_date = rs.getDate("vd.start_date");
					int nbr_vehicle = rs.getInt("nombre_vehicle");
					String protocol_name = rs.getString("dp.name");
					String type_name = rs.getString("dt.name");

					if (end_date.getTime() < d)
						nbr_desabonned_devices++;
					else if (date_server == null
							|| (date_server.getTime() + 3600000) < d)
						nbr_bloqued_devices++;
					else
						nbr_operationnel_devices++;
					devices_infos di = new devices_infos(id_vehicle,
							internal_code, id_etat, imei, name, sim,
							date_server, end_date, start_date, nbr_vehicle,
							protocol_name, type_name);
					di.setNo_yellow(rs.getBoolean("d.no_yellow"));
					devices_infos_l.add(di);
				}
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("devices", devices_infos_l);
				map.put("bloqued", nbr_bloqued_devices);
				map.put("total", nbr_devices);
				map.put("operationnel", nbr_operationnel_devices);
				map.put("desabonned", nbr_desabonned_devices);
				return ResponseRest.success(map, "success");
			} catch (Exception ee) {
				return ResponseRest.error(null, "error");
			}
		}
		return ResponseRest.error(null, "error");
	}

	@RequestMapping(value = "/bo/{apikey}/stop_maloc_api", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	private Map<String, Object> stop_maloc_api(@PathVariable Integer apikey) {
		if (isessionRep.getUser_byApiKey(apikey) != null) {
			try {
				Map<String, Object> map = new HashMap<String, Object>();
				Process p;
				BufferedReader in;
				String line;
				p = Runtime
						.getRuntime()
						.exec(new String[] { "/bin/sh", "-c",
								"cd /home/work/maloc_api/ ; sh stop_maloc_api.sh" });

				in = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				line = null;
				while ((line = in.readLine()) != null) {
				}
				return ResponseRest.success(map, "success");
			} catch (Exception ee) {
				return ResponseRest.error(null, "error");
			}
		}
		return ResponseRest.error(null, "error");
	}

	@RequestMapping(value = "/bo/{apikey}/start_maloc_api", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	private Map<String, Object> start_maloc_api(@PathVariable Integer apikey) {
		if (isessionRep.getUser_byApiKey(apikey) != null) {
			try {
				Map<String, Object> map = new HashMap<String, Object>();
				Process p;
				BufferedReader in;
				String line;
				p = Runtime
						.getRuntime()
						.exec(new String[] { "/bin/sh", "-c",
								"cd /home/work/maloc_api/ ; sh start_maloc_api.sh" });

				in = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				line = null;
				while ((line = in.readLine()) != null) {
				}
				return ResponseRest.success(map, "success");
			} catch (Exception ee) {
				return ResponseRest.error(null, "error");
			}
		}
		return ResponseRest.error(null, "error");
	}

	@RequestMapping(value = "/bo/{apikey}/stop_maloc_job", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	private Map<String, Object> stop_maloc_job(@PathVariable Integer apikey) {
		if (isessionRep.getUser_byApiKey(apikey) != null) {
			try {
				Map<String, Object> map = new HashMap<String, Object>();
				Process p;
				BufferedReader in;
				String line;
				p = Runtime.getRuntime().exec(
						new String[] { "/bin/sh", "-c",
								"cd /home/work/job/ ; sh stop_maloc_job.sh" });

				in = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				line = null;
				while ((line = in.readLine()) != null) {
				}
				return ResponseRest.success(map, "success");
			} catch (Exception ee) {
				return ResponseRest.error(null, "error");
			}
		}
		return ResponseRest.error(null, "error");
	}

	@RequestMapping(value = "/bo/{apikey}/start_maloc_job", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	private Map<String, Object> start_maloc_job(@PathVariable Integer apikey) {
		if (isessionRep.getUser_byApiKey(apikey) != null) {
			try {
				Map<String, Object> map = new HashMap<String, Object>();
				Process p;
				BufferedReader in;
				String line;
				p = Runtime.getRuntime().exec(
						new String[] { "/bin/sh", "-c",
								"cd /home/work/job/ ; sh start_maloc_job.sh" });

				in = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				line = null;
				while ((line = in.readLine()) != null) {
				}
				return ResponseRest.success(map, "success");
			} catch (Exception ee) {
				return ResponseRest.error(null, "error");
			}
		}
		return ResponseRest.error(null, "error");
	}

	@RequestMapping(value = "/bo/{apikey}/stop_maloc_engine", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	private Map<String, Object> stop_maloc_engine(@PathVariable Integer apikey) {
		if (isessionRep.getUser_byApiKey(apikey) != null) {
			try {
				Map<String, Object> map = new HashMap<String, Object>();
				Process p;
				BufferedReader in;
				String line;
				p = Runtime
						.getRuntime()
						.exec(new String[] { "/bin/sh", "-c",
								"cd /home/work/new_engine/nabil/ ; sh stop_new_maloc_engine.sh" });

				in = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				line = null;
				while ((line = in.readLine()) != null) {
				}
				return ResponseRest.success(map, "success");
			} catch (Exception ee) {
				return ResponseRest.error(null, "error");
			}
		}
		return ResponseRest.error(null, "error");
	}

	@RequestMapping(value = "/bo/{apikey}/start_maloc_engine", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	private Map<String, Object> start_maloc_engine(@PathVariable Integer apikey) {
		if (isessionRep.getUser_byApiKey(apikey) != null) {
			try {
				Map<String, Object> map = new HashMap<String, Object>();
				Process p;
				BufferedReader in;
				String line;
				p = Runtime
						.getRuntime()
						.exec(new String[] { "/bin/sh", "-c",
								"cd /home/work/new_engine/nabil/ ; sh start_new_maloc_engine.sh" });

				in = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				line = null;
				while ((line = in.readLine()) != null) {
				}
				return ResponseRest.success(map, "success");
			} catch (Exception ee) {
				return ResponseRest.error(null, "error");
			}
		}
		return ResponseRest.error(null, "error");
	}
	
	@RequestMapping(value = "/bo/{apikey}/stop_tcpip", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	private Map<String, Object> stop_TCPIP(@PathVariable Integer apikey,@RequestBody String type) {
		if (isessionRep.getUser_byApiKey(apikey) != null) {
			try {
				Map<String, Object> map = new HashMap<String, Object>();
				Process p;
				BufferedReader in;
				String line;
				System.out.println(type);
				System.out.println("cmd : ss --tcp state "+type+" sport gt 5000 sport le 5193 --kill");
				p = Runtime
						.getRuntime()
						.exec(new String[] { "/bin/sh", "-c",
								"ss --tcp state "+type+" sport gt 5000 sport le 5193 --kill" });

				in = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				line = null;
				while ((line = in.readLine()) != null) {
					System.out.println(line);
				}
				return ResponseRest.success(map, "success");
			} catch (Exception ee) {
				return ResponseRest.error(null, "error");
			}
		}
		return ResponseRest.error(null, "error");
	}
}
