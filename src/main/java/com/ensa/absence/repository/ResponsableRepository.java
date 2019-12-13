package com.ensa.absence.repository;

import com.ensa.absence.domain.entity.Responsable;
import com.ensa.absence.domain.entity.User;

public interface ResponsableRepository extends BaseRepository<Responsable, Long> {

	Responsable getByUser(User user);

}
