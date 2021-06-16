package com.nevexis.models;

import javax.persistence.Entity;

@Entity
public class Merchant extends BaseEntity {
	private String name;
	private String companyRegistrationNumber;

	public Merchant() {
	}

	public Merchant(String name, String companyRegistrationNumber) {
		this.name = name;
		this.companyRegistrationNumber = companyRegistrationNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyRegistrationNumber() {
		return companyRegistrationNumber;
	}

	public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
		this.companyRegistrationNumber = companyRegistrationNumber;
	}

}
