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
		String query = "select * from user where userId = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { userId }, new RowMapper<User>() {
			public User mapRow(ResultSet result, int rowNum) throws SQLException {
				User user = new User();
				user.setUserId(result.getString("userId"));
				user.setUserName(result.getString("userName"));
				user.setUserRole(result.getString("userRole"));
				user.setUserEmail(result.getString("userEmail"));
				user.setUserContact(result.getString("userContact"));
				return user;
			}
		});
	}

}
