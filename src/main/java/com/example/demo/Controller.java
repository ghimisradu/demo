/**
 * 
 */
package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.components.DeviceStatusExchange;
import com.example.demo.events.StatusMessageV1;

import reactor.core.publisher.Mono;

/**
 * @author r.m.ghimis
 * @since Jul 25, 2023
 */
@RestController
public class Controller {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@GetMapping("/test")
	public Mono<Void> test() {
		StatusMessageV1 v1 = new StatusMessageV1("test", "ddddd");
		amqpTemplate.convertAndSend(DeviceStatusExchange.class.getSimpleName(), "", v1);
		return Mono.empty();
	}
	
}
