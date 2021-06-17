package com.nevexis.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class LoyalCard extends BaseEntity{
	@Column(precision=10, scale=2)
	private BigDecimal points;

	@Enumerated(EnumType.STRING)
	private CardTier tier;
	
	public LoyalCard() {}
	
	public LoyalCard(BigDecimal points, CardTier tier) {
		this.points = points;
		this.tier = tier;
	}

	public BigDecimal getPoints() {
		return points;
	}

	public void setPoints(BigDecimal points) {
		this.points = points;
	}

	public CardTier getTier() {
		return tier;
	}

	public void setTier(CardTier tier) {
		this.tier = tier;
	}
}
