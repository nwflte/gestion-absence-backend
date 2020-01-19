package com.ensa.absence.controller;

import com.ensa.absence.payload.CreateModuleRequest;
import com.ensa.absence.payload.ModuleResponse;
import com.ensa.absence.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {
	
	@Autowired
	private ModuleService moduleService;
	
	@GetMapping("/professeur/{profId}")
	public List<ModuleResponse> getModulesOfProf(@PathVariable(value = "profId", required = true) Long profId){
		return moduleService.getModulesOfProf(profId);
	}

	@GetMapping
	public List<ModuleResponse> getModules(){
		return moduleService.getModuleResponses();
	}

	@PostMapping("/")
	@PreAuthorize("hasRole('SCOLARITE')")
	public ModuleResponse createModule(@RequestBody CreateModuleRequest request) {
		return moduleService.saveModule(request);
	}
}
