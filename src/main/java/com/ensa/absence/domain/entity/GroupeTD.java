package com.ensa.absence.domain.entity;

import java.util.Calendar;

import javax.persistence.Entity;

import com.ensa.absence.domain.enums.GroupeCategorie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class representant un groupe de TD
 * @author naouf
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class GroupeTD extends Groupe {
	
	/**
	 * Le numero du groupe du TD
	 */
	private int numero;

	public GroupeTD(Filiere filiere, Calendar now, int numero) {
		super(filiere, now);
		this.numero = numero;
		categorie = GroupeCategorie.TD;
	}
	
}
