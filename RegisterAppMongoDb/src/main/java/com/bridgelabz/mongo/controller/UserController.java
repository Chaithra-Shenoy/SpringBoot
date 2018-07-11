/**
 * 
 */
package com.bridgelabz.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.mongo.model.User;
import com.bridgelabz.mongo.service.UserService;

/**
 * purpose
 * 
 * @author Chaithra-Shenoy 
 * Date 10-07-2018
 * 
 */
@RestController
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * to login 
	 * @param user
	 * @return String
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestBody User user) {
		if (!userService.verifyUser(user).get().equals(null)) {
			return userService.saveUser(user) + " Welcome " + user.getUserName();
		}
		return "Username doesnt not exist";
	}

	/**
	 * to register new user
	 * @param user
	 * @return String
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@RequestBody User user) {
		if (!userService.verifyEmail(user)) {
			return userService.saveUser(user) + " User Details" + user.toString();

		} else
			return "Email-id already exist!!";
	}
}
