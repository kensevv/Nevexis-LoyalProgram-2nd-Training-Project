package com.nevexis.dtos;

import java.time.LocalDateTime;

import com.nevexis.models.LoyalCard;

public class ClientDto {
	private String firstName;
	private String lastName;
	private String phone;
	private LocalDateTime birthdate;
	private LoyalCard loyalCard;
	
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
