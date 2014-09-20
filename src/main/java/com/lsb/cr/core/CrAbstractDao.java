package com.lsb.cr.core;

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
public abstract class CrAbstractDao {
	
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
}
