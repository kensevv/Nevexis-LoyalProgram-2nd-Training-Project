package com.nevexis.interceptor;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.nevexis.models.CardTier;
import com.nevexis.models.LoyalCard;
import com.nevexis.models.Sale;
import com.nevexis.services.SalesService;

@Component("addPointsInterceptor")
public class AddPointsInterceptor extends InterceptorImpl {
	private SalesService salesService = new SalesService();

	@Override
	public void process(Sale sale) {
		LoyalCard card = sale.getClient().getLoyalCard();

		BigDecimal receivedPoints = salesService.getFinalPrice(sale).multiply(getTierPointsPercentage(card.getTier()));
		card.setPoints(card.getPoints().add(receivedPoints));
		sale.setReceivedPoints(receivedPoints);
	}

	private BigDecimal getTierPointsPercentage(CardTier tier) {
		if (null == tier) {
			return BigDecimal.ZERO;
		}
		if (tier.equals(CardTier.BRONZE)) {
			return new BigDecimal(0.03);
		} else if (tier.equals(CardTier.SILVER)) {
			return new BigDecimal(0.05);
		} else if (tier.equals(CardTier.GOLD)) {
			return new BigDecimal(0.07);
		} else {
			return new BigDecimal(0.1);
		} // DIAMOND
	}
}
