package com.ensa.absence.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AbsenceResponse {

    private Long id;
    private EtudiantResponse etudiant;

    private boolean isJustifie;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private String description;

    private SeanceResponse seance;

    public AbsenceResponse(Long id, EtudiantResponse etudiant, boolean isJustifie, String description, SeanceResponse seance) {
        super();
        this.id = id;
        this.etudiant = etudiant;
        this.isJustifie = isJustifie;
        this.description = description;
        this.seance = seance;
    }


}
