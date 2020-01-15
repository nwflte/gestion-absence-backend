package com.ensa.absence.controller;


import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.payload.*;
import com.ensa.absence.service.FiliereService;
import com.ensa.absence.service.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {
	
	@Autowired
	private FiliereService filiereService;
	
	@Autowired
	private GroupeService groupeService;
	
	@GetMapping
	public Iterable<Filiere> getFilieres(){
		return filiereService.getAllFilieres();
	}
	
	@GetMapping("/getlist")
	public List<FiliereResponse> getFilieresResponse(){
		return filiereService.getAllFilieresResponse();
	}
	
	@GetMapping("/{filiereId}")
	public List<GroupeResponse> getFiliereDetailsForScolarite(@PathVariable Long filiereId) {
		return groupeService.getGroupeResponsesByFiliere(filiereId);
	}
	
	@GetMapping("/{filiereId}/groupes")
	public List<GroupeResponse> getGroupesByFiliere(@PathVariable(value = "filiereId", required = true) Long filiereId) {
		return groupeService.getGroupeResponsesByFiliere(filiereId);
	}

	@PostMapping("/")
	public FiliereResponse createSeanceByProf(@RequestBody CreateFiliereRequest request) {
		return filiereService.saveFiliere(request);
	}
}
