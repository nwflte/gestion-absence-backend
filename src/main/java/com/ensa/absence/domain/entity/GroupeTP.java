package com.ensa.absence.domain.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

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
	 * Le groupe de cours à lequel appartient le groupe de TP
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	private GroupeCours groupeCours;
	
	/**
	 * Le numero du groupe du TD
	 */
	private int numero;
}
