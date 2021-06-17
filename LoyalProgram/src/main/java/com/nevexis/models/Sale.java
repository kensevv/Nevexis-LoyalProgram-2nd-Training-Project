package com.nevexis.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Sale extends BaseEntity{
	@ManyToOne
	private Client client;
	
	private LocalDateTime date;
	
	@Column(precision=10, scale=2)
	private BigDecimal price;
	
	@Column(precision=10, scale=2)
	private BigDecimal totalDiscount;
	
	@Column(precision=10, scale=2)
	private BigDecimal receivedPoints;
	
	@Column(precision=10, scale=2)
	private BigDecimal usedPoints;
	
	public Sale() {}
	
	public Sale(Client client, LocalDateTime date, BigDecimal price, BigDecimal totalDiscount) {
		this.client = client;
		this.date = date;
		this.price = price;
		this.totalDiscount = totalDiscount;
	}

	public Sale(Client client, LocalDateTime date, BigDecimal price, BigDecimal totalDiscount, BigDecimal receivedPoints,
			BigDecimal usedPoints) {
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(BigDecimal totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public BigDecimal getReceivedPoints() {
		return receivedPoints;
	}

	public void setReceivedPoints(BigDecimal receivedPoints) {
		this.receivedPoints = receivedPoints;
	}

	public BigDecimal getUsedPoints() {
		return usedPoints;
	}

	public void setUsedPoints(BigDecimal usedPoints) {
		this.usedPoints = usedPoints;
	}
}