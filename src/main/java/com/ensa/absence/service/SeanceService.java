package com.ensa.absence.service;

import java.util.List;

import com.ensa.absence.payload.CreateSeanceRequest;
import com.ensa.absence.payload.SeanceResponse;

public interface SeanceService {

	List<SeanceResponse> getSeancesOfProf(Long profId);

	SeanceResponse saveSeanceByProf(CreateSeanceRequest request);

}
