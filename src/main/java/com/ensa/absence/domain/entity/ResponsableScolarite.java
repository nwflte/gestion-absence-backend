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
public class ResponsableScolarite implements AppUtilisateur{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	public ResponsableScolarite(String nom, String prenom, User user) {
		this.nom = nom;
		this.prenom = prenom;
		this.user = user;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ResponsableScolarite))
			return false;
		return id != null && id.equals(((ResponsableScolarite) obj).getId());
	}

	@Override
	public int hashCode() {
		return 22;
	}
}
