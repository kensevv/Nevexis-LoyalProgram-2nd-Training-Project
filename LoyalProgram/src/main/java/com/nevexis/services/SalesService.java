package com.nevexis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nevexis.dtos.SaleDTO;
import com.nevexis.interceptor.AgeBonusInterceptor;
import com.nevexis.models.Sale;

@Service
public class SalesService extends BasicService {
	@Autowired
	@Qualifier("ageBonusInterceptor")
	private AgeBonusInterceptor ageBonusInterceptor;

	@Autowired
	ClientService clientService;

	public void makesale(String clientPhoneNumber, SaleDTO saleDTO) {
		Sale sale = new Sale(clientService.getCLientByPhone(clientPhoneNumber),
				new java.sql.Date(System.currentTimeMillis()), saleDTO.getPrice(), null);
		ageBonusInterceptor.invoke(sale);

		em.persist(sale);
	}

	public Double getFinalPrice(Sale sale) {
		if (null != sale && null != sale.getTotalDiscount()) {
			return sale.getPrice() - sale.getTotalDiscount();
		}
		return sale.getPrice();
	}

}
