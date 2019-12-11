package com.ensa.absence.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class representant un professeur
 * 
 * @author naouf
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Professeur extends Responsable {

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Module> modules = new HashSet<>();

	public void addModule(Module module) {
		modules.add(module);
		module.getProfesseurs().add(this);
	}

	public void removeModule(Module module) {
		modules.remove(module);
		module.getProfesseurs().remove(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Professeur))
			return false;
		return id != null && id.equals(((Professeur) obj).getId());
	}
	
	@Override
	public int hashCode() {
		return 33;
	}
}
