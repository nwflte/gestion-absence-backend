package com.ensa.absence.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

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
public class Professeur implements AppUtilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String prenom;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Module> modules = new HashSet<>();
	
	public Professeur(String nom, String prenom, User user) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.user = user;
	}
	
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
		return 36;
	}

	

	
}
