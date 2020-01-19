package com.ensa.absence.service;

import com.ensa.absence.payload.CreateSeanceRequest;
import com.ensa.absence.payload.SeanceResponse;

import java.util.Date;
import java.util.List;

public interface SeanceService {

    List<SeanceResponse> getSeancesOfProf(Long profId);

    SeanceResponse saveSeanceByProf(CreateSeanceRequest request);

    SeanceResponse getSeanceResponseById(Long seanceId);

    List<SeanceResponse> getSeancesOfProfByDate(Long profId, Date date);
}
