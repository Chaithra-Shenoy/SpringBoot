/**
 * 
 */
package com.bridgelabz.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.mongo.model.Person;
import com.bridgelabz.mongo.service.PersonService;

/**
 * purpose
 * 
 * @author Chaithra-Shenoy 
 * Date 9-07-2018
 * 
 */
@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	/**
	 * to register new user
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @return String
	 */
	@RequestMapping("/create")
	public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
		Person p = personService.create(firstName, lastName, age);
		return p.toString();
	}

	/**
	 * to get the person based on the firstName passed
	 * @param firstName
	 * @return Person
	 */
	@RequestMapping("/get")
	public Person getPerson(@RequestParam String firstName) {
		return personService.getByFirstName(firstName);
	}

	/**
	 * get all the persons from database
	 * @return List of Persons
	 */
	@RequestMapping("/getAll")
	public List<Person> getAll() {
		return personService.getAll();
	}

	/**
	 * to update firstName,LastName and age for the given person
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @return String
	 */
	@RequestMapping("/Update")
	public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
		Person p = personService.update(firstName, lastName, age);
		return p.toString();
	}

	/**
	 * to delete particular person based on firstName
	 * @param firstName
	 * @return String
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam String firstName) {
		personService.deletePerson(firstName);
		return "deleted" + firstName;
	}

	/**
	 * to delete all the person from the database
	 * @return String
	 */
	@RequestMapping("/deleteAll")
	public String deleteAll() {
		personService.deleteAll();
		return "deleted all records";
	}

}
