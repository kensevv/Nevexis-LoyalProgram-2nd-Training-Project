package com.nevexis.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nevexis.models.CardTier;
import com.nevexis.models.LoyalCard;
import com.nevexis.models.Sale;
import com.nevexis.services.SalesService;

@Component("addPointsInterceptor")
public class AddPointsInterceptor extends InterceptorImpl {
	@Autowired
	private SalesService salesService;

	@Override
	public void process(Sale sale) {
		LoyalCard card = sale.getClient().getLoyalCard();
		Double receivedPoints = salesService.getFinalPrice(sale) * getTierPointsPercentage(card.getTier());
		card.setPoints(card.getPoints() + receivedPoints);
		sale.setReceivedPoints(receivedPoints);
	}
	
	private Double getTierPointsPercentage(CardTier tier) {
		if (null == tier) {
			return 0.0;
		}
		if (tier.equals(CardTier.BRONZE)) {
			return 0.03;
		}
		else if (tier.equals(CardTier.SILVER)) {
			return 0.05;
		}
		else if(tier.equals(CardTier.GOLD)) {
			return 0.07;
		}
		else {
			return 0.1;
		} // DIAMOND
	}
}
