/**
 * 
 */
package com.bridgelabz.spring.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * purpose
 * 
 * @author Chaithra-Shenoy Date
 * 
 */
@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	/**
	 * to get all the topics
	 * @return List of Topics
	 */
	@RequestMapping("/topics")
	public List<Topic> getTopics() {
		return topicService.getTopics();
	}

	/**
	 * to get particulat Topic
	 * @param id
	 * @return Topic
	 */
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}

	/**
	 * to add Topic to list
	 * @param topic
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	/**
	 * to update Topic details
	 * @param topic
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicService.updateTopic(id,topic);
	}
	/**
	 *  to delete particular details
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		 topicService.deleteTopic(id);
	}
	
}
