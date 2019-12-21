package com.ensa.absence.domain.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.ensa.absence.domain.enums.GroupeCategorie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class representant un groupe de TP
 * @author naouf
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class GroupeTP extends Groupe {
	
	/**
	 * Le numero du groupe du TP
	 */
	private int numero;
	
	public GroupeTP(Filiere filiere, Calendar now, int numero) {
		super(filiere, now);
		this.numero = numero;
		categorie = GroupeCategorie.TP;
	}
	
}
