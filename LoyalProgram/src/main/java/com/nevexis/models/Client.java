package com.nevexis.models;

import java.sql.Date;

import javax.persistence.Entity;

import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQuery(name = "Client.getAllClients", query = "SELECT c FROM Client c")
@NamedQuery(name = "Client.getClientByPhone", query = "SELECT c FROM Client c WHERE c.phone = :phone")
public class Client extends BaseEntity{
	private String firstName;
	private String lastName;
	private String phone;
	private Date birthdate;

	public Client() {}
	
	public Client(String firstName, String lastName, String phone, Date birthdate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.birthdate = birthdate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
}
