package com.ensa.absence.service.impl;

import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.domain.entity.Groupe;
import com.ensa.absence.domain.enums.GroupeCategorie;
import com.ensa.absence.payload.CreateFiliereRequest;
import com.ensa.absence.payload.FiliereResponse;
import com.ensa.absence.repository.DepartementRepository;
import com.ensa.absence.repository.FiliereRepository;
import com.ensa.absence.repository.GroupeRepository;
import com.ensa.absence.service.FiliereService;
import com.ensa.absence.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FiliereServiceImpl implements FiliereService {

	@Autowired
	private FiliereRepository filiereRepository;

	@Autowired
	private DepartementRepository departementRepository;

	@Autowired
	private GroupeRepository groupeRepository;

	@Override
	public Filiere saveFiliere(Filiere filiere) {
		return filiereRepository.save(filiere);
	}

	@Override
	public FiliereResponse saveFiliere(CreateFiliereRequest request) {
		Filiere filiere = new Filiere(request.getNom(), departementRepository.findById(request.getDepartementId()).get());
		filiereRepository.save(filiere);
		Groupe newGroupeCours = new Groupe(filiere, GroupeCategorie.COURS,0, Calendar.getInstance());
		groupeRepository.save(newGroupeCours);
		return ModelMapper.mapFiliereToFiliereResponse(filiere);
	}

	@Override
	public List<Filiere> getAllFilieres() {
		return filiereRepository.findAll();
	}

	@Override
	public FiliereResponse getFiliereResponse(Long id) {
		return ModelMapper.mapFiliereToFiliereResponse(filiereRepository.findById(id).get());
	}

	@Override
	public List<FiliereResponse> getAllFilieresResponse() {
		return filiereRepository.findAll().stream().map(ModelMapper::mapFiliereToFiliereResponse)
				.collect(Collectors.toList());
	}

}
