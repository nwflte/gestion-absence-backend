package com.ensa.absence.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreateModuleRequest {
    private Long filiereId;
    private String nom;
    private List<Long> professeurs;
}
