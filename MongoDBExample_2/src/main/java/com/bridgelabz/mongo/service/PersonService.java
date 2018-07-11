/**
 * 
 */
package com.bridgelabz.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.mongo.model.Person;
import com.bridgelabz.mongo.repository.PersonRepository;

/**
 * purpose
 * 
 * @author Chaithra-Shenoy Date
 * 
 */
@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	/**
	 * create operation
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @return Person
	 */
	public Person create(String firstName, String lastName, int age) {
		return personRepository.save(new Person(firstName, lastName, age));
	}

	/**
	 * Retrieve operation
	 * @return List of Person
	 */
	public List<Person> getAll() {
		return personRepository.findAll();
	}

	/**
	 * get the person details based on firstName
	 * @param firstName
	 * @return Person
	 */
	public Person getByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName);
	}

	/**
	 * Update persons lastName and Age 
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @return Person
	 */
	public Person update(String firstName, String lastName, int age) {
		Person p = personRepository.findByFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		return personRepository.save(p);
	}

	/**
	 * to delete all records
	 */
	public void deleteAll() {
		personRepository.deleteAll();
	}

	/**
	 * to delete particular records
	 * @param firstName
	 */
	public void deletePerson(String firstName) {
		Person p = personRepository.findByFirstName(firstName);
		personRepository.delete(p);
	}
}
