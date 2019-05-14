package com.bootcamp.rekening.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "wallet")
@Table(name = "wallet")
public class Wallet {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="create_date",insertable=false,updatable=false)
	private String createdDate;	
    
    @ManyToOne
	@JoinColumn(name="cif")
	private Customer cif;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Customer getCif() {
		return cif;
	}

	public void setCif(Customer cif) {
		this.cif = cif;
	}

	
	
}
