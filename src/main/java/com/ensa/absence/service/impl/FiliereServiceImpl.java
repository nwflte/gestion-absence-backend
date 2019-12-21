package com.ensa.absence.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.payload.FiliereResponse;
import com.ensa.absence.payload.ModelMapper;
import com.ensa.absence.repository.FiliereRepository;
import com.ensa.absence.repository.GroupeRepository;
import com.ensa.absence.service.FiliereService;

@Service
public class FiliereServiceImpl implements FiliereService {

	@Autowired
	private FiliereRepository filiereRepository;

	@Autowired
	private GroupeRepository groupeRepository;

	@Override
	public Filiere saveFiliere(Filiere filiere) {
		return filiereRepository.save(filiere);
	}

	@Override
	public Optional<Filiere> getFiliereById(Long id) {
		return filiereRepository.findById(id);
	}

	@Override
	public Filiere archiverFiliere(Filiere filiere) {
		// TODO Auto-generated method stub
		return null;
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
		return filiereRepository.findAll().stream().map(filiere -> ModelMapper.mapFiliereToFiliereResponse(filiere))
				.collect(Collectors.toList());
	}

}
