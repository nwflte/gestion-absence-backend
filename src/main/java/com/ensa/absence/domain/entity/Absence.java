package com.ensa.absence.domain.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe representant une absence.
 * 
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Absence {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Etudiant sujet de l'absence
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Etudiant etudiant;
	/**
	 * La seance sujet de l'absence (Definie par le type, date, ordre de la seance,
	 * moduleet groupe)
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Seance seance;

	
	private boolean isJustifie;
	
	/**
	 * La justification de l'absence. prend null s'il aucune n'est fournie.
	 */
	@OneToOne
	private Justification justification;

	public Absence(Etudiant etudiant, Seance seance, boolean isJustifie, Justification justification) {
		super();
		this.etudiant = etudiant;
		this.seance = seance;
		this.isJustifie = isJustifie;
		this.justification = justification;
	}
	
	

}
