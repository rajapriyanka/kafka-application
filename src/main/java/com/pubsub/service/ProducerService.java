package com.pubsub.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	private final KafkaTemplate<String, String> kafkaTemplate;

	public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		kafkaTemplate.send("demo", message);
	}

	public void sendBulkMessages() {
		for (int i = 1; i <= 1000; i++) {
			kafkaTemplate.send("demo", "Message " + i);
		}
	}

}
