package com.ensa.absence.payload;

import com.ensa.absence.domain.enums.TypeSeance;

public class SeanceResponse {
	
	private Long id;
	private ModuleResponse moduleResponse;
	private GroupeResponse groupeResponse;
	private TypeSeance type;
	
	public SeanceResponse(Long id, ModuleResponse moduleResponse, GroupeResponse groupeResponse, TypeSeance type) {
		super();
		this.id = id;
		this.moduleResponse = moduleResponse;
		this.groupeResponse = groupeResponse;
		this.type = type;
	}
	
	
	

}
