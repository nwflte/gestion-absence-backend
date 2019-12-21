package com.ensa.absence.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.domain.entity.Groupe;
import com.ensa.absence.payload.EtudiantResponse;
import com.ensa.absence.payload.GroupeResponse;
import com.ensa.absence.repository.FiliereRepository;
import com.ensa.absence.repository.GroupeRepository;
import com.ensa.absence.service.GroupeService;
import com.ensa.absence.utils.ModelMapper;

@Service
public class GroupeServiceImpl implements GroupeService {

	@Autowired
	private GroupeRepository groupeRepository;
	
	@Autowired
	private FiliereRepository filiereRepository;

	@Override
	public List<Groupe> getAllGroupes() {
		return groupeRepository.findAll();
	}

	@Override
	public Optional<Groupe> getGroupeById(Long id) {
		return groupeRepository.findById(id);
	}

	@Override
	public List<GroupeResponse> getGroupeResponsesByFiliere(Long filiereId) {
		Filiere filiere	= filiereRepository.findById(filiereId).get();
		return groupeRepository.findByFiliere(filiere).stream()
				.map(groupe -> ModelMapper.mapGroupeToGroupeResponse(groupe)).collect(Collectors.toList());
	}

	@Override
	public List<EtudiantResponse> getEtudiantsByGroupe(Long groupeId) {
		Groupe groupe = groupeRepository.findById(groupeId).get();
		return groupe.getEtudiants().stream().map(etudiant -> ModelMapper.mapEtudiantToEtudiantResponse(etudiant)).collect(Collectors.toList());
	}

}
