package com.ensa.absence.repository;

import java.util.List;

import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.domain.entity.Groupe;
import com.ensa.absence.projection.FiliereGroupesProjection;

public interface GroupeRepository extends BaseRepository<Groupe, Long> {
	List<Groupe> findByFiliere(Filiere filiere);
}
