package com.ensa.absence.domain.entity;

import com.ensa.absence.domain.enums.OrdreSeance;
import com.ensa.absence.domain.enums.TypeSeance;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Class representant une séance (de cours, de TP ou de TD)
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Seance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/**
	 * Date de la séance (Année, mois et jour), Mapped to DATE dans la base de données
	 */
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	/**
	 * Enumeration : Ordre de la séance dans le jour (4 séances)
	 */
	private OrdreSeance ordre;
	/**
	 * Enumeration: Type de la seance (3 Types: COURS, TP, TD)
	 */
	private TypeSeance type;
	/**
	 * Le module enseigné dans cette séance
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private Module module;
	/**
	 * Groupe assistant la séance (groupe de TD, TP ou Cours)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private Groupe groupe;
	/**
	 * Enseignant de la séance
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private Professeur professeur;
	
	public Seance(Date date, OrdreSeance ordre, TypeSeance type, Module module, Groupe groupe,
			Professeur professeur) {
		super();
		this.date = date;
		this.ordre = ordre;
		this.type = type;
		this.module = module;
		this.groupe = groupe;
		this.professeur = professeur;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Seance))
			return false;
		return id != null && id.equals(((Seance) obj).getId());
	}

	@Override
	public int hashCode() {
		return 25;
	}
}
