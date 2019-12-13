package com.ensa.absence.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.absence.domain.entity.Professeur;
import com.ensa.absence.repository.ProfesseurRepository;
import com.ensa.absence.service.ProfesseurService;

@Service
public class ProfesseurServiceImpl implements ProfesseurService{
	
	@Autowired
	private ProfesseurRepository professeurRepository;
	
	
	@Override
	public Professeur saveProfesseur(Professeur professeur) {
		return professeurRepository.save(professeur);
	}


	@Override
	public Optional<Professeur> getProfesseurById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Professeur archiverProfesseur(Professeur professeur) {
		// TODO Auto-generated method stub
		return null;
	}

}
