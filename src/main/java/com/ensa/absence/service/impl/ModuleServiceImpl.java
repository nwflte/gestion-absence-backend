package com.ensa.absence.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.absence.payload.ModuleResponse;
import com.ensa.absence.repository.ModuleRepository;
import com.ensa.absence.repository.ProfesseurRepository;
import com.ensa.absence.service.ModuleService;
import com.ensa.absence.utils.ModelMapper;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;

	@Autowired
	private ProfesseurRepository professeurRepository;

	@Override
	public List<ModuleResponse> getModulesOfProf(Long profId) {
		return professeurRepository.findById(profId).get().getModules().stream()
				.map(m -> ModelMapper.mapModuleToModuleResponse(m)).collect(Collectors.toList());
	}

}
