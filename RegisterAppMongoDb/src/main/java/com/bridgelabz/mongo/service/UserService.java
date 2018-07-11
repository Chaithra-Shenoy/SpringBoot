/**
 * 
 */
package com.bridgelabz.mongo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.mongo.dao.UserDAO;
import com.bridgelabz.mongo.model.User;

/**
 * purpose
 * 
 * @author Chaithra-Shenoy 
 * Date 10-07-2018
 */
@Service
public class UserService {

	@Autowired
	private UserDAO userDao;
	private TokenService tokenService;

	/**
	 * to verfy valid user
	 * 
	 * @param user
	 * @return Optional
	 */
	public Optional<User> verifyUser(User user) {
		return userDao.findById(user.getUserName());
	}

	/**
	 * to verify email of the given user
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean verifyEmail(User user) {
		if (userDao.existsById(user.getEmail())) {
			return true;
		}
		return false;
	}

	/**
	 * to save into database
	 * 
	 * @param user
	 */
	public void save(User user) {
		userDao.insert(user);
	}

	UserService(UserDAO userDao, TokenService tokenService) {
		this.userDao = userDao;
		this.tokenService = tokenService;
	}

	/**
	 * to get the user details based on id passed
	 * 
	 * @param id
	 * @return Optional
	 */
	public Optional<User> getUser(String id) {
		return userDao.findById(id);
	}

	/**
	 * to generate token for valid user
	 * 
	 * @param user
	 * @return String
	 */
	public String saveUser(User user) {
		User savedUser = userDao.save(user);
		return tokenService.createToken(savedUser.getUserName());
	}
}
