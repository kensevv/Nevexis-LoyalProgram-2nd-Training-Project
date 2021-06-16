package com.nevexis.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class LoyalCard extends BaseEntity{
	private Double points;

	@Enumerated(EnumType.STRING)
	private CardTier tier;
	
	public LoyalCard() {}
	
	public LoyalCard(Double points, CardTier tier) {
		this.points = points;
		this.tier = tier;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	public CardTier getTier() {
		return tier;
	}

	public void setTier(CardTier tier) {
		this.tier = tier;
	}
}
