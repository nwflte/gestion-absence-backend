package com.ensa.absence.constants;

public class GeneralConstants {

    public static final String JWT_SECRET = "JWTSuperSecretKey";
    public static final int JWT_EXPIRATION_IN_MS = 604800000;
    public static final String TOKEN_TYPE = "Bearer";

    private GeneralConstants() {

    }

    public static final String ROLE_PREFFIX = "ROLE_";
    public static final String ROLE_ETUDIANT = ROLE_PREFFIX + "ETUDIANT";
    public static final String ROLE_PROF = ROLE_PREFFIX + "PROF";
    public static final String ROLE_RESPO = ROLE_PREFFIX + "RESPO";
}
