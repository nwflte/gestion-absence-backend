package com.ensa.absence.repository;

import com.ensa.absence.domain.entity.Role;
import com.ensa.absence.domain.enums.RoleName;

public interface RoleRepository extends BaseRepository<Role, Long> {
	Role findByName(RoleName name);
}
