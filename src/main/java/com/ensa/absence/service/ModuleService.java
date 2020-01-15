package com.ensa.absence.service;

import com.ensa.absence.payload.CreateModuleRequest;
import com.ensa.absence.payload.ModuleResponse;

import java.util.List;

public interface ModuleService {

	List<ModuleResponse> getModulesOfProf(Long profId);

    List<ModuleResponse> getModuleResponses();

    ModuleResponse saveModule(CreateModuleRequest request);
}
