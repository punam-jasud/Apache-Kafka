package com.punam.stock.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.punam.domains.model.OrderEvent;


@Service
public class StockConsumer {

	private Logger LOGGER = LoggerFactory.getLogger(StockConsumer.class);

	@KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent orderEvent) {
		LOGGER.info(String.format("Order Event Consumed: %s", orderEvent.toString()));
	}

}
