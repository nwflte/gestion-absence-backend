package com.ensa.absence.payload;

import java.util.Date;

import com.ensa.absence.domain.enums.OrdreSeance;
import com.ensa.absence.domain.enums.TypeSeance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SeanceResponse {
	
	private Long id;
	private Date date;
	private OrdreSeance ordre;
	private ModuleResponse module;
	private GroupeResponse groupe;
	private TypeSeance type;
	
	
	public SeanceResponse(Long id, Date date, OrdreSeance ordre, ModuleResponse module, GroupeResponse groupe,
			TypeSeance type) {
		super();
		this.id = id;
		this.date = date;
		this.ordre = ordre;
		this.module = module;
		this.groupe = groupe;
		this.type = type;
	}
	
	
	
	

}
