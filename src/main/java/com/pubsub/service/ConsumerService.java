package com.pubsub.service;

import java.time.ZonedDateTime;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public ConsumerService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@KafkaListener(topics = "demo", groupId = "my-group")
	public void consume(String message) {
		System.out.println("Consumed: " + message);
		String ack = "Processed message: " + message + " | Timestamp: " + ZonedDateTime.now();
		kafkaTemplate.send("ack-topic", ack);
	}

}
