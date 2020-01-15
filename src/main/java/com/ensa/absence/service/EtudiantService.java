package com.ensa.absence.service;

import com.ensa.absence.domain.entity.Etudiant;
import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.domain.entity.Groupe;
import com.ensa.absence.exception.EtudiantsExcelFileHasWrogFormat;
import com.ensa.absence.exception.ExcelFileCellNotKnown;
import com.ensa.absence.payload.AbsenceResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface EtudiantService {
	
	Optional<Etudiant> getEtudiantById(Long id);
	Etudiant saveEtudiant(Etudiant etudiant);
	Etudiant archiverEtudiant(Etudiant etudiant);


	/**
	 * Ajouter un étudiant à un groupe (de cours, TP ou TD). Si on veut faire passer
	 * l'étudiant à une nouvelle filière, utiliser addEtudiantToFiliere.
	 * 
	 * @param groupe
	 * @return true : Si la filiere du groupe correspond à la filiere de l'étudiant.
	 * 				  Si le groupe n'est pas dupliqué dans la liste des groupes l'étudiant
	 * 				  Si l'année universitaire du groupe correspond à l'année courante
	 *         false : sinon
	 */
	boolean addEtudiantToGroupe(Etudiant etudiant, Groupe groupe);

    /**
     * Ajouter un étudiant à une nouvelle filière.
     * Cette méthode va ajouter un nouveau groupe de cours de la filière pour l'étudiant.
     *
     * @param
     * @return
     */
    void addEtudiantToFiliere(Etudiant etudiant, Filiere filiere);


    void ajouterListEtudiantsExcel(String filiereOrGroupe, Long id, MultipartFile excelDataFile) throws ExcelFileCellNotKnown, EtudiantsExcelFileHasWrogFormat;

    List<AbsenceResponse> getAbsences(Long id);
}
