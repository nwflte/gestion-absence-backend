package com.ensa.absence.service;

import java.util.List;

import com.ensa.absence.payload.ModuleResponse;

public interface ModuleService {

	List<ModuleResponse> getModulesOfProf(Long profId);

}
