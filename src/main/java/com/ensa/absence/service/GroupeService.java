package com.ensa.absence.service;

import com.ensa.absence.domain.entity.Groupe;
import com.ensa.absence.payload.EtudiantResponse;
import com.ensa.absence.payload.GroupeResponse;

import java.util.List;
import java.util.Optional;


public interface GroupeService {
    List<Groupe> getAllGroupes();

    Optional<Groupe> getGroupeById(Long id);

    List<GroupeResponse> getGroupeResponsesByFiliere(Long filiereId);

    List<EtudiantResponse> getEtudiantsByGroupe(Long groupeId);

    Groupe saveGroupe(Groupe groupeCours);

    List<GroupeResponse> getGroupesOfFiliere(Long filierefId);
}
