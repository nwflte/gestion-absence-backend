package com.ensa.absence.service;

import com.ensa.absence.domain.entity.AppUtilisateur;

public interface UserService {
    public AppUtilisateur getAppUtilisateurByUsername(String username);
}
