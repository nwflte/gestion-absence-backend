package com.ensa.absence.service;

import java.util.List;

import com.ensa.absence.payload.AbsenceResponse;

public interface AbsenceService {

	List<AbsenceResponse> getAbsencesOfSeance(Long seanceId);

}
