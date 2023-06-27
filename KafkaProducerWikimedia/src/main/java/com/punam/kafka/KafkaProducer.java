package com.punam.kafka;

import java.net.URI;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import com.punam.handler.WikimediaChangesHandler;


@Service
public class KafkaProducer {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${spring.kafka.topic}")
	private String topic;
	
	public void sendMessage() throws InterruptedException {
		
		BackgroundEventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";
		BackgroundEventSource eventSource = new BackgroundEventSource.Builder(eventHandler, new EventSource.Builder(URI.create(url))).build();	
		eventSource.start();
		TimeUnit.MINUTES.sleep(1);

	}
}
