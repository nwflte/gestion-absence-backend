package com.ensa.absence.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EtudiantResponse {
	private Long id;
	private String nom;
	private String prenom;
	private String imagePath;
	private String cne;
	private String apogee;
	
	public EtudiantResponse(Long id, String nom, String prenom, String imagePath, String cne, String apogee) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.imagePath = imagePath;
		this.cne = cne;
		this.apogee = apogee;
	}
	
	
	
	
}
