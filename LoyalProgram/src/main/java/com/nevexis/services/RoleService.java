package com.nevexis.services;

import org.springframework.stereotype.Service;

import com.nevexis.models.RolesEnum;

@Service
public class RoleService extends BasicService{
	private static final String findRoleByName = "Role.findRoleByName";
	public RolesEnum findRoleByName(RolesEnum name) {
		return em.createNamedQuery(findRoleByName, RolesEnum.class).setParameter("name", name).getSingleResult();
	}
}
