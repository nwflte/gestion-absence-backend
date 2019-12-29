package com.ensa.absence.payload;

import com.ensa.absence.domain.enums.OrdreSeance;
import com.ensa.absence.domain.enums.TypeSeance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateSeanceRequest {
	
	private Long moduleId;
	private Long filiereId;
	private TypeSeance type;
	private Long groupeId;
	private OrdreSeance ordre;
	private Long professeurId;
	
	public CreateSeanceRequest(Long moduleId, Long filiereId, TypeSeance type, Long groupeId, OrdreSeance ordre,
			Long professeurId) {
		super();
		this.moduleId = moduleId;
		this.filiereId = filiereId;
		this.type = type;
		this.groupeId = groupeId;
		this.ordre = ordre;
		this.professeurId = professeurId;
	}
	
	
	
}
