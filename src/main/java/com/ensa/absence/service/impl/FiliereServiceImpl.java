package com.ensa.absence.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.repository.FiliereRepository;
import com.ensa.absence.service.FiliereService;

@Service
public class FiliereServiceImpl implements FiliereService {
	
	@Autowired
	private FiliereRepository filiereRepository;
	
	
	@Override
	public Filiere saveFiliere(Filiere filiere) {
		return filiereRepository.save(filiere);
	}


	@Override
	public Optional<Filiere> getFiliereById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Filiere archiverFiliere(Filiere filiere) {
		// TODO Auto-generated method stub
		return null;
	}

}
