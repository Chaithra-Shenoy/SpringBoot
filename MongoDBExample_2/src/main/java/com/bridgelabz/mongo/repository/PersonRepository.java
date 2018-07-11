/**
 * 
 */
package com.bridgelabz.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.mongo.model.Person;

/**
 * purpose
 * @author Chaithra-Shenoy
 * Date
 * 
 */
@Repository
public interface PersonRepository extends MongoRepository<Person, String>{

	public Person findByFirstName(String firstName);
	public List<Person> findByAge(int age);
}
