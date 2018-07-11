/**
 * 
 */
package com.bridgelabz.spring.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * purpose
 * 
 * @author Chaithra-Shenoy Date
 * 
 */
@Service
public class TopicService {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<Topic> topics = new ArrayList(
			Arrays.asList(new Topic("Spring", "Spring", "Spring Framework"), new Topic("J2EE", "Advanced Java", "J2EE"),
					new Topic("JAVA", "Core Java", "Java"), new Topic("ORM", "Hibernate", "Hibernate")));

	/**
	 * to get all the topics
	 * @return List
	 */
	public List<Topic> getTopics() {
		return topics;
	}

	/**
	 * to get particular topic
	 * @param id
	 * @return Topic
	 */
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	/**
	 * to add a topic
	 * @param topic
	 */
	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	/**
	 * to update a topic details
	 * @param id
	 * @param topic
	 */
	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	/**
	 * to delete Topic
	 * @param id
	 * @return void
	 */
	public void deleteTopic(String id) {
		topics.remove(id);
	}
}
