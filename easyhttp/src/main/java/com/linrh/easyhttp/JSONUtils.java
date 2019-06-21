package com.linrh.easyhttp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class JSONUtils {
	public static String beanToJsonStringUseGson(Object obj){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(obj);
	}
	
	public static<T> T jsonStringToBeanUseGson(String json, Type type)
	{
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.fromJson(json, type);
	}
}
