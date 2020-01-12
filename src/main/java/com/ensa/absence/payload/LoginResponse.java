package com.ensa.absence.payload;

import com.ensa.absence.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponse {
    private String accessToken;
    private final String tokenType = "Bearer";
    private String username;
    private String nom;
    private String prenom;
    private String role;

    public LoginResponse(String accessToken, String username, String nom, String prenom, String role) {
        this.accessToken = accessToken;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }
}