package com.ensa.absence.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Classe representant une absence.
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

	@Override
	public int hashCode() {
		return 17;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Absence other = (Absence) obj;
		return id != null && id.equals(other.getId());
	}

}
