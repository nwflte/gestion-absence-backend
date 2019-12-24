package com.ensa.absence.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe representant un responsable de scolarite
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ResponsableScolarite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
}
