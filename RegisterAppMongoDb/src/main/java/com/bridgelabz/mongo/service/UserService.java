/**
 * 
 */
package com.bridgelabz.mongo.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.mongo.dao.UserDAO;
import com.bridgelabz.mongo.model.User;

/**
 * purpose
 * 
 * @author Chaithra-Shenoy 
 * Date 10-07-2018
 * 
 */
@Service
public class UserService {

	@Autowired
	private UserDAO userDao;
	private TokenService tokenService;

	public Optional<User> verifyUser(User user) {
		return userDao.findById(user.getUserName());
	}

	public boolean verifyEmail(User user) {
		if (userDao.existsById(user.getEmail())) {
			return true;
		}
		return false;
	}

	
	public void save(User user) {
		userDao.insert(user);
	}
	UserService(UserDAO userDao, TokenService tokenService) {
        this.userDao = userDao;
        this.tokenService = tokenService;
    }

    public Optional<User> getUser(String id) {
        return userDao.findById(id);
    }

    public String saveUser(User user) {
        User savedUser = userDao.save(user);
        return tokenService.createToken(savedUser.getUserName());
    }
}
