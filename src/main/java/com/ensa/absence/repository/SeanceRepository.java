package com.ensa.absence.repository;

import com.ensa.absence.domain.entity.Seance;

import java.util.Date;
import java.util.List;

public interface SeanceRepository extends BaseRepository<Seance, Long> {

	List<Seance> findByProfesseur_Id(Long profId);

    List<Seance> findByProfesseur_IdAndDate(Long profId, Date date);
}
