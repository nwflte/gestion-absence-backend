package com.ensa.absence.service;

import com.ensa.absence.domain.entity.Professeur;
import com.ensa.absence.exception.ExcelFileCellNotKnown;
import com.ensa.absence.exception.ProfesseursExcelFileHasWrogFormat;
import com.ensa.absence.payload.ProfesseurResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProfesseurService {
	
	Optional<Professeur> getProfesseurById(Long id);
	Professeur saveProfesseur(Professeur professeur);
	Professeur archiverProfesseur(Professeur professeur);

	void ajouterListProfesseursExcel(MultipartFile excelDataFile) throws ExcelFileCellNotKnown, ProfesseursExcelFileHasWrogFormat;

    List<ProfesseurResponse> getProfesseursResponses();
}
