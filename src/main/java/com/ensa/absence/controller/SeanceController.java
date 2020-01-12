package com.ensa.absence.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ensa.absence.payload.CreateSeanceRequest;
import com.ensa.absence.payload.SeanceResponse;
import com.ensa.absence.service.SeanceService;

@RestController
@RequestMapping("/api/seances")
public class SeanceController {
	
	@Autowired
	private SeanceService seanceService;
	
	/*@GetMapping("/professeur/{profId}")
	public List<SeanceResponse> getSeancesOfProf(@PathVariable(value = "profId", required = true) Long profId){
		return seanceService.getSeancesOfProf(profId);
	}*/

	@GetMapping("/professeur/{profId}")
	public List<SeanceResponse> getSeancesOfProfByDate(@PathVariable(value = "profId", required = true) Long profId,
													   @RequestParam(value = "date", required = false) String date){
		try {
			if(date != null && !date.equals(""))
				return  seanceService.getSeancesOfProfByDate(profId, new SimpleDateFormat("yyyy-MM-dd").parse(date));
			return  seanceService.getSeancesOfProfByDate(profId, new Date());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping("/creator/prof")
	public SeanceResponse createSeanceByProf(@RequestBody CreateSeanceRequest request) {
		return seanceService.saveSeanceByProf(request);
	}
	
	@GetMapping("/custom/{seanceId}")
	public SeanceResponse getSeance(@PathVariable(value = "seanceId", required = true) Long seanceId) {
		return seanceService.getSeanceResponseById(seanceId);
	}
}
