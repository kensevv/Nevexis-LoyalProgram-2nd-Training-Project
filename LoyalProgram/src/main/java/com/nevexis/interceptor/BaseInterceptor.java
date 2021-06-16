package com.nevexis.interceptor;

import com.nevexis.models.Sale;

public abstract class BaseInterceptor extends InterceptorImpl {
	protected void makeSaleDiscount(Sale sale, Double discountPercentage) {
		sale.setTotalDiscount(discountPercentage * sale.getPrice());
	}
}
