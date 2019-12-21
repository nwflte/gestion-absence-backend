package com.ensa.absence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.absence.domain.audit.ResponsableDateAudit;
import com.ensa.absence.domain.entity.Departement;
import com.ensa.absence.service.DepartementService;

@RestController
@RequestMapping("/api/departements")
public class DepartementController extends ResponsableDateAudit {
	
	@Autowired
	private DepartementService departementService;
	
	@GetMapping
	public Iterable<Departement> getDepartements(){
		return departementService.getAllDepartements();
	}

}
