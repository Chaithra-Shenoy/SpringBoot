/**
 * 
 */
package com.bridgelabz.mongo.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.mongo.model.User;

/**
 * purpose
 * 
 * @author Chaithra-Shenoy 
 * Date 10-07-2018
 */
@Repository
public interface UserDAO extends MongoRepository<User, String> {

}
