package com.ensa.absence.service;

import com.ensa.absence.payload.AbsenceResponse;
import com.ensa.absence.payload.NewOrModifyAbsenceRequest;

import java.util.List;

public interface AbsenceService {

	List<AbsenceResponse> getAbsencesResponsesOfSeance(Long seanceId);

	void modifyAbsencesOfSeace(Long seanceId, List<NewOrModifyAbsenceRequest> request);

}
