package com.ensa.absence.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModuleResponse {
	
	private Long id;
	private String nom;
	private FiliereResponse filiere;
	
	public ModuleResponse(Long id, String nom, FiliereResponse filiere) {
		super();
		this.id = id;
		this.nom = nom;
		this.filiere = filiere;
	}

}
