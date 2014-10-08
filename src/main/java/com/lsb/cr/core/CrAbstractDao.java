package com.lsb.cr.core;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * 
 * @author fan
 *
 */
public abstract class CrAbstractDao<T> {
	
	protected Log logger = LogFactory.getLog(getClass());
	
	protected static final String NL = String.format("%n");
	
	@Autowired
	@Qualifier("jdbcTemplate")
	protected JdbcTemplate jdbcTemplate;
	
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@PostConstruct
	public void init(){
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
	}
	
	public abstract Integer getCountById(T entity);
	public abstract List<T> getAll();
	public abstract T getById(T entity);
	public abstract int addNew(T entity);
	public abstract int deleteById(T entity);
	public abstract int updateById(T entity);
}
