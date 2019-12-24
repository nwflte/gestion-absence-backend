package com.ensa.absence.domain.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class representant un module
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Module {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * Nom du module
	 */
	@Column(nullable = false)
	private String nom;
	
	/**
	 * La filière dans laquelle le module est enseigné
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private Filiere filiere;
	
	/**
	 * Liste des professeurs enseignant ce module (Cours, TD ou TP par exemple).
	 */
	@ManyToMany(mappedBy = "modules")
	private Set<Professeur> professeurs = new HashSet<>();
	
	public Module(String nom, Filiere filiere) {
		super();
		this.nom = nom;
		this.filiere = filiere;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Module))
			return false;
		return Objects.equals(nom, ((Module) o).getNom());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}

	
}
