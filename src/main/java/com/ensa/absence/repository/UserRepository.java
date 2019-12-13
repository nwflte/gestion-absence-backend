package com.ensa.absence.repository;

import java.util.Optional;

import com.ensa.absence.domain.entity.User;

public interface UserRepository extends BaseRepository<User, Long> {

	Optional<User> findByUsername(String username);

}
