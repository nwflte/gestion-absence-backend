package com.ensa.absence.utils;

import com.ensa.absence.domain.entity.Etudiant;
import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.domain.entity.Groupe;
import com.ensa.absence.domain.entity.GroupeTD;
import com.ensa.absence.domain.entity.GroupeTP;
import com.ensa.absence.domain.entity.Module;
import com.ensa.absence.domain.entity.Seance;
import com.ensa.absence.payload.EtudiantResponse;
import com.ensa.absence.payload.FiliereResponse;
import com.ensa.absence.payload.GroupeResponse;
import com.ensa.absence.payload.ModuleResponse;
import com.ensa.absence.payload.SeanceResponse;

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

	public static SeanceResponse mapSeanceToSeanceResponse(Seance seance) {
		return new SeanceResponse(seance.getId(), mapModuleToModuleResponse(seance.getModule()),
				mapGroupeToGroupeResponse(seance.getGroupe()), seance.getType());
	}

	public static ModuleResponse mapModuleToModuleResponse(Module module) {
		return new ModuleResponse(module.getId(), module.getNom());
	}
}
