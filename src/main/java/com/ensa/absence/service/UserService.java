package com.ensa.absence.service;

import com.ensa.absence.domain.entity.AppUtilisateur;
import com.ensa.absence.domain.entity.User;

public interface UserService {
    AppUtilisateur getAppUtilisateurByUsername(String username);

    User createEtudiantUser(String username, String password);

    User createProfesseurUser(String username, String password);

    User createScolariteUser(String username, String password);
}
