package com.nevexis.models;

import javax.persistence.Entity;

@Entity
public class Client extends BaseEntity{
	private String firstName;
	private String lastName;
	private String phone;
}
