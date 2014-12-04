package com.lsb.cr.util;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.lsb.cr.core.CrException;

@Component
public class SqlStringCreator{
	
	public enum Type {
		insert,
		update;
	}
	
	public SqlStringCreator() {
		this.insertCache = new ConcurrentHashMap<String, String>();
		this.updateCache = new ConcurrentHashMap<String, String>();
	}
	
	private ConcurrentHashMap<String, String> insertCache;
	
	private ConcurrentHashMap<String, String> updateCache;
	
	private boolean checkCache(String key, Type type){
		switch (type) {
		case insert:
			return insertCache.containsKey(key);
		case update:
			return updateCache.containsKey(key);
		default:
			return false;
		}
	}
	
	private String getSql(String key, Type type){
		switch (type) {
		case insert:
			return insertCache.get(key);
		case update:
			return updateCache.get(key);
		default:
			//corner case
			throw new CrException("system error");
		}
	}
	
	private void putSql(String key, String sql, Type type){
		switch (type) {
		case insert:
			insertCache.put(key, sql);
			break;
		case update:
			updateCache.put(key, sql);
			break;
		default:
			//corner case
			throw new CrException("system error");
		}
	}
	
	public String createInsert(Object entity,String tableName,Map<String,Object> properties){
		
//		if (checkCache(tableName, Type.insert)) {
//			return getSql(tableName, Type.insert);
//		}
		
		Field[] fields = entity.getClass().getDeclaredFields();
		String sql ="insert into "+tableName+" (";
		StringBuffer sqlBuffer = new StringBuffer(sql);
		StringBuffer condition = new StringBuffer("values (");
		boolean begin = false;
		for(Field field:fields){	
			try {
				field.setAccessible(true);
				String name =field.getName();
				Object value = field.get(entity);
				if(value!=null){
					if(begin){
						sqlBuffer.append(",");
						condition.append(",");
					}
					sqlBuffer.append(name);
					condition.append(":"+name);
					properties.put(field.getName(), value);
					begin = true;
				}
	
				
				
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		condition.append(")");
		sqlBuffer.append(") ").append(condition);
		
//		putSql(tableName, sqlBuffer.toString(), Type.insert);
		
		return sqlBuffer.toString();
	}
	
	public  String createUpdate(Object entity,String tableName,String keyName,Map<String,Object> properties){
//		if (checkCache(tableName, Type.update)) {
//			return getSql(tableName, Type.update);
//		}
		boolean begin= false;
		String sql = "update "+tableName+" set ";
		Field[] fields  = entity.getClass().getDeclaredFields();
		StringBuffer sqlBuffer = new StringBuffer(sql);
		try {
			for(int index = 0;index<fields.length;index++){
				Field field = fields[index];
				field.setAccessible(true);
				Object value= null;
				
				if((value=field.get(entity))!=null){
					if(begin){
						sqlBuffer.append(",");
					}
					String name = field.getName();
					sqlBuffer.append(field.getName()+"=:"+name);
					properties.put(name, value);
					begin = true;
				}
			}
			//set "where" condition
			sqlBuffer.append(" where ").append(keyName).append("=?");
			sql = sqlBuffer.toString();
			Field keyField = entity.getClass().getDeclaredField(keyName);
			keyField.setAccessible(true);
			properties.put(keyName,keyField.get(entity));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
//		putSql(tableName, sqlBuffer.toString(), Type.update);
		
		return sql;
	}
}
