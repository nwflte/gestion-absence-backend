package com.ensa.absence;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.ensa.absence.domain.entity.Departement;
import com.ensa.absence.domain.entity.Etudiant;
import com.ensa.absence.domain.entity.Filiere;
import com.ensa.absence.domain.entity.Groupe;
import com.ensa.absence.domain.entity.GroupeCours;
import com.ensa.absence.domain.entity.GroupeTD;
import com.ensa.absence.domain.entity.GroupeTP;
import com.ensa.absence.domain.entity.User;
import com.ensa.absence.repository.DepartementRepository;
import com.ensa.absence.repository.EtudiantRepository;
import com.ensa.absence.repository.FiliereRepository;
import com.ensa.absence.repository.GroupeRepository;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitializer implements CommandLineRunner {

	@Autowired
	private FiliereRepository filiereRepository;

	@Autowired
	private DepartementRepository departementRepository;

	@Autowired
	private GroupeRepository groupeRepository;

	@Autowired
	private EtudiantRepository etudiantRepository;

	@Override
	public void run(String... strings) throws Exception {
		filiereRepository.deleteAll();
		departementRepository.deleteAll();

		Departement dep1 = new Departement("GI", null);
		Departement dep2 = new Departement("GE", null);

		Filiere fil1 = new Filiere("Genie Logiciel", dep1);
		Filiere fil2 = new Filiere("Genie Electronique", dep2);

		filiereRepository.saveAll(Arrays.asList(fil1, fil2));

		Groupe gc1 = new GroupeCours(fil1, Calendar.getInstance());
		Groupe gtd1 = new GroupeTD(fil1, Calendar.getInstance(), 1);
		Groupe gtd2 = new GroupeTD(fil1, Calendar.getInstance(), 2);
		Groupe gtp1 = new GroupeTP(fil1, Calendar.getInstance(), 1);
		Groupe gtp2 = new GroupeTP(fil1, Calendar.getInstance(), 2);

		List<Groupe> groupes = Arrays.asList(gc1, gtd1, gtd2, gtp1, gtp2);
		
		for (int i = 0; i < 14; i++) {
			User user = new User(generateRandString(), generateRandString());
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
		System.out.println(" -- Database has been initialized");
	}

	private String generateRandString() {

		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 6;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		return buffer.toString();
	}

}