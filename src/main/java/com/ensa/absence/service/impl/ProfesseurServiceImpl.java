package com.ensa.absence.service.impl;

import com.ensa.absence.domain.entity.Professeur;
import com.ensa.absence.domain.entity.User;
import com.ensa.absence.domain.enums.RoleName;
import com.ensa.absence.exception.ExcelFileCellNotKnown;
import com.ensa.absence.exception.ProfesseursExcelFileHasWrogFormat;
import com.ensa.absence.payload.CreateProfesseurRequest;
import com.ensa.absence.payload.ProfesseurResponse;
import com.ensa.absence.repository.ProfesseurRepository;
import com.ensa.absence.repository.RoleRepository;
import com.ensa.absence.repository.UserRepository;
import com.ensa.absence.service.ProfesseurService;
import com.ensa.absence.service.UserService;
import com.ensa.absence.utils.ModelMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {

	@Autowired
	private ProfesseurRepository professeurRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserService userService;

	@Override
	public Professeur saveProfesseur(Professeur professeur) {
		return professeurRepository.save(professeur);
	}


	@Override
	public Optional<Professeur> getProfesseurById(Long id) {
		return professeurRepository.findById(id);
	}


	@Override
	public Professeur archiverProfesseur(Professeur professeur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void ajouterListProfesseursExcel(MultipartFile excelDataFile) throws ExcelFileCellNotKnown, ProfesseursExcelFileHasWrogFormat {
		try {
			Workbook workbook = new XSSFWorkbook(excelDataFile.getInputStream());
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = datatypeSheet.iterator();
			while (rowIterator.hasNext()) {
				Row currentRow = rowIterator.next();
				if(currentRow.getRowNum() == 0){
					if(!isFileHasRightFormat(currentRow)) throw new ProfesseursExcelFileHasWrogFormat();
					continue;
				}
				Iterator<Cell> cellIterator = currentRow.iterator();
				User user = new User();
				Professeur professeur = new Professeur();
				boolean saveCurrentProfesseur = true; // If an professeur is duplicated, set to false and end loop to skip
				while (cellIterator.hasNext()) {
					Cell currentCell = cellIterator.next();
					switch (currentCell.getColumnIndex()){
						case 0:
							String cin = String.valueOf((long)currentCell.getNumericCellValue());
							if(userRepository.existsByUsername(cin)){
								saveCurrentProfesseur = false;
								break;
							}
							user.setUsername(cin);
							break;
						case 1:
							String code = String.valueOf((long)currentCell.getNumericCellValue());
							user.setPassword(new BCryptPasswordEncoder().encode(code));
							break;
						case 2:
							professeur.setNom(currentCell.getStringCellValue());
							break;
						case 3:
							professeur.setPrenom(currentCell.getStringCellValue());
							break;
						default:
							throw new ExcelFileCellNotKnown();
					}

				}
				if(!saveCurrentProfesseur)
					continue; // Break from current row
				user.getRoles().add(roleRepository.findByName(RoleName.ROLE_PROFESSEUR));
				professeur.setUser(user);
				professeurRepository.save(professeur);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ProfesseurResponse> getProfesseursResponses() {
		return professeurRepository.findAll().stream().map(p -> ModelMapper.mapProfesseurToProfesseurResponse(p))
				.collect(Collectors.toList())
				;
	}

	@Override
	@Transactional
	public ProfesseurResponse saveProfesseur(CreateProfesseurRequest request) {
		User user = userService.createProfesseurUser(request.getCin(), request.getCode());
		Professeur professeur = new Professeur(request.getNom(), request.getPrenom(), user);
		professeurRepository.save(professeur);
		return ModelMapper.mapProfesseurToProfesseurResponse(professeur);
	}

	private boolean isFileHasRightFormat(Row currentRow) {
		Iterator<Cell> cellIterator = currentRow.iterator();
		while (cellIterator.hasNext()) {
			Cell currentCell = cellIterator.next();
			switch (currentCell.getColumnIndex()) {
				case 0:
					if (!currentCell.getStringCellValue().equalsIgnoreCase("CIN"))
						return false;
					break;
				case 1:
					if(!currentCell.getStringCellValue().equalsIgnoreCase("CODE"))
						return false;
					break;
				case 2:
					if(!currentCell.getStringCellValue().equalsIgnoreCase("NOM"))
						return false;
					break;
				case 3:
					if(!currentCell.getStringCellValue().equalsIgnoreCase("PRENOM"))
						return false;
					break;
				default:
					return false;
			}
		}
		return true;
	}

}
