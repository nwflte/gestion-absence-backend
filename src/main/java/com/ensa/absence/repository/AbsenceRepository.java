package com.ensa.absence.repository;

import java.util.List;

import com.ensa.absence.domain.entity.Absence;

//@Api(tags = "Absence Entity")
public interface AbsenceRepository extends BaseRepository<Absence, Long> {

	List<Absence> findBySeance_Id(Long seanceId);

}
