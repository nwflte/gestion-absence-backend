package com.ensa.absence.controller;

import com.ensa.absence.exception.ExcelFileCellNotKnown;
import com.ensa.absence.exception.ProfesseursExcelFileHasWrogFormat;
import com.ensa.absence.payload.ProfesseurResponse;
import com.ensa.absence.service.ProfesseurService;
import com.ensa.absence.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;

    @PostMapping("/import")
    public ResponseEntity<?> addListProfesseursFromExcel(@RequestParam("file") MultipartFile excelDataFile){

        try {
            professeurService.ajouterListProfesseursExcel(excelDataFile);
        } catch (ExcelFileCellNotKnown excelFileCellNotKnown) {
            excelFileCellNotKnown.printStackTrace();
            return ResponseEntity.ok("Erreur s'est prevenu, possible que pas tous les profs sont ajoutes");
        } catch (ProfesseursExcelFileHasWrogFormat professeursExcelFileHasWrogFormat) {
            professeursExcelFileHasWrogFormat.printStackTrace();
            return ResponseEntity.ok("Erreur s'est prevenu, possible que le fichier n'a pas le bon format");
        }
        return ResponseEntity.ok(new String("SUCCESS"));
    }

    @GetMapping("/list")
    public List<ProfesseurResponse> getProfesseurs() {
        return professeurService.getProfesseursResponses();
    }

    @GetMapping("/{id}")
    public ProfesseurResponse getProfesseur(@PathVariable(value = "id") Long id){
        return ModelMapper.mapProfesseurToProfesseurResponse(professeurService.getProfesseurById(id).get());
    }

}
