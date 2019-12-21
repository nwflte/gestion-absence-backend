package com.ensa.absence.domain.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.ensa.absence.domain.audit.ResponsableDateAudit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class representant un etudiant
 * 
 * @author naouf
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Etudiant extends ResponsableDateAudit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Nom et prenom de l'etudiant
	 */
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	
	private String imagePath;

	/**
	 * Objet User coontenant les identifiants de l'étudiant (CNE et numero Apogee)
	 */
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@ManyToOne
	private Filiere filiere;
	
	/**
	 * Les groupes à lesquel appartient l'étudiant (Groupe de cours, facultativement
	 * un groupe de TD et/ou TP)
	 * Peut appartenir au maximum à un seul groupe de chaque type
	 */
	@ManyToMany(mappedBy = "etudiants", cascade = {CascadeType.MERGE})
	private Set<Groupe> groupes = new HashSet<>();
	
	private boolean archived;
	
	public Etudiant(String nom, String prenom, String imagePath, User user, Filiere filiere) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.imagePath = imagePath;
		this.user = user;
		this.filiere = filiere;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Etudiant))
			return false;
		return Objects.equals(user.getUsername(), ((Etudiant) o).getUser().getUsername());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(user.getUsername());
	}
}
