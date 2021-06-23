package com.nevexis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nevexis.models.CardTier;
import com.nevexis.models.Client;
import com.nevexis.services.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ClientService clientService;

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/tier")
	public List<Client> getClientsWithTier(@RequestParam CardTier tier){
		return clientService.getClientsByTier(tier);
	}
}
