package com.ensa.absence.utils;

import com.ensa.absence.domain.entity.*;
import com.ensa.absence.domain.entity.Module;
import com.ensa.absence.payload.*;

public class ModelMapper {

	public static FiliereResponse mapFiliereToFiliereResponse(Filiere filiere) {
		return new FiliereResponse(filiere.getId(), filiere.getNom(), filiere.getDepartement());
	}

	public static GroupeResponse mapGroupeToGroupeResponse(Groupe groupe) {
		return new GroupeResponse(groupe.getId(), groupe.getCategorie(), groupe.getSemestreN1(), groupe.getSemestreN2(),
				groupe.getNumero());
	}

	public static EtudiantResponse mapEtudiantToEtudiantResponse(Etudiant etudiant) {
		return new EtudiantResponse(etudiant.getId(), etudiant.getNom(), etudiant.getPrenom(), etudiant.getImagePath(),
				etudiant.getUser().getUsername(), etudiant.getUser().getPassword());
	}

	public static SeanceResponse mapSeanceToSeanceResponse(Seance seance) {
		return new SeanceResponse(seance.getId(), seance.getDate(), seance.getOrdre(),
				mapModuleToModuleResponse(seance.getModule()), mapGroupeToGroupeResponse(seance.getGroupe()),
				seance.getType());
	}

	public static ModuleResponse mapModuleToModuleResponse(Module module) {
		return new ModuleResponse(module.getId(), module.getNom(), mapFiliereToFiliereResponse(module.getFiliere()));
	}

	public static AbsenceResponse mapAbsenceToAbsenceResponse(Absence absence) {
		AbsenceResponse ar = new AbsenceResponse(absence.getId(), mapEtudiantToEtudiantResponse(absence.getEtudiant()),
				absence.isJustifie(), "");
		if(absence.getJustification() != null) ar.setDescription(absence.getJustification().getDescription());
		return ar;
	}

    public static ProfesseurResponse mapProfesseurToProfesseurResponse(Professeur p) {
		return new ProfesseurResponse(p.getId(), p.getNom(), p.getPrenom(), p.getUser().getUsername(),
				p.getUser().getPassword());
    }
}
