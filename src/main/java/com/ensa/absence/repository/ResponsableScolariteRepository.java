package com.ensa.absence.repository;

import com.ensa.absence.domain.entity.ResponsableScolarite;

import java.util.Optional;

public interface ResponsableScolariteRepository extends BaseRepository<ResponsableScolarite, Long> {

    Optional<ResponsableScolarite> findByUser_Id(Long id);

    ResponsableScolarite findByUser_Username(String username);
}
