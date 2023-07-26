package com.example.demo.components;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;

@Component
@RabbitListener(queues = { "#{consumerDeviceStatusQueue.name}" })
public class DeviceStatusExchangeListener {
	private Many<StatusMessage> processor = Sinks.many().multicast().directAllOrNothing();
	
	@RabbitHandler
	public void receive(@Payload StatusMessage message) {
		processor.tryEmitNext(message);
	}
	
	public Flux<StatusMessage> getEventStream() {
		return processor.asFlux();
	}
	
}
