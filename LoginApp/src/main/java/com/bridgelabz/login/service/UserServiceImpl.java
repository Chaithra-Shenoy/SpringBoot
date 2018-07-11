/**
 * 
 */
package com.bridgelabz.login.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.login.dao.UserDAO;
import com.bridgelabz.login.dao.UserDAOImpl;
import com.bridgelabz.login.model.User;

/**
 * purpose
 * @author Chaithra-Shenoy
 * Date
 * 
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
		UserDAO userDAO;
			
		

		/* (non-Javadoc)
		 * @see com.bridgelabz.login.service.UserService#verifyUser(com.bridgelabz.login.model.User)
		 */
	@Override
	public int verifyUser(User user) throws ClassNotFoundException, SQLException {
		User userReturn = userDAO.getUserByUserName(user.getUserName());
		if (userReturn != null) {
			if (userReturn.getPassword().equals(user.getPassword())) {
				System.out.println("pass match");
				return 1;
			} else {
				return 0;
			}
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bridgelabz.login.service.UserService#verifyEmail(com.bridgelabz.login.
	 * model.User)
	 */
	@Override
	public boolean verifyEmail(User user) throws ClassNotFoundException, SQLException {
		if (userDAO.getUserByUserEmail(user.getEmail())) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bridgelabz.login.service.UserService#saveUser(com.bridgelabz.login.model.
	 * User)
	 */
	@Override
	public void saveUser(User user) throws ClassNotFoundException, SQLException {
		userDAO.saveUser(user);

	}

}
