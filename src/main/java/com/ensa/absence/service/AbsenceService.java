package com.ensa.absence.service;

import java.util.List;

import com.ensa.absence.domain.entity.Absence;
import com.ensa.absence.payload.AbsenceResponse;
import com.ensa.absence.payload.NewOrModifyAbsenceRequest;

public interface AbsenceService {

	List<AbsenceResponse> getAbsencesResponsesOfSeance(Long seanceId);
	void modifyAbsencesOfSeace(Long seanceId, List<NewOrModifyAbsenceRequest> request);

}
