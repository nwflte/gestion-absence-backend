package com.ensa.absence.controller;

import com.ensa.absence.exception.EtudiantsExcelFileHasWrogFormat;
import com.ensa.absence.exception.ExcelFileCellNotKnown;
import com.ensa.absence.payload.AbsenceResponse;
import com.ensa.absence.payload.EtudiantResponse;
import com.ensa.absence.service.EtudiantService;
import com.ensa.absence.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping(value = "/import/{type}/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addListEtudiantFromExcel(@PathVariable(value = "type") String type, @PathVariable(value = "id") Long id,@RequestParam("file") MultipartFile excelDataFile){
        try {
            etudiantService.ajouterListEtudiantsExcel(type.toUpperCase(), id, excelDataFile);
        } catch (ExcelFileCellNotKnown excelFileCellNotKnown) {
            excelFileCellNotKnown.printStackTrace();
            return ResponseEntity.ok("Erreur s'est prevenu, possible que pas tous les etudiants sont ajoutes");
        } catch (EtudiantsExcelFileHasWrogFormat etudiantsExcelFileHasWrogFormat) {
            etudiantsExcelFileHasWrogFormat.printStackTrace();
            return ResponseEntity.ok("Erreur s'est prevenu, possible que le fichier n'a pas le bon format");
        }
        return ResponseEntity.ok(new String("test"));
    }

    @GetMapping("/{id}")
    public EtudiantResponse getEtudiant(@PathVariable(value = "id") Long id) {
        return ModelMapper.mapEtudiantToEtudiantResponse(etudiantService.getEtudiantById(id).get());
    }

    @GetMapping("{id}/absences")
    public List<AbsenceResponse> getAbsences(@PathVariable(value = "id") Long id) {
        return etudiantService.getAbsences(id);
    }

}
