package com.nevexis.interceptor;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.nevexis.models.Sale;

@Component("usePointsInterceptor")
public class UsePointsInterceptor extends InterceptorImpl {

	private final BigDecimal DISCOUNT_PER_POINT = new BigDecimal(0.5);

	@Override
	public void process(Sale sale) {
		BigDecimal totalPoints = sale.getClient().getLoyalCard().getPoints();

		sale.setTotalDiscount(sale.getTotalDiscount().add((totalPoints.multiply(DISCOUNT_PER_POINT))));
		sale.setUsedPoints(totalPoints);
		sale.getClient().getLoyalCard().setPoints(BigDecimal.ZERO);
	}
}
