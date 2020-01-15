package com.ensa.absence.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
	@NaturalId
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		return Objects.equals(nom, other.getNom());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}

	
}
