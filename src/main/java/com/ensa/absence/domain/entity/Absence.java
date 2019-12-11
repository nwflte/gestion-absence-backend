package com.ensa.absence.domain.entity;

import javax.persistence.Column;
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
 * @author naouf
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
	/**
	 * Le responsable qui a enregistrer l'absence dans le systeme (Professeur ou un
	 * respo scolarite)
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Responsable responsable;
	/**
	 * La justification de l'absence. prend null s'il aucune n'est fournie.
	 */
	@OneToOne
	private Justification justification;

}
