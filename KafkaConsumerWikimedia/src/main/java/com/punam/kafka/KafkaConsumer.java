package com.punam.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.punam.entity.WikimediaEventData;
import com.punam.repository.WikimediaRepository;

@Service
public class KafkaConsumer {
	
	@Autowired
	private WikimediaRepository repository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	
	@KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(String messgageEvent) {
		LOGGER.info(String.format("Event Message Consumed: %s", messgageEvent));
		
		WikimediaEventData wikimediaEventData = new WikimediaEventData();
		wikimediaEventData.setEventData(messgageEvent);
		repository.save(wikimediaEventData);
		
	}

}
