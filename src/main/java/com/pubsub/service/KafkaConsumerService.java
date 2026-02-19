package com.pubsub.service;

import java.time.ZonedDateTime;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public KafkaConsumerService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@KafkaListener(topics = "demo", groupId = "my-group")
	public void consume(String message) {
		System.out.println("Consumed: " + message);
		String reply = "Processed message: " + message + " | Timestamp: " + ZonedDateTime.now();
		kafkaTemplate.send("ack-topic", reply);
	}

}
