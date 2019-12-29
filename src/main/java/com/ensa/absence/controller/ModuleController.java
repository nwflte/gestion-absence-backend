package com.ensa.absence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.absence.payload.ModuleResponse;
import com.ensa.absence.repository.ModuleRepository;
import com.ensa.absence.service.ModuleService;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {
	
	@Autowired
	private ModuleService moduleService;
	
	@GetMapping("/professeur/{profId}")
	public List<ModuleResponse> getModulesOfProf(@PathVariable(value = "profId", required = true) Long profId){
		return moduleService.getModulesOfProf(profId);
	}
}
