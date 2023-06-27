package com.punam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.punam.kafka.JsonKafkaProducer;
import com.punam.kafka.KafkaProducer;
import com.punam.kafka.model.User;


@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@Autowired
	private JsonKafkaProducer jsonKafkaProducer;
	
	
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message Sent to a Topic");
	}
	

	@GetMapping("/json/publish")
	public ResponseEntity<String> publishJson(@RequestBody User user){
		jsonKafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json Message Sent to a Topic");
	}
	
}
