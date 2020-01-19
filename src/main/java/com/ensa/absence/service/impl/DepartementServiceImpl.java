package com.ensa.absence.service.impl;

import com.ensa.absence.domain.entity.Departement;
import com.ensa.absence.repository.DepartementRepository;
import com.ensa.absence.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementServiceImpl implements DepartementService {
	
	@Autowired
	private DepartementRepository departementRepository;
	
	@Override
	public Departement saveDepartement(Departement departement) {
		return departementRepository.save(departement);
	}

	@Override
	public List<Departement> getAllDepartements() {
		return departementRepository.findAll();
	}

}
