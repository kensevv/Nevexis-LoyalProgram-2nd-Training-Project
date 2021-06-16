package com.nevexis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nevexis.dtos.SaleDTO;
import com.nevexis.interceptor.AddPointsInterceptor;
import com.nevexis.interceptor.AgeBonusInterceptor;
import com.nevexis.interceptor.InterceptorChainImpl;
import com.nevexis.interceptor.UsePointsInterceptor;
import com.nevexis.models.Sale;

@Service
public class SalesService extends BasicService {
	@Autowired
	@Qualifier("ageBonusInterceptor")
	private AgeBonusInterceptor ageBonusInterceptor;
	@Autowired
	@Qualifier("addPointsInterceptor")
	private AddPointsInterceptor addPointsInterceptor;
	@Autowired
	@Qualifier("usePointsInterceptor")
	private UsePointsInterceptor usePointsInterceptor;
	
	@Autowired
	ClientService clientService;

	public Sale makesale(String clientPhoneNumber, SaleDTO saleDTO, Boolean usePoints) {
		Sale sale = new Sale(clientService.getCLientByPhone(clientPhoneNumber),
				new java.sql.Date(System.currentTimeMillis()), saleDTO.getPrice(), null);

		InterceptorChainImpl interceptorChain;
		if(usePoints == true) {
			interceptorChain = new InterceptorChainImpl(ageBonusInterceptor, addPointsInterceptor, usePointsInterceptor);
		}
		else {
			interceptorChain = new InterceptorChainImpl(ageBonusInterceptor, addPointsInterceptor);
			sale.setUsedPoints(0.0);
		}
		interceptorChain.invoke(sale);
		
		// ageBonusInterceptor.invoke(sale);
		// addPointsInterceptor.invoke(sale);
		
		em.persist(sale);
		return sale;
	}

	public Double getFinalPrice(Sale sale) {
		if (null != sale && null != sale.getTotalDiscount()) {
			return sale.getPrice() - sale.getTotalDiscount();
		}
		return sale.getPrice();
	}
}
