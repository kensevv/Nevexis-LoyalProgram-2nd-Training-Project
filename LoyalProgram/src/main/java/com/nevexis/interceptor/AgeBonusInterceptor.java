package com.nevexis.interceptor;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nevexis.models.Sale;
import com.nevexis.services.ClientService;

@Component("ageBonusInterceptor")
public class AgeBonusInterceptor extends BaseInterceptor {
	@Autowired
	private ClientService clientService;

	@Override
	public void process(Sale sale) {
		if(null == sale ||  null == sale.getClient()) {
			return;
		}
		
		BigDecimal discountPercentage = getDiscount(clientService.getClientAge(sale.getClient()));
		
		if(0 == discountPercentage.compareTo(BigDecimal.ZERO)) {
			return;
		}
		
		makeSaleDiscount(sale, discountPercentage);
	}

	private BigDecimal getDiscount(Integer age) {
		if (null == age || 0 == age) {
			return new BigDecimal(0.0);
		}
		if (age < 3) {
			return new BigDecimal(0.50);
		}
		if (age < 12) {
			return new BigDecimal(0.30);
		}
		if (age < 26) {
			return new BigDecimal(0.10);
		}
		if (age >= 60) {
			return new BigDecimal(0.60);
		}
		return new BigDecimal(0.0);
	}
}
