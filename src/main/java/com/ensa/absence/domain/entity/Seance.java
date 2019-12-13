package com.ensa.absence.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ensa.absence.domain.enums.OrdreSeance;
import com.ensa.absence.domain.enums.TypeSeance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class representant une séance (de cours, de TP ou de TD)
 * @author naouf
 *
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
}
