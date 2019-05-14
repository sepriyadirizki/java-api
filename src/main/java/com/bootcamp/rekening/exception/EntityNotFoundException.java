package com.bootcamp.rekening.exception;

public class EntityNotFoundException extends Exception {

	private String code;
	private String description;
	
	public EntityNotFoundException(String code, String description) {
		this.code= code;
		this.description= description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
