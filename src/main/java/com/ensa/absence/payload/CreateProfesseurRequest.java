package com.ensa.absence.payload;

import lombok.Data;

@Data
public class CreateProfesseurRequest {
    private String nom;
    private String prenom;
    private String cin;
    private String code;
}
