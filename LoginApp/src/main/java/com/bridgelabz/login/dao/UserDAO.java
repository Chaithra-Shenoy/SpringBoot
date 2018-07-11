/**
 * 
 */
package com.bridgelabz.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.login.model.User;

/**
 * purpose
 * 
 * @author Chaithra-Shenoy Date
 * 
 */
public interface UserDAO {
	public Connection getConnection() throws ClassNotFoundException;

	public void closeConnection(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection);

	public User getUserByUserName(String uname) throws ClassNotFoundException, SQLException;

	public boolean saveUser(User user) throws SQLException, ClassNotFoundException;

	public boolean getUserByUserEmail(String email) throws SQLException, ClassNotFoundException;
}
