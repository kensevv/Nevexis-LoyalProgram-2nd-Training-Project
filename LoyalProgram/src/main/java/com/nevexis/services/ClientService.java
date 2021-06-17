package com.nevexis.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nevexis.models.Client;

@Service
public class ClientService extends BasicService {
	private final String getAllClients = "Client.getAllClients";
	private final String getClientByPhone = "Client.getClientByPhone";

	public List<Client> getAllClients() {
		return em.createNamedQuery(getAllClients, Client.class).setMaxResults(100).getResultList();
	}

	public Client getCLientByPhone(String phoneNumber) {
		return em.createNamedQuery(getClientByPhone, Client.class).setParameter("phone", phoneNumber).getSingleResult();
	}

	public int getClientAge(Client client) {
		return LocalDateTime.now().getYear() - client.getBirthdate().getYear();
	}
}
