package com.bootcamp.rekening.model.dto;

public class CommonRespons<T> {

	private String responsCode;
	private String responsMessage;
	private T data;
	
	public CommonRespons() {
		this.responsCode="01";
		this.responsMessage="Suscces";
	}

	public CommonRespons(String code, String description) {
		this.responsCode = code;
		this.responsMessage = description;
	}

	public String getResponsCode() {
		return responsCode;
	}

	public void setResponsCode(String responsCode) {
		this.responsCode = responsCode;
	}

	public String getResponsMessage() {
		return responsMessage;
	}

	public void setResponsMessage(String responsMessage) {
		this.responsMessage = responsMessage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
