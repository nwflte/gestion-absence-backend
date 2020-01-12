package com.ensa.absence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.absence.payload.AbsenceResponse;
import com.ensa.absence.payload.NewOrModifyAbsenceRequest;
import com.ensa.absence.service.AbsenceService;

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
	public void saveAbsenceChangesToSeance(@PathVariable(value = "seanceId", required = true) Long seanceId,
			@RequestBody List<NewOrModifyAbsenceRequest> request) {
		
		absenceService.modifyAbsencesOfSeace(seanceId, request);
		
	}
}
