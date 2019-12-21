package com.ensa.absence;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ensa.absence.domain.entity.Departement;
import com.ensa.absence.domain.entity.Etudiant;
import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.domain.entity.GroupeTP;
import com.ensa.absence.domain.entity.Professeur;
import com.ensa.absence.domain.entity.User;
import com.ensa.absence.service.DepartementService;
import com.ensa.absence.service.EtudiantService;
import com.ensa.absence.service.FiliereService;
import com.ensa.absence.service.GroupeCoursService;
import com.ensa.absence.service.ProfesseurService;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@SpringBootTest
@Transactional
public class EtudiantServiceImplTest {
	
	@Autowired
	private EtudiantService etudiantService;
	
	@Autowired
	private ProfesseurService professeurService;
	
	@Autowired
	private DepartementService departementService;
	
	@Autowired
	private FiliereService filiereService;
	
	@Autowired
	private GroupeCoursService groupeCoursService;
	
	Etudiant etudiant;
	Filiere filiere;
	Departement departement;
	Professeur professeur;
	User userEtudiant;
	User userProf;
	
	@Test
	public void contextLoads() {
	}
	
	@Before
	public void setup() {
		etudiant = new Etudiant();
		etudiant.setNom("Temmar");
		etudiant.setPrenom("Naoufal");
		etudiant.setArchived(false);
		userEtudiant = new User();
		userEtudiant.setUsername("etudiant");
		userEtudiant.setPassword("etudiant");
		etudiant.setUser(userEtudiant);
		
		etudiantService.saveEtudiant(etudiant);
		
		professeur = new Professeur();
		professeur.setNom("Saadi");
		professeur.setPrenom("Moustafa");
		userProf = new User();
		userProf.setUsername("professeur");
		userProf.setPassword("professeur");
		professeur.setUser(userProf);
		
		professeurService.saveProfesseur(professeur);
		
		departement = new Departement();
		departement.setNom("Genie Informatique");
		departement.setChefDeDepartement(professeur);
		
		departementService.saveDepartement(departement);
		
		filiere = new Filiere();
		filiere.setNom("Genie Logiciel");
		filiere.setDepartement(departement);
		
		filiereService.saveFiliere(filiere);
	}
	
	@Test
	@Rollback
	public void when_adding_filiere_to_etudiant_groupe_cours_should_be_added() {
		
		assertThat(etudiant.getFiliere()).isNull();
		etudiantService.addEtudiantToFiliere(etudiant, filiere);
		assertThat(etudiant.getFiliere().getNom()).isEqualTo("Genie Logiciel");
		assertThat(etudiant.getGroupes()).extracting("filiere").containsOnlyOnce(filiere);
		
	}
	
	@Test
	@Rollback
	public void when_adding_new_group_tp_ou_td_pas_duplique_de_meme_filiere_success() {
		assertThat(etudiant.getFiliere()).isNull();
		etudiantService.addEtudiantToFiliere(etudiant, filiere);
		assertThat(etudiant.getFiliere().getNom()).isEqualTo("Genie Logiciel");
		GroupeTP groupeTP = new GroupeTP();
		groupeTP.setFiliere(filiere);
		groupeTP.setNumero(4);
		groupeTP.setSemestreN1(2019);
		groupeTP.setSemestreN2(2020);
		
		etudiantService.addEtudiantToGroupe(etudiant, groupeTP);
		assertThat(etudiant.getGroupes()).hasSize(2);
	}
}
