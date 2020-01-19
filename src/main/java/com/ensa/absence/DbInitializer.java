package com.ensa.absence;

import com.ensa.absence.domain.entity.Module;
import com.ensa.absence.domain.entity.*;
import com.ensa.absence.domain.enums.GroupeCategorie;
import com.ensa.absence.domain.enums.OrdreSeance;
import com.ensa.absence.domain.enums.RoleName;
import com.ensa.absence.domain.enums.TypeSeance;
import com.ensa.absence.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitializer implements CommandLineRunner {

	private final String password = "password";

	private Random random = SecureRandom.getInstanceStrong();

	@Autowired
	private FiliereRepository filiereRepository;

	@Autowired
	private DepartementRepository departementRepository;

	@Autowired
	private GroupeRepository groupeRepository;

	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private ProfesseurRepository professeurRepository;
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	@Autowired
	private SeanceRepository seanceRepository;

	@Autowired
	private AbsenceRepository absenceRepository;

	@Autowired
	private ResponsableScolariteRepository responsableScolariteRepository;

	@Autowired
	private RoleRepository roleRepository;

	public DbInitializer() throws NoSuchAlgorithmException {
	}

	@Override
	public void run(String... strings) throws Exception {
		if (filiereRepository.existsById(1L))
			return;

		/// Initialise Departement et filieres
		Departement dep1 = new Departement("GI", null);
		Departement dep2 = new Departement("GE", null);

		Filiere fil1 = new Filiere("Genie Logiciel", dep1);
		Filiere fil2 = new Filiere("Genie Electronique", dep2);


		filiereRepository.saveAll(Arrays.asList(fil1, fil2));


		// Initialise groupes
		Groupe gc1 = new Groupe(fil1, GroupeCategorie.COURS, 0, Calendar.getInstance());
		Groupe gtd1 = new Groupe(fil1, GroupeCategorie.TD, 1, Calendar.getInstance());
		Groupe gtd2 = new Groupe(fil1, GroupeCategorie.TD, 2, Calendar.getInstance());
		Groupe gtp1 = new Groupe(fil1, GroupeCategorie.TP, 1 ,Calendar.getInstance());
		Groupe gtp2 = new Groupe(fil1, GroupeCategorie.TP, 2 ,Calendar.getInstance());

		List<Groupe> groupes = Arrays.asList(gc1, gtd1, gtd2, gtp1, gtp2);
		
		/// Initialise Etudiants
		for (int i = 0; i < 14; i++) {
			User user = new User(generateRandString(), new BCryptPasswordEncoder().encode(password));
			user.getRoles().add(roleRepository.findByName(RoleName.ROLE_ETUDIANT));
			Etudiant etudiant = new Etudiant(generateRandString(), generateRandString(), "", user, fil1);
			gc1.addEtudiant(etudiant);
			if (i % 2 == 0) {
				gtd1.addEtudiant(etudiant);
				gtp1.addEtudiant(etudiant);
			} else {
				gtd2.addEtudiant(etudiant);
				gtp2.addEtudiant(etudiant);
			}
			etudiantRepository.save(etudiant);
		}
		groupeRepository.saveAll(groupes);
		
		//////// Initialise Profs
		for (int i = 0; i < 2; i++) {
			User user = new User(generateRandString(), new BCryptPasswordEncoder().encode(password));
			user.getRoles().add(roleRepository.findByName(RoleName.ROLE_PROFESSEUR));
			Professeur professeur = new Professeur(generateRandString(), generateRandString(), user);
			Module module = new Module(generateRandString(), fil1);
			Module module2 = new Module(generateRandString(), fil1);
			professeur.addModule(module);
			professeur.addModule(module2);
			professeurRepository.save(professeur);
		}
				
		/// Init Seances
		Module module = moduleRepository.findAll().get(0);
		Professeur prof = professeurRepository.findAll().get(0);
		for (int i = 0; i < 4; i++) {	
			Seance seance = new Seance(new Date(), OrdreSeance.PREMIERE, TypeSeance.COURS, module, gc1, prof );
			seanceRepository.save(seance);
		}
		
		/// Init absences
		Seance seance = seanceRepository.findAll().get(0);
		for(int i = 0; i < 5; i++) {
			Iterator<Etudiant> it = gc1.getEtudiants().iterator();
			int j = 0;
			while (j != i) {
				j++;
				it.next();
			}
			Etudiant et = it.next();
			Absence absence = new Absence(et, seance, false, null);
			absenceRepository.save(absence);
		}

		//Init Respo
		User respoUser = new User("respo", new BCryptPasswordEncoder().encode(password));
		respoUser.getRoles().add(roleRepository.findByName(RoleName.ROLE_SCOLARITE));
		ResponsableScolarite responsableScolarite = new ResponsableScolarite("respo", "respo", respoUser);
		responsableScolariteRepository.save(responsableScolarite);

		System.out.println(" -- Database has been initialized");
	}

	private String generateRandString() {

		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 6;
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		return buffer.toString();
	}

}