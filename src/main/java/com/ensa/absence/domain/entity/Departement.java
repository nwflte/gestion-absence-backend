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
import org.hibernate.annotations.NaturalId;

import java.util.Objects;

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
	@NaturalId
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

	@Override
	public int hashCode() {
		return Objects.hashCode(nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departement other = (Departement) obj;
		return Objects.equals(nom, other.getNom());
	}
}
