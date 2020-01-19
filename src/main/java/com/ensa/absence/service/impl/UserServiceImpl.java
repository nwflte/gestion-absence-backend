package com.ensa.absence.service.impl;

import com.ensa.absence.domain.entity.AppUtilisateur;
import com.ensa.absence.domain.entity.Role;
import com.ensa.absence.domain.entity.User;
import com.ensa.absence.domain.enums.RoleName;
import com.ensa.absence.repository.*;
import com.ensa.absence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ProfesseurRepository professeurRepository;

    @Autowired
    private ResponsableScolariteRepository responsableScolariteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AppUtilisateur getAppUtilisateurByUsername(String username) {
        if (etudiantRepository.existsByUser_Username(username)) {
            return etudiantRepository.findByUser_Username(username);
        } else if (professeurRepository.existsByUser_Username(username)) {
            return professeurRepository.findByUser_Username(username);
        } else return responsableScolariteRepository.findByUser_Username(username);
    }

    @Override
    public User createEtudiantUser(String username, String password) {
        Role role = roleRepository.findByName(RoleName.ROLE_ETUDIANT);
        return userRepository.save(new User(username, new BCryptPasswordEncoder().encode(password), role));
    }

    @Override
    public User createProfesseurUser(String username, String password) {
        Role role = roleRepository.findByName(RoleName.ROLE_PROFESSEUR);
        return userRepository.save(new User(username, new BCryptPasswordEncoder().encode(password), role));
    }

    @Override
    public User createScolariteUser(String username, String password) {
        Role role = roleRepository.findByName(RoleName.ROLE_SCOLARITE);
        return userRepository.save(new User(username, new BCryptPasswordEncoder().encode(password), role));
    }
}
