/**
 * 
 */
package com.example.demo;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Base64UrlNamingStrategy;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.components.DeviceStatusExchange;

/**
 * @author r.m.ghimis
 * @since Jul 25, 2023
 */
@Configuration
@ComponentScan(basePackages = { "org.optilink.events" })
public class Config {
	
	@Value("${spring.application.name:spring.gen-}")
	private String applicationName;
	
	@Bean
	public Queue consumerDeviceStatusQueue() {
		return new AnonymousQueue(new Base64UrlNamingStrategy(applicationName));
	}
	
	@Bean
	public Binding getDeviceStatusExchangeBinding(
			DeviceStatusExchange exchange, 
			@Qualifier("consumerDeviceStatusQueue") Queue queue) {
		return BindingBuilder.bind(queue).to(exchange);
	}
	
}
