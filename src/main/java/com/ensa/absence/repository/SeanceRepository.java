package com.ensa.absence.repository;

import java.util.List;

import com.ensa.absence.domain.entity.Seance;

public interface SeanceRepository extends BaseRepository<Seance, Long> {

	List<Seance> findByProfesseur_Id(Long profId);

}
