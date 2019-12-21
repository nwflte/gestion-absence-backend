package com.ensa.absence.payload;




import com.ensa.absence.domain.enums.GroupeCategorie;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GroupeResponse {
	
	private Long id;
	private GroupeCategorie categorie;
	private int semestreN1;
	private int semestreN2;
	
	 @JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer numero;
	
	public GroupeResponse(Long id, GroupeCategorie categorie, int semestreN1, int semestreN2) {
		super();
		this.id = id;
		this.categorie = categorie;
		this.semestreN1 = semestreN1;
		this.semestreN2 = semestreN2;
	}
	
	
}
