package com.ensa.absence.service.impl;

import com.ensa.absence.domain.entity.Module;
import com.ensa.absence.payload.CreateModuleRequest;
import com.ensa.absence.payload.ModuleResponse;
import com.ensa.absence.repository.FiliereRepository;
import com.ensa.absence.repository.ModuleRepository;
import com.ensa.absence.repository.ProfesseurRepository;
import com.ensa.absence.service.ModuleService;
import com.ensa.absence.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;

	@Autowired
	private ProfesseurRepository professeurRepository;

	@Autowired
	private FiliereRepository filiereRepository;

	@Override
	public List<ModuleResponse> getModulesOfProf(Long profId) {
		return professeurRepository.findById(profId).get().getModules().stream()
				.map(m -> ModelMapper.mapModuleToModuleResponse(m)).collect(Collectors.toList());
	}

	@Override
	public List<ModuleResponse> getModuleResponses() {
		return moduleRepository.findAll().stream().map(m -> ModelMapper.mapModuleToModuleResponse(m))
				.collect(Collectors.toList());
	}

	@Override
	public ModuleResponse saveModule(CreateModuleRequest request) {
		Module module = new Module(request.getNom(), filiereRepository.findById(request.getFiliereId()).get());
		moduleRepository.save(module);
		return ModelMapper.mapModuleToModuleResponse(module);
	}

}
