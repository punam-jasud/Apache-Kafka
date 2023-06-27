package com.punam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.punam.kafka.KafkaProducer;

@SpringBootApplication
public class KafkaProducerWikimediaApplication implements CommandLineRunner{
	
	@Autowired
	private KafkaProducer kafkaProducer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerWikimediaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		kafkaProducer.sendMessage();
	}

}
