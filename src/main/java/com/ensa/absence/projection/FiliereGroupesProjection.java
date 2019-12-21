package com.ensa.absence.projection;

import java.util.Set;

import org.springframework.data.rest.core.config.Projection;

import com.ensa.absence.domain.entity.Etudiant;
import com.ensa.absence.domain.entity.Groupe;

@Projection(
		name = "filiereGroupe", 
		  types = { Groupe.class })
public interface FiliereGroupesProjection {
	Long getId();
	String getGroupeCategorie();
	int getSemestre1();
	int getSemestre2();
	Set<Etudiant> getEtudiants();
}	
