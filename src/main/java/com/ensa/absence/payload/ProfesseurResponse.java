package com.ensa.absence.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfesseurResponse {
    private Long id;
    private String nom;
    private String prenom;
    private String cin;
    private String code;

    public ProfesseurResponse(Long id, String nom, String prenom, String cin, String code) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.code = code;
    }
}
