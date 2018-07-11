/**
 * 
 */
package com.bridgelabz.login.service;

import java.sql.SQLException;

import com.bridgelabz.login.model.User;

/**
 * purpose
 * @author Chaithra-Shenoy
 * Date
 * 
 */
public interface UserService {
	/**
	 * to verify the valid user
	 * @param user
	 * @return integer
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int verifyUser(User user) throws ClassNotFoundException, SQLException;
	/**
	 * to verify user email
	 * @param user
	 * @returnboolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public  boolean verifyEmail(User user) throws ClassNotFoundException, SQLException;
	/**
	 * to save user
	 * @param user
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void saveUser(User user) throws ClassNotFoundException, SQLException;
}
