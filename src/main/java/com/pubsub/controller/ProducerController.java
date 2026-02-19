package com.pubsub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pubsub.dto.MessageRequest;
import com.pubsub.service.ProducerService;

@RestController
@RequestMapping("/kafka")
public class ProducerController {

	@Autowired
	private ProducerService producerService;

	@PostMapping("/publish")
	public String publish(@RequestBody MessageRequest request) {
		producerService.sendMessage(request.getMessage());
		return "Message sent to Kafka topic";
	}

	@PostMapping("/publish/bulkmsg")
	public String publish() {
		producerService.sendBulkMessages();
		return "Message sent to Kafka topic";
	}
}
