package com.nevexis.models;

import javax.persistence.Entity;

@Entity
public class Merchant extends BaseEntity{
	private String name;
	private String companyRegistrationNumber;
}
