/**
 * 
 */
package com.example.demo.events;

import com.example.demo.components.StatusMessage;

import lombok.Getter;
import lombok.Setter;

/**
 * @author r.m.ghimis
 * @since Jul 25, 2023
 */
@Getter
@Setter
public class StatusMessageV1 extends StatusMessage {
	private static final long serialVersionUID = -7811126169193499386L;
	
	private String value;
	public StatusMessageV1(String value, String hexacode) {
		super(hexacode);
		this.value = value;
	}
}
