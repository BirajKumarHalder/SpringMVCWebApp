package com.tutorials.repositories;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class AuthRepo {

	@Autowired
	private DataSource dataSource;

	public boolean validateCredentials(String userId, String password) {
		String query = "select active from auth where user_id = :userId and password = :password";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("userId", userId).addValue("password",
				password);
		return namedParameterJdbcTemplate.queryForObject(query, namedParameters, Boolean.class);
	}

}
