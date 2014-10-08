package com.lsb.cr.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class SqlStringCreator{
	public static String createInsert(Object entity,String tableName,Map<String,Object> properties){
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
					condition.append("?");
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
		return sqlBuffer.toString();
	}
	public static  String createUpdate(Object entity,String tableName,String keyName,Map<String,Object> properties){
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
					sqlBuffer.append(field.getName()+"=?");
					properties.put(field.getName(), value);
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
		return sql;
	}
}
