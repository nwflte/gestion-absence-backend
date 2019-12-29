package com.ensa.absence.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.absence.domain.entity.Seance;
import com.ensa.absence.payload.CreateSeanceRequest;
import com.ensa.absence.payload.SeanceResponse;
import com.ensa.absence.repository.GroupeRepository;
import com.ensa.absence.repository.ModuleRepository;
import com.ensa.absence.repository.ProfesseurRepository;
import com.ensa.absence.repository.SeanceRepository;
import com.ensa.absence.service.SeanceService;
import com.ensa.absence.utils.ModelMapper;

@Service
public class SeanceServiceImpl implements SeanceService {

	@Autowired
	private SeanceRepository seanceRepository;

	@Autowired
	private GroupeRepository groupeRepository;

	@Autowired
	private ProfesseurRepository professeurRepository;

	@Autowired
	private ModuleRepository moduleRepository;

	@Override
	public List<SeanceResponse> getSeancesOfProf(Long profId) {
		List<Seance> seances = seanceRepository.findByProfesseur_Id(profId);
		return seances.stream().map(seance -> ModelMapper.mapSeanceToSeanceResponse(seance))
				.collect(Collectors.toList());
	}

	@Override
	public SeanceResponse saveSeanceByProf(CreateSeanceRequest request) {
		Seance seance = seanceRepository.save(new Seance(new Date(), request.getOrdre(), request.getType(),
				moduleRepository.findById(request.getModuleId()).get(),
				groupeRepository.findById(request.getGroupeId()).get(),
				professeurRepository.findById(request.getProfesseurId()).get()));
		
		return ModelMapper.mapSeanceToSeanceResponse(seance);
	}

}
