package com.ensa.absence.domain.entity;

import com.ensa.absence.domain.audit.ResponsableDateAudit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Objects;

/**
 * Classe representant une filière 
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
	@NaturalId
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

	@Override
	public int hashCode() {
		return Objects.hashCode(nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filiere other = (Filiere) obj;
		return Objects.equals(nom, other.getNom());
	}
	
}
