package com.nevexis.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
public class Permission extends BaseEntity{
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private PermissionsEnum permission;
	
	 @ManyToMany(fetch = FetchType.LAZY,
	            cascade = {
	                CascadeType.PERSIST,
	                CascadeType.MERGE
	            },
	            mappedBy = "permissions")
	    private Set<Role> roles = new HashSet<>();
	
	public PermissionsEnum getPermission() {
		return permission;
	}
}
