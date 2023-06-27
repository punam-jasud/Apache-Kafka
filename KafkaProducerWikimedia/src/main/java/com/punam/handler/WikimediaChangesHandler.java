package com.punam.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;


public class WikimediaChangesHandler implements BackgroundEventHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesHandler.class);

	private KafkaTemplate<String, String> kafkaTemplate;
	private String topic;

	public WikimediaChangesHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}

	@Override
	public void onOpen() throws Exception {
		// Do something when the event stream is opened
	}

	@Override
	public void onClosed() throws Exception {
		// Do something when the event stream is closed
	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		// Log the event data
		LOGGER.info(String.format("Wikimedia Event Data : %s", messageEvent.getData()));
		// Send the event data to Kafka
		kafkaTemplate.send(topic, messageEvent.getData());
	}

	@Override
	public void onComment(String comment) throws Exception {
		// Do something when a comment is received
	}

	@Override
	public void onError(Throwable t) {
		// Handle errors
	}

}
