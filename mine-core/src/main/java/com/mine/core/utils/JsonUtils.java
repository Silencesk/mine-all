package com.mine.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class JsonUtils {
	
	private JsonUtils(){
		
	}
	
	protected  static Logger logger = LoggerFactory.getLogger(JsonUtils.class);
	
	public static String getValueByKey(String key,String retVal){
		try{
			return JSON.parseObject(retVal).get(key).toString();
		}catch (NullPointerException e) {
			//logger.error("", e);
			return "";
		}
	}

}
