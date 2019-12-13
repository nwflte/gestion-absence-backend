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
 * Class qui represente la justification d'une absence
 * @author naouf
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Justification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * L'absence sujet de la justification (Définit l'etudiant, la seance, celui qui l'a marqué...)
	 */
	@OneToOne
	private Absence absence;
	
	/**
	 * Le responsable (le professeur ou un respo scolarite) qui a accepté la justification
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private Responsable responsable;
}
