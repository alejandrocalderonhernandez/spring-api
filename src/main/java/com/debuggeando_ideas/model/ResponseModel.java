package com.debuggeando_ideas.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ResponseModel implements Serializable {

	private LocalDateTime date;
	private Object response;
	private String message;
	
	public ResponseModel(LocalDateTime date, Object response, String message) {
		this.date = date;
		this.response = response;
		this.message = message;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private static final long serialVersionUID = 5680355142841263102L;

}
