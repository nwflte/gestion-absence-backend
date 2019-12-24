package com.ensa.absence.repository;

import java.util.Optional;

import com.ensa.absence.domain.entity.ResponsableScolarite;

public interface ResponsableScolariteRepository extends BaseRepository<ResponsableScolarite, Long> {

	Optional<ResponsableScolarite> findByUser_Id(Long id);

}
