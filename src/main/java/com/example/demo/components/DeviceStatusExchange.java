package com.example.demo.components;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.stereotype.Component;

@Component
public class DeviceStatusExchange extends FanoutExchange {

	public DeviceStatusExchange() {
		super(DeviceStatusExchange.class.getSimpleName());
	}

}
