package com.udemy.firma.repository.impl;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.udemy.firma.bean.Firma;
import com.udemy.firma.repository.FirmaRepository;
@Repository
public class FirmaRepositoryImpl  implements FirmaRepository{

	  @Autowired
	  private JdbcTemplate jdbcTemplate;
	  
	  

	  
	  @Override
	  public int save(Firma firma) {
		  
	       String sql = "INSERT INTO USERPKS (NAME, PASSWORD, KEYDATA) VALUES(?,?,?)";
	    
	      return jdbcTemplate.update(new PreparedStatementCreator() {
	          @Override
	          public PreparedStatement createPreparedStatement(Connection connection)
	                  throws SQLException {
	              PreparedStatement ps = connection.prepareStatement(sql.toString(),
	                      Statement.RETURN_GENERATED_KEYS);
	              ps.setString(1, firma.getName());
	              ps.setString(2, firma.getPassword());              
	              ByteArrayInputStream inputStream = new ByteArrayInputStream(firma.getKeydata()); 
	              ps.setBlob(3, inputStream);
	              return ps;
	          }
	      });
	     
	     
	  
	  }

	  
	  @Override
	  public Firma findById(Long id) {
		   
	     try {
	    	Firma tutorial = jdbcTemplate.queryForObject("SELECT * FROM USERPKS ",
	          BeanPropertyRowMapper.newInstance(Firma.class));

	      return tutorial;
	    } catch (IncorrectResultSizeDataAccessException e) {
	      return null;
	    } 
	  }

	  @Override
	  public int deleteById(Long id) {
	    return jdbcTemplate.update("DELETE FROM tutorials WHERE id=?", id);
	  }


}
