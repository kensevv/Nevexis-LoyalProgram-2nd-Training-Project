package com.nevexis.dtos;

import java.math.BigDecimal;

public class SaleDTO {
	private BigDecimal price;

	public SaleDTO() {}
	
	public SaleDTO(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
