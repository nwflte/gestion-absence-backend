package com.ensa.absence.service.impl;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.absence.domain.entity.Etudiant;
import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.domain.entity.Groupe;
import com.ensa.absence.domain.enums.GroupeCategorie;
import com.ensa.absence.repository.EtudiantRepository;
import com.ensa.absence.service.EtudiantService;
import com.ensa.absence.service.GroupeService;

@Service
public class EtudiantServiceImpl implements EtudiantService {

	@Autowired
	private EtudiantRepository etudiantRepository;

	@Autowired
	private GroupeService groupeService;

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
		Groupe groupeCours = new Groupe(filiere, GroupeCategorie.COURS, 0, Calendar.getInstance());
		groupeCours.addEtudiant(etudiant);
		groupeService.saveGroupe(groupeCours);
		// etudiantRepository.save(etudiant);
	}


}
