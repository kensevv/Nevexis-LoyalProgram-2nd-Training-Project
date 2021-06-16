package com.nevexis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nevexis.dtos.SaleDTO;
import com.nevexis.services.SalesService;

@RestController
@RequestMapping("/sales")
public class SalesController {
	@Autowired
	private SalesService salesService;
	
	@GetMapping("/new")
	public void makeSale(@RequestParam String clientPhoneNumber, @RequestParam Double price) {
		salesService.makesale(clientPhoneNumber, new SaleDTO(price));
	}
}
