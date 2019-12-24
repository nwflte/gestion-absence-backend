package com.ensa.absence.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class representant un département
 * 
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Departement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Nom du département
	 */
	@Column(nullable = false)
	private String nom;

	/**
	 * Professeur chef du département
	 */
	@OneToOne
	private Professeur chefDeDepartement;

	public Departement(String nom, Professeur chefDeDepartement) {
		super();
		this.nom = nom;
		this.chefDeDepartement = chefDeDepartement;
	}
	
	
}
