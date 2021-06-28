package com.nevexis.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.nevexis.models.CardTier;
import com.nevexis.models.Client;
import com.nevexis.models.LoyalCard;

@Service
public class ClientService extends BasicService {
	// CRITERIA BUILDER API
	public List<Client> getClientsByTier(CardTier tier) {

		CriteriaBuilder critBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Client> critQuery = critBuilder.createQuery(Client.class);

		Root<Client> client = critQuery.from(Client.class);

		Join<Client, LoyalCard> clientCards = client.join("loyalCard", JoinType.INNER);

		Predicate tierMatches = critBuilder.equal(clientCards.get("tier"), tier);

		critQuery.where(tierMatches);

		TypedQuery<Client> query = em.createQuery(critQuery);
		return query.setMaxResults(100).getResultStream()
				.sorted((c1, c2) -> c1.getFirstName().compareTo(c2.getFirstName())).collect(Collectors.toList());
	}

	public List<Client> getAllClients() {
		return em.createNamedQuery(Client.getAllClients, Client.class).setMaxResults(100).getResultList();
	}

	public Client getCLientByPhone(String phoneNumber) {
		return em.createNamedQuery(Client.getClientByPhone, Client.class).setParameter("phone", phoneNumber)
				.getSingleResult();
	}

	public int getClientAge(Client client) {
		return LocalDateTime.now().getYear() - client.getBirthdate().getYear();
	}

}
