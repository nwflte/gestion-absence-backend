package com.ensa.absence.controller;

import com.ensa.absence.payload.AbsenceResponse;
import com.ensa.absence.payload.NewOrModifyAbsenceRequest;
import com.ensa.absence.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/absences")
public class AbsenceController {

	@Autowired
	private AbsenceService absenceService;

	@GetMapping("/seance/{seanceId}")
	public List<AbsenceResponse> getSeancesOfProf(@PathVariable(value = "seanceId", required = true) Long seanceId) {
		return absenceService.getAbsencesResponsesOfSeance(seanceId);
	}

	@PostMapping("/seance/{seanceId}/savechanges")
	@PreAuthorize("hasRole('PROFESSEUR')")
	public void saveAbsenceChangesToSeance(@PathVariable(value = "seanceId", required = true) Long seanceId,
			@RequestBody List<NewOrModifyAbsenceRequest> request) {
		
		absenceService.modifyAbsencesOfSeace(seanceId, request);
		
	}
}
