package com.ensa.absence.domain.entity;

import java.util.Calendar;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class representant un groupe de cours
 * 
 * @author naouf
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class GroupeCours extends Groupe {
	public GroupeCours(Filiere filiere, Calendar now) {
		super(filiere, now);
	}

}
