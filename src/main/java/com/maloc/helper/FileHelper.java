package com.maloc.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public final class FileHelper {
	public static int createJsonFile(String fileName, Object obj){
		String path;
		try {
			
			InputStream inputStream = FileHelper.class.getClassLoader().getResourceAsStream("config.properties"); //new ClassPathResource("config.properties").getFile().getPath()
			
			
			ObjectMapper mapper = new ObjectMapper();
			String json = "";
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
			// pretty print
			//System.out.println(json);
			//path = new ClassPathResource("static").getFile().getPath();
			path=createFolder();
			if(path==null){
				return 4;
			}
			//System.out.println(path);
			FileOutputStream out = new FileOutputStream(path+fileName+".json");
			out.write(json.getBytes(StandardCharsets.UTF_8));
			out.close();
			return 0;
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			return 1;
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return 2;
		} catch (IOException e) {
			e.printStackTrace();
			return 3;
		}
	}
	public static Map<Object, Object> getJsonFromFile(String fileName){
		String path;
		Map<Object, Object> json = new HashMap<Object, Object>();
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			//path = new ClassPathResource("static").getFile().getPath();
			path=createFolder();
			if(path==null){
				json.put("error", "path null");
				return json;
			}
			json = (Map<Object, Object>) mapper.readValue(new File(path+fileName+".json"), Object.class);
			//System.out.println(json);
			
			return json;
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			json.put("error", e.getMessage());
			return json;
		} catch (JsonMappingException e) {
			e.printStackTrace();
			json.put("error", e.getMessage());
			return json;
		} catch (IOException e) {
			e.printStackTrace();
			json.put("error", e.getMessage());
			return json;
		}
	}
	public static ResponseEntity<byte[]> getPdfFile(String fileName){
		String path;
		try {
			path=createFolder();
			if(path==null){
				return null;
			}
			Path pdfPath = Paths.get(path+"report_"+fileName+"_pdf.pdf");
			byte[] output = Files.readAllBytes(pdfPath);
		    HttpHeaders responseHeaders = new HttpHeaders();
		    responseHeaders.set("charset", "utf-8");
		    responseHeaders.setContentType(MediaType.valueOf("application/pdf"));
		    responseHeaders.setContentLength(output.length);
		    responseHeaders.set("Content-disposition", "attachment; filename="+fileName+".pdf");

		    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ResponseEntity<byte[]> getExcelFile(String fileName){
		String path;
		try {
			path=createFolder();
			if(path==null){
				return null;
			}
			Path pdfPath = Paths.get(path+"report_"+fileName+"_excel.xls");
			byte[] output = Files.readAllBytes(pdfPath);
		    HttpHeaders responseHeaders = new HttpHeaders();
		    responseHeaders.set("charset", "utf-8");
		    responseHeaders.setContentType(MediaType.valueOf("application/vnd.ms-excel"));
		    responseHeaders.setContentLength(output.length);
		    responseHeaders.set("Content-disposition", "attachment; filename="+fileName+".xls");

		    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static String createFolder(){
		String folderName=null;
		Properties prop = new Properties();
		InputStream inputStream = FileHelper.class.getClassLoader().getResourceAsStream("config.properties"); //new ClassPathResource("config.properties").getFile().getPath()
		
		if(inputStream != null){
			try {
				prop.load(inputStream);
				folderName=prop.getProperty("files.reporting");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		File directory = new File(String.valueOf(folderName));
		
	    if (! directory.exists()){
	        directory.mkdir();
	    }
	    return folderName;
	}
	public static String getPropertie(String propName){
		String propertie=null;
		Properties prop = new Properties();
		InputStream inputStream = FileHelper.class.getClassLoader().getResourceAsStream("config.properties");
		if(inputStream != null){
			try {
				prop.load(inputStream);
				propertie=prop.getProperty(propName);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
	    return propertie;
	}
	
	public static boolean delateFile(String fileName){
		Properties prop = new Properties();
		try{
			InputStream inputStream = FileHelper.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(inputStream);
			String folderName=prop.getProperty("files.reporting");
    		File file = new File(folderName+fileName);

    		if(file.delete()){
    			return true;
    		}else{
    			return false;
    		}

    	}catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
	}
}
