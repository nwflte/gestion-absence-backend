package com.ensa.absence.payload;


import com.ensa.absence.domain.entity.Departement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FiliereResponse {
	
	private Long id;
	private String nom;
	private Departement departement;
	public FiliereResponse(Long id, String nom, Departement departement) {
		super();
		this.id = id;
		this.nom = nom;
		this.departement = departement;
	}
	
	
}
