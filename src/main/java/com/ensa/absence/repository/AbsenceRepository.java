package com.ensa.absence.repository;

import com.ensa.absence.domain.entity.Absence;

import java.util.List;

//@Api(tags = "Absence Entity")
public interface AbsenceRepository extends BaseRepository<Absence, Long> {

	List<Absence> findBySeance_Id(Long seanceId);

    List<Absence> findByEtudiant_Id(Long id);
}
