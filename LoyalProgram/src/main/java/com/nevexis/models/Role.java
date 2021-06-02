package com.nevexis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Role.findRoleByName", query = "SELECT r FROM Role r WHERE r.name = :name")
public class Role extends BaseEntity{
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private RolesEnum name;

	public String getName() {
		return name.name();
	}

	public void setName(RolesEnum name) {
		this.name = name;
	}
}
