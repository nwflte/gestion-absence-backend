package com.ensa.absence.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.absence.domain.entity.Etudiant;
import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.domain.entity.Groupe;
import com.ensa.absence.domain.entity.GroupeCours;
import com.ensa.absence.payload.EtudiantResponse;
import com.ensa.absence.repository.EtudiantRepository;
import com.ensa.absence.service.EtudiantService;
import com.ensa.absence.service.GroupeCoursService;

@Service
public class EtudiantServiceImpl implements EtudiantService {

	@Autowired
	private EtudiantRepository etudiantRepository;

	@Autowired
	private GroupeCoursService groupeCoursService;

	@Override
	public Optional<Etudiant> getEtudiantById(Long id) {
		return etudiantRepository.findById(id);
	}

	@Override
	public boolean addEtudiantToGroupe(Etudiant etudiant, Groupe groupe) {
		if (etudiant.getFiliere() != groupe.getFiliere())
			return false;
		if (etudiant.getGroupes().stream()
				.anyMatch(gr -> gr.getSemestreN1() == groupe.getSemestreN1() && gr.getClass() == groupe.getClass()))
			return false;
		groupe.addEtudiant(etudiant);
		return true;
	}

	@Override
	public Etudiant saveEtudiant(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}

	@Override
	public Etudiant archiverEtudiant(Etudiant etudiant) {
		etudiant.setArchived(true);
		etudiantRepository.save(etudiant);
		return etudiant;
	}

	@Override
	public void addEtudiantToFiliere(Etudiant etudiant, Filiere filiere) {
		if (etudiant.getFiliere() != null && etudiant.getFiliere().equals(filiere))
			return;
		etudiant.setFiliere(filiere);
		GroupeCours groupeCours = new GroupeCours(filiere, Calendar.getInstance());
		groupeCours.addEtudiant(etudiant);
		groupeCoursService.saveGroupeCours(groupeCours);
		// etudiantRepository.save(etudiant);
	}


}
