package com.bootcamp.rekening.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "transaction_type")
@Table (name = "transaction_type")
public class TransactionType {
	@Id
	@Column(name="code")
	private String code;
	
	@Column(name="description")
	private String description;

	

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



	public String toString() {
		return String.format("%s", this.code);
	}
}
