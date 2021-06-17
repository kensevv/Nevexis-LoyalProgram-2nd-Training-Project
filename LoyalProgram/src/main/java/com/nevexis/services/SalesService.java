package com.nevexis.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nevexis.dtos.SaleDTO;
import com.nevexis.interceptor.InterceptorChainImpl;
import com.nevexis.models.Sale;

@Service
public class SalesService extends BasicService {
	@Autowired
	@Qualifier("usePointsInterceptorChain")
	private InterceptorChainImpl usePointsChain;
	
	@Autowired
	@Qualifier("dontUsePointsInterceptorChain")
	private InterceptorChainImpl dontUsePointsChain;
	
	@Autowired
	private ClientService clientService;
	
	public Sale makesale(String clientPhoneNumber, SaleDTO saleDTO, Boolean usePoints) {
		Sale sale = new Sale(clientService.getCLientByPhone(clientPhoneNumber),
				LocalDateTime.now(), saleDTO.getPrice(), null);

		if(usePoints == true) {
			usePointsChain.invoke(sale);
		}
		else {
			dontUsePointsChain.invoke(sale);
			sale.setUsedPoints(BigDecimal.ZERO);
		}
		
		em.persist(sale);
		return sale;
	}

	public BigDecimal getFinalPrice(Sale sale) {
		if (null != sale && null != sale.getTotalDiscount()) {
			return sale.getPrice().subtract(sale.getTotalDiscount());
		}
		return sale.getPrice();
	}
}
