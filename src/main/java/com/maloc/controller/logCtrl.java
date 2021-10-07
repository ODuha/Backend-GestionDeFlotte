package com.maloc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maloc.helper.ResponseRest;
import com.maloc.repository.ISessionRepository;
import com.mongodb.*;
@RestController
@Controller
@CrossOrigin(origins = "*")
public class logCtrl {

	@Autowired
	public ISessionRepository isessionRep;

	public static Connection con = null;
	
	/*
	@RequestMapping(value = "/bo/{apikey}/log", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	private Map<String, Object> log(@PathVariable Integer apikey,@RequestParam long imei,@RequestParam Long date_s,@RequestParam Long date_e) throws IOException {
		if(isessionRep.getUser_byApiKey(apikey) != null)
		{
			List<Map<String , Object >> maps = new ArrayList();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("start date : "+sdf.format(new Date(date_s)));
			System.out.println("end date : "+sdf.format(new Date(date_e)));
			System.out.println("imei : "+imei);
			Properties prop = new Properties();
			InputStream inputStream = FileHelper.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(inputStream);
			String location=prop.getProperty("log.location");
			String file_name = "tracker-server.log";
			if(date_s == date_e)
			{
				String sCurrentLine;
				
				if(sdf.format(new Date()).equals(sdf.format(new Date(date_e))))
					{
					try (BufferedReader br = new BufferedReader(new FileReader(location+file_name))) {
						while ((sCurrentLine = br.readLine()) != null) {
							try {
								if(sCurrentLine.contains("dataOF"+imei))
								{
									Map<String , Object > map = new HashMap<String, Object>();
									
									String result = sCurrentLine.split(Pattern.quote("#"))[1];
									result = result.split(Pattern.quote("{"))[1];
									result = result.split(Pattern.quote("}"))[0];
									String[] list_s = result.split(Pattern.quote(","));
									for(String s : list_s)
									{
										map.put(s.split(Pattern.quote("="))[0], s.split(Pattern.quote("="))[1]);
									}
									maps.add(map);
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
						
					}
				else
				{
					SimpleDateFormat sdf_2 = new SimpleDateFormat("YYYYMMdd");
					file_name +="."+sdf_2.format(new Date(date_e));
					try (BufferedReader br = new BufferedReader(new FileReader(location+file_name))) {
						while ((sCurrentLine = br.readLine()) != null) {
							try {
								if(sCurrentLine.contains("dataOF"+imei))
								{
									Map<String , Object > map = new HashMap<String, Object>();
									
									String result = sCurrentLine.split(Pattern.quote("#"))[1];
									result = result.split(Pattern.quote("{"))[1];
									result = result.split(Pattern.quote("}"))[0];
									String[] list_s = result.split(Pattern.quote(","));
									for(String s : list_s)
									{
										map.put(s.split(Pattern.quote("="))[0], s.split(Pattern.quote("="))[1]);
									}
									maps.add(map);
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
				}
			}
			else
			{
			List<Date> dates_range = getDatesBetweenUsingJava7(new Date(date_s), new Date(date_e));
			for(Date d : dates_range)
			{
				String sCurrentLine;
				if(sdf.format(new Date()).equals(sdf.format(d)))
					{
					try (BufferedReader br = new BufferedReader(new FileReader(location+file_name))) {
						while ((sCurrentLine = br.readLine()) != null) {
							try {
								if(sCurrentLine.contains("dataOF"+imei))
								{
									Map<String , Object > map = new HashMap<String, Object>();
									
									String result = sCurrentLine.split(Pattern.quote("#"))[1];
									result = result.split(Pattern.quote("{"))[1];
									result = result.split(Pattern.quote("}"))[0];
									String[] list_s = result.split(Pattern.quote(","));
									for(String s : list_s)
									{
										map.put(s.split(Pattern.quote("="))[0], s.split(Pattern.quote("="))[1]);
									}
									maps.add(map);
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
						
					}
				else
				{
					SimpleDateFormat sdf_2 = new SimpleDateFormat("YYYYMMdd");
					
					String file_name_2 = file_name+"."+sdf_2.format(d);
					try (BufferedReader br = new BufferedReader(new FileReader(location+file_name_2))) {
						while ((sCurrentLine = br.readLine()) != null) {
							try {
								if(sCurrentLine.contains("dataOF"+imei))
								{
									Map<String , Object > map = new HashMap<String, Object>();
									
									String result = sCurrentLine.split(Pattern.quote("#"))[1];
									result = result.split(Pattern.quote("{"))[1];
									result = result.split(Pattern.quote("}"))[0];
									String[] list_s = result.split(Pattern.quote(","));
									for(String s : list_s)
									{
										map.put(s.split(Pattern.quote("="))[0], s.split(Pattern.quote("="))[1]);
									}
									maps.add(map);
								}
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}
				}
				System.out.println(sdf.format(d));
			}
			}
			System.out.println("file location : "+location);
			return ResponseRest.success(maps, "success");
		}
		return ResponseRest.error(null, "error");
	}
*/	
	@RequestMapping(value = "/bo/{apikey}/log", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	private Map<String, Object> log(@PathVariable Integer apikey,@RequestParam long imei,@RequestParam Long date_s,@RequestParam Long date_e) throws IOException {
		long time_start=System.currentTimeMillis();
		if(isessionRep.getUser_byApiKey(apikey) != null)
		{
			List<Map<String , Object >> maps = new ArrayList();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("start date : "+sdf.format(new Date(date_s)));
			System.out.println("end date : "+sdf.format(new Date(date_e)));
			System.out.println("imei : "+imei);
			MongoCredential credential = MongoCredential.createCredential("root", "admin", "".toCharArray());
			MongoClient mongoClient = new MongoClient( new ServerAddress("localhost" , 27017),Arrays.asList(credential) ); // should use this always
			DB db = mongoClient.getDB("ems_maloc1");
			Set<String> collections = db.getCollectionNames();
			System.out.println(collections);
			DBCollection collection = db.getCollection("device_log");
			String qu = "{'server_time':{$gte:new ISODate('"+sdf.format(new Date(date_s))+"T00:00:00.000Z') , $lte:new ISODate('"+sdf.format(new Date(date_e))+"T23:59:59.000Z')},'imei':'"+imei+"'}";
			System.out.println(qu);
			BasicDBObject query = BasicDBObject.parse("{'server_time':{$gte:new ISODate('"+sdf.format(new Date(date_s))+"T00:00:00.000Z') , $lte:new ISODate('"+sdf.format(new Date(date_e))+"T23:59:59.000Z')},'imei':'"+imei+"'}"); 
			long time_t = System.currentTimeMillis();
			DBCursor c =	collection.find(query);
			List<DBObject> dbos = c.toArray();
			maps = (List<Map<String, Object>>) (List<?>) dbos;
			System.out.println("fin de traitement a :" +(System.currentTimeMillis()-time_start));
			
			
			return ResponseRest.success(maps, "success");
		}
		return ResponseRest.error(null, "error");
	}
public static List<Date> getDatesBetweenUsingJava7(
			  Date startDate, Date endDate) {
			    List<Date> datesInRange = new ArrayList();
			    Calendar calendar = new GregorianCalendar();
			    calendar.setTime(startDate);
			     
			    Calendar endCalendar = new GregorianCalendar();
			    endCalendar.setTime(endDate);
			 
			    while (calendar.before(endCalendar)) {
			        Date result = calendar.getTime();
			        datesInRange.add(result);
			        calendar.add(Calendar.DATE, 1);
			    }
			    datesInRange.add(endDate);
			    return datesInRange;
			}
}
