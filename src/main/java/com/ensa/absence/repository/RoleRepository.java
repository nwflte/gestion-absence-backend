package com.ensa.absence.repository;

import com.ensa.absence.domain.entity.Role;
import com.ensa.absence.domain.entity.User;
import com.ensa.absence.domain.enums.RoleName;

import java.util.Optional;

public interface RoleRepository extends BaseRepository<Role, Long> {
	Role findByName(RoleName name);
}
