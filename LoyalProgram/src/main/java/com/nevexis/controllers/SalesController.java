package com.nevexis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nevexis.dtos.SaleDTO;
import com.nevexis.models.Sale;
import com.nevexis.services.SalesService;

@RestController
@RequestMapping("/sales")
public class SalesController {
	@Autowired
	private SalesService salesService;
	
	@GetMapping("/new")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('MERCHANT')")
	public Sale makeSale(@RequestParam String clientPhoneNumber, @RequestBody SaleDTO saleDTO) {
		return salesService.makesale(clientPhoneNumber, saleDTO);
	}
}