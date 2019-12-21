package com.ensa.absence.utils;

import java.util.Set;

import com.ensa.absence.domain.entity.Etudiant;
import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.domain.entity.Groupe;
import com.ensa.absence.domain.entity.GroupeCours;
import com.ensa.absence.domain.entity.GroupeTD;
import com.ensa.absence.domain.entity.GroupeTP;
import com.ensa.absence.payload.EtudiantResponse;
import com.ensa.absence.payload.FiliereResponse;
import com.ensa.absence.payload.GroupeResponse;

public class ModelMapper {

	public static FiliereResponse mapFiliereToFiliereResponse(Filiere filiere) {
		return new FiliereResponse(filiere.getId(), filiere.getNom(), filiere.getDepartement());
	}

	public static GroupeResponse mapGroupeToGroupeResponse(Groupe groupe) {
		GroupeResponse response = new GroupeResponse(groupe.getId(), groupe.getCategorie(), groupe.getSemestreN1(),
				groupe.getSemestreN2());
		if (groupe instanceof GroupeTD)
			response.setNumero(((GroupeTD) groupe).getNumero());
		else if (groupe instanceof GroupeTP)
			response.setNumero(((GroupeTP) groupe).getNumero());
		return response;
	}

	public static EtudiantResponse mapEtudiantToEtudiantResponse(Etudiant etudiant) {
		return new EtudiantResponse(etudiant.getId(), etudiant.getNom(), etudiant.getPrenom(), etudiant.getImagePath(),
				etudiant.getUser().getUsername(), etudiant.getUser().getPassword());
	}
}
