package com.nevexis.interceptor;

import org.springframework.stereotype.Component;

import com.nevexis.models.Sale;

@Component("usePointsInterceptor")
public class UsePointsInterceptor extends InterceptorImpl {

	private final Double DISCOUNT_PER_POINT = 0.5;
	
	@Override
	public void process(Sale sale) {
		Double totalPoints = sale.getClient().getLoyalCard().getPoints();
		sale.setTotalDiscount(sale.getTotalDiscount() + (totalPoints * DISCOUNT_PER_POINT));
		sale.setUsedPoints(totalPoints);
		sale.getClient().getLoyalCard().setPoints(0.0);
	}
}
