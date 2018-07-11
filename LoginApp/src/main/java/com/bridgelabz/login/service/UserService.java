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
	public int verifyUser(User user) throws ClassNotFoundException, SQLException;
	public  boolean verifyEmail(User user) throws ClassNotFoundException, SQLException;
	public void saveUser(User user) throws ClassNotFoundException, SQLException;
}
