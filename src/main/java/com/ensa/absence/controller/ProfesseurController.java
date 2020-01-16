package com.ensa.absence.controller;

import com.ensa.absence.domain.entity.Professeur;
import com.ensa.absence.domain.entity.User;
import com.ensa.absence.domain.enums.RoleName;
import com.ensa.absence.exception.ExcelFileCellNotKnown;
import com.ensa.absence.exception.ProfesseursExcelFileHasWrogFormat;
import com.ensa.absence.payload.CreateProfesseurRequest;
import com.ensa.absence.payload.ProfesseurResponse;
import com.ensa.absence.repository.RoleRepository;
import com.ensa.absence.service.ProfesseurService;
import com.ensa.absence.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;

    @Autowired
    private RoleRepository roleRepository;


    @PostMapping("/import")
    public ResponseEntity<?> addListProfesseursFromExcel(@RequestParam("file") MultipartFile excelDataFile) {

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
    public ProfesseurResponse getProfesseur(@PathVariable(value = "id") Long id) {
        return ModelMapper.mapProfesseurToProfesseurResponse(professeurService.getProfesseurById(id).get());
    }

    @PostMapping
    public ProfesseurResponse addProfesseur(@RequestBody CreateProfesseurRequest request) {
        User user = new User(request.getCin(), new BCryptPasswordEncoder().encode(request.getCode()));
        user.getRoles().add(roleRepository.findByName(RoleName.ROLE_PROFESSEUR));
        Professeur professeur = new Professeur(request.getNom(), request.getPrenom(), user);
        professeurService.saveProfesseur(professeur);
        return ModelMapper.mapProfesseurToProfesseurResponse(professeur);
    }

}
