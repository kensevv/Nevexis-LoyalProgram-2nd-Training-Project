package com.nevexis.dtos;

public class SaleDTO {
	private Double price;

	public SaleDTO() {}
	
	public SaleDTO(Double price) {
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
