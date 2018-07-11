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
	@SuppressWarnings("unchecked")
	private List<Topic> topics = new ArrayList(
			Arrays.asList(new Topic("Spring", "Spring", "Spring Framework"), new Topic("J2EE", "Advanced Java", "J2EE"),
					new Topic("JAVA", "Core Java", "Java"), new Topic("ORM", "Hibernate", "Hibernate")));

	public List<Topic> getTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	/**
	 * @param topic
	 */
	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	/**
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
	 * @param id
	 * @return
	 */
	public void deleteTopic(String id) {
		topics.remove(id);
	}
}
