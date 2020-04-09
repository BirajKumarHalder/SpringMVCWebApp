package com.tutorials.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tutorials.models.User;

@Repository
public class UserRepo {

	@Autowired
	private DataSource dataSource;

	public User retrieveUserDetails(String userId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "select * from user where user_id = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { userId }, new RowMapper<User>() {
			public User mapRow(ResultSet result, int rowNum) throws SQLException {
				User user = new User();
				user.setUserId(result.getString("user_id"));
				user.setUserName(result.getString("user_name"));
				user.setUserRole(result.getString("user_role"));
				user.setUserEmail(result.getString("user_email"));
				user.setUserContact(result.getString("user_contact"));
				return user;
			}
		});
	}

}
