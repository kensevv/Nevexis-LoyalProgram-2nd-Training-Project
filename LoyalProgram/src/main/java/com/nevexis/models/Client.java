package com.nevexis.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQuery(name = "Client.getAllClients", query = "SELECT c FROM Client c")
@NamedQuery(name = "Client.getClientByPhone", query = "SELECT c FROM Client c WHERE c.phone = :phone")
public class Client extends BaseEntity{
	private String firstName;
	private String lastName;
	private String phone;
	private LocalDateTime birthdate;
	
	@ManyToOne
	private LoyalCard loyalCard;

	public Client() {}
	
	public Client(String firstName, String lastName, String phone, LocalDateTime birthdate, LoyalCard loyalCard) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.birthdate = birthdate;
		this.loyalCard = loyalCard;
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

	public LocalDateTime getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDateTime birthdate) {
		this.birthdate = birthdate;
	}

	public LoyalCard getLoyalCard() {
		return loyalCard;
	}

	public void setLoyalCard(LoyalCard loyalCard) {
		this.loyalCard = loyalCard;
	}
}
