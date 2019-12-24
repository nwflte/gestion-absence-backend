package com.ensa.absence.domain.entity;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.ensa.absence.domain.enums.GroupeCategorie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class abstraite representant un groupe d'etudiant qui peut assiter à une
 * séance donnée Peut etre: Groupe de TD, de Cours ou de TP.
 * 
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Groupe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * La filière du groupe
	 */
	@ManyToOne
	private Filiere filiere;
	
	private GroupeCategorie categorie;
	
	private int numero;
	
	/**
	 * L'annee universitaire du premier semestre
	 */
	@Column(nullable = false)
	private int semestreN1;
	/**
	 * L'annee universitaire du deuxieme semestre
	 */
	@Column(nullable = false)
	private int semestreN2;

	/**
	 * Les étudiants du groupe
	 */
	@ManyToMany(cascade = { CascadeType.MERGE })
	private Set<Etudiant> etudiants = new HashSet<>(0);

	public Groupe(Filiere filiere, GroupeCategorie categorie, int numero, Calendar now) {
		this.filiere = filiere;
		this.categorie = categorie;
		this.numero = numero;
		
		int month = now.get(Calendar.MONTH) + 1;
		if (month >= 1 && month <= 7) {
			semestreN1 = now.get(Calendar.YEAR) - 1;
			semestreN2 = now.get(Calendar.YEAR);
		} else {
			semestreN1 = now.get(Calendar.YEAR);
			semestreN2 = now.get(Calendar.YEAR) + 1;
		}
	}

	public void addEtudiant(Etudiant etudiant) {
		if (etudiants.contains(etudiant))
			return;
		etudiants.add(etudiant);
		etudiant.getGroupes().add(this);
	}

	public void removeEtudiant(Etudiant etudiant) {
		if (!etudiants.contains(etudiant))
			return;
		etudiants.remove(etudiant);
		etudiant.getGroupes().remove(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Groupe))
			return false;
		return id != null && id.equals(((Groupe) obj).getId());
	}

	@Override
	public int hashCode() {
		return 31;
	}
}
