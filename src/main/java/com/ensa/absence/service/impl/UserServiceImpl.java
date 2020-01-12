package com.ensa.absence.service.impl;

import com.ensa.absence.domain.entity.AppUtilisateur;
import com.ensa.absence.repository.EtudiantRepository;
import com.ensa.absence.repository.ProfesseurRepository;
import com.ensa.absence.repository.ResponsableScolariteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.absence.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ProfesseurRepository professeurRepository;

    @Autowired
    private ResponsableScolariteRepository responsableScolariteRepository;

    @Override
    public AppUtilisateur getAppUtilisateurByUsername(String username) {
        if(etudiantRepository.existsByUser_Username(username)){
            return etudiantRepository.findByUser_Username(username);
        }
        else if(professeurRepository.existsByUser_Username(username)){
            return professeurRepository.findByUser_Username(username);
        }
        else return responsableScolariteRepository.findByUser_Username(username);
    }
}
