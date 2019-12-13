package com.ensa.absence.service;

import java.util.Optional;

import com.ensa.absence.domain.entity.Etudiant;
import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.domain.entity.Groupe;

public interface EtudiantService {
	
	Optional<Etudiant> getEtudiantById(Long id);
	Etudiant saveEtudiant(Etudiant etudiant);
	Etudiant archiverEtudiant(Etudiant etudiant);


	/**
	 * Ajouter un étudiant à un groupe (de cours, TP ou TD). Si on veut faire passer
	 * l'étudiant à une nouvelle filière, utiliser addEtudiantToFiliere.
	 * 
	 * @param groupe
	 * @return true : Si la filiere du groupe correspond à la filiere de l'étudiant.
	 * 				  Si le groupe n'est pas dupliqué dans la liste des groupes l'étudiant
	 * 				  Si l'année universitaire du groupe correspond à l'année courante
	 *         false : sinon
	 */
	boolean addEtudiantToGroupe(Etudiant etudiant, Groupe groupe);

	/**
	 * Ajouter un étudiant à une nouvelle filière.
	 * Cette méthode va ajouter un nouveau groupe de cours de la filière pour l'étudiant.
	 * @param groupeCours
	 * @return
	 */
	void addEtudiantToFiliere(Etudiant etudiant, Filiere filiere);
	
	
	
}
