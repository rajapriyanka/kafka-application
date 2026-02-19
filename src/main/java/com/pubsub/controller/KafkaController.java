package com.pubsub.controller;

import org.springframework.web.bind.annotation.*;

import com.pubsub.dto.MessageRequest;
import com.pubsub.service.KafkaProducerService;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

	private final KafkaProducerService producerService;

	public KafkaController(KafkaProducerService producerService) {
		this.producerService = producerService;
	}

	@PostMapping("/publish")
	public String publish(@RequestBody MessageRequest request) {
		producerService.sendMessage(request.getMessage());
		return "Message sent to Kafka topic";
	}
}
