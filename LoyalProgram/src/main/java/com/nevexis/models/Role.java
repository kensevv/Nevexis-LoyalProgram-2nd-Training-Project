package com.nevexis.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Role.findRoleByName", query = "SELECT r FROM Role r WHERE r.name = :name")
public class Role extends BaseEntity{
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private RolesEnum name;
	 
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "roles_permissions")
	private Set<Permission> permissions = new HashSet<>();
	 
	public String getName() {
		return name.name();
	}

	public void setName(RolesEnum name) {
		this.name = name;
	}

	public Collection<Permission> getPermissions() {
		return permissions;
	}
}
