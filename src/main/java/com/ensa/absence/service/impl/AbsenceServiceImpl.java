package com.ensa.absence.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.absence.payload.AbsenceResponse;
import com.ensa.absence.repository.AbsenceRepository;
import com.ensa.absence.service.AbsenceService;
import com.ensa.absence.utils.ModelMapper;

@Service
public class AbsenceServiceImpl implements AbsenceService {

	@Autowired
	private AbsenceRepository absenceRepository;

	@Override
	public List<AbsenceResponse> getAbsencesOfSeance(Long seanceId) {
		return absenceRepository.findBySeance_Id(seanceId).stream().map(a -> ModelMapper.mapAbsenceToAbsenceResponse(a))
				.collect(Collectors.toList());
	}

}
