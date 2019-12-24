package com.ensa.absence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.absence.payload.SeanceResponse;
import com.ensa.absence.service.SeanceService;

@RestController
@RequestMapping("/api/seances")
public class SeanceController {
	
	@Autowired
	private SeanceService seanceService;
	
	@GetMapping("/professeur/{profId}")
	public List<SeanceResponse> getSeancesOfProf(@PathVariable(value = "profId", required = true) Long profId){
		return seanceService.getSeancesOfProf(profId);
	}
}
