/**
 * 
 */
package com.bridgelabz.spring.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * purpose
 * @author Chaithra-Shenoy
 * Date
 * 
 */
@RestController
public class HelloController {
	@RequestMapping("/hello")
 public String sayHi() {
	 return "HI";
 }
}
