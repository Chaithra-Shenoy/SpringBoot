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

	// create operation
	public Person create(String firstName, String lastName, int age) {
		return personRepository.save(new Person(firstName, lastName, age));
	}

	// Retrieve operation
	public List<Person> getAll() {
		return personRepository.findAll();
	}

	public Person getByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName);
	}

	// Update operation
	public Person update(String firstName, String lastName, int age) {
		Person p = personRepository.findByFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		return personRepository.save(p);
	}

	// delete all records
	public void deleteAll() {
		personRepository.deleteAll();
	}

	// delete particular person
	public void deletePerson(String firstName) {
		Person p = personRepository.findByFirstName(firstName);
		personRepository.delete(p);
	}
}
