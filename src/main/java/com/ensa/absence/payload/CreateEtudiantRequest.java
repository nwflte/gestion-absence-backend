package com.ensa.absence.payload;

import lombok.Data;

@Data
public class CreateEtudiantRequest {
    private String nom;
    private String prenom;
    private String cne;
    private String apogee;
    private Long filiere;
    private Long groupe;
}
