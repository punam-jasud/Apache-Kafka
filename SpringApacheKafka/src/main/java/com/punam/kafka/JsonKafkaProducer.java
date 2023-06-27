package com.punam.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.punam.kafka.model.User;


@Service
public class JsonKafkaProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	@Value("${spring.kafka.topic.json-topic-Name}")
	private String jsonTopicName;
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	
	public void sendMessage(User user) {
		
		LOGGER.info(String.format("Message Produced : %s", user.toString()));
		
		Message<User> message =  MessageBuilder
				.withPayload(user)
				.setHeader(KafkaHeaders.TOPIC, jsonTopicName)
				.build();
		
		kafkaTemplate.send(message);
		
	}

}
