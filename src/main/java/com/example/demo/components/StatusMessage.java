package com.example.demo.components;

import java.io.Serializable;
import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class StatusMessage implements Serializable {
	private static final long serialVersionUID = 3940168860013502530L;
	protected UUID uuid = UUID.randomUUID();
	@EqualsAndHashCode.Include
	protected String hexacode;
	
	public StatusMessage(String hexacode) {
		this.hexacode = hexacode;
	}
}
