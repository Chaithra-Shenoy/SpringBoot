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
	/**
	 * to get the connecion
	 * @return Connection
	 * @throws ClassNotFoundException
	 */
	public Connection getConnection() throws ClassNotFoundException;

	/**
	 * to close the connection
	 * @param resultSet
	 * @param preparedStatement
	 * @param connection
	 */
	public void closeConnection(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection);

	/**
	 * to get user by name
	 * @param uname
	 * @return User
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public User getUserByUserName(String uname) throws ClassNotFoundException, SQLException;

	/**
	 * to save user
	 * @param user
	 * @return boolean
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean saveUser(User user) throws SQLException, ClassNotFoundException;

	/**
	 * to get user by passing email
	 * @param email
	 * @return boolean
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean getUserByUserEmail(String email) throws SQLException, ClassNotFoundException;
}
