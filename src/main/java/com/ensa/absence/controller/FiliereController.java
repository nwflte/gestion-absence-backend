package com.ensa.absence.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.payload.FiliereResponse;
import com.ensa.absence.payload.GroupeResponse;
import com.ensa.absence.projection.FiliereGroupesProjection;
import com.ensa.absence.service.FiliereService;
import com.ensa.absence.service.GroupeService;

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
}
