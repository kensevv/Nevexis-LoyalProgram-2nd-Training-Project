package com.nevexis.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Permission extends BaseEntity{
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private PermissionsEnum permission;

	public PermissionsEnum getPermission() {
		return permission;
	}
}
