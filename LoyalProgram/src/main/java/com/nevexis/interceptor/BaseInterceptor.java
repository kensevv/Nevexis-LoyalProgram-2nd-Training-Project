package com.nevexis.interceptor;

import java.math.BigDecimal;

import com.nevexis.models.Sale;

public abstract class BaseInterceptor extends InterceptorImpl {
	protected void makeSaleDiscount(Sale sale, BigDecimal discountPercentage) {
		sale.setTotalDiscount(new BigDecimal(sale.getPrice())
				.subtract(discountPercentage.multiply(new BigDecimal(sale.getPrice()))).doubleValue());
	}
}
