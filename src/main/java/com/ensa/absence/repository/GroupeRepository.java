package com.ensa.absence.repository;

import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.domain.entity.Groupe;
import com.ensa.absence.domain.enums.GroupeCategorie;

import java.util.List;

public interface GroupeRepository extends BaseRepository<Groupe, Long> {
	List<Groupe> findByFiliere(Filiere filiere);

	List<Groupe> findByFiliere_Id(Long filierefId);

	List<Groupe> findByFiliereAndCategorie(Filiere filiere, GroupeCategorie categorie);
}
