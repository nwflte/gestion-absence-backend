package com.ensa.absence.service;

import java.util.Date;
import java.util.List;

import com.ensa.absence.payload.CreateSeanceRequest;
import com.ensa.absence.payload.SeanceResponse;

public interface SeanceService {

	List<SeanceResponse> getSeancesOfProf(Long profId);

	SeanceResponse saveSeanceByProf(CreateSeanceRequest request);
	
	SeanceResponse getSeanceResponseById(Long seanceId);

	List<SeanceResponse> getSeancesOfProfByDate(Long profId, Date date);
}
