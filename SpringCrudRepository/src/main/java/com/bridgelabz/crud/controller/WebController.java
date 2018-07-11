/**
 * 
 */
package com.bridgelabz.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.crud.dao.CustomerRepository;
import com.bridgelabz.crud.model.Customer;

/**
 * purpose
 * @author Chaithra-Shenoy
 * Date
 * 
 */
@RestController
public class WebController {
	@Autowired
    CustomerRepository repository;
      
    @RequestMapping("/save")
    public String process(){
        repository.save(new Customer("Chaithra", "Shenoy"));
        repository.save(new Customer("Aruna", "B"));
        repository.save(new Customer("Lakshmi", "priya"));
        repository.save(new Customer("Divya", "Shenoy"));
        repository.save(new Customer("Ananya", "Varma"));
        return "Done";
    }
      
      
    @RequestMapping("/findall")
    public String findAll(){
        String result = "<html>";
          
        for(Customer cust : repository.findAll()){
            result += "<div>" + cust.toString() + "</div>";
        }
          
        return result + "</html>";
    }
      
    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = (repository).findById(id).toString();
        return result;
    }
      
    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName){
        String result = "<html>";
          
        for(Customer cust: repository.findByLastName(lastName)){
            result += "<div>" + cust.toString() + "</div>"; 
        }
          
        return result + "</html>";
    }
}
