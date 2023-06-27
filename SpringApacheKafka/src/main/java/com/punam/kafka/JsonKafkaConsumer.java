package com.punam.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.punam.kafka.model.User;


@Service
public class JsonKafkaConsumer {
	
	private Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	
	@KafkaListener(topics = "${spring.kafka.topic.json-topic-Name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(User user) {
		LOGGER.info(String.format("Message Consumed: %s", user.toString()));
	}

}
