package com.ensa.absence.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ensa.absence.domain.audit.ResponsableDateAudit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe representant une filière 
 * @author naouf
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Filiere extends ResponsableDateAudit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * Nom de la filière
	 */
	@Column(nullable = false)
	private String nom;
	
	/**
	 * Département à laquelle appartient la filiére
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	private Departement departement;

	public Filiere(String nom, Departement departement) {
		super();
		this.nom = nom;
		this.departement = departement;
	}
	
}
