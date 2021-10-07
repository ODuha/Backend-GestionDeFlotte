package com.maloc.helper;

import java.util.HashMap;
import java.util.Map;

public class ResponseRest {


	public static Map<String, Object> success(Object obj,String msg){
		Map<String, Object> mapRes=new HashMap<String, Object>();
		mapRes.put("message", msg);
		mapRes.put("response", obj);
		mapRes.put("state", "success");
		return mapRes;
	}
	public static Map<String, Object> warning(Object obj,String msg){
		Map<String, Object> mapRes=new HashMap<String, Object>();
		mapRes.put("message", msg);
		mapRes.put("response", obj);
		mapRes.put("state", "warning");
		return mapRes;
	}
	public static Map<String, Object> error(Object obj,String msg){
		Map<String, Object> mapRes=new HashMap<String, Object>();
		mapRes.put("message", msg);
		mapRes.put("response", obj);
		mapRes.put("state", "error");
		return mapRes;
	}
	
}
