package com.nevexis.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class BasicService {
	@PersistenceContext
	protected EntityManager em;
}
