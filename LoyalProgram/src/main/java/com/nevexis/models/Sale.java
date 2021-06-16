package com.nevexis.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Sale extends BaseEntity{
	@ManyToOne
	private Client client;
	private Date date;
	private Double price;
	private Double totalDiscount;
	private Double receivedPoints;
	private Double usedPoints;
	
	public Sale() {}
	
	public Sale(Client client, Date date, Double price, Double totalDiscount) {
		this.client = client;
		this.date = date;
		this.price = price;
		this.totalDiscount = totalDiscount;
	}

	
	public Sale(Client client, Date date, Double price, Double totalDiscount, Double receivedPoints,
			Double usedPoints) {
		this.client = client;
		this.date = date;
		this.price = price;
		this.totalDiscount = totalDiscount;
		this.receivedPoints = receivedPoints;
		this.usedPoints = usedPoints;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(Double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public Double getReceivedPoints() {
		return receivedPoints;
	}

	public void setReceivedPoints(Double receivedPoints) {
		this.receivedPoints = receivedPoints;
	}

	public Double getUsedPoints() {
		return usedPoints;
	}

	public void setUsedPoints(Double usedPoints) {
		this.usedPoints = usedPoints;
	}
	
}