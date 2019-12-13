package com.ensa.absence.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensa.absence.domain.entity.GroupeCours;
import com.ensa.absence.repository.GroupeCoursRepository;
import com.ensa.absence.service.GroupeCoursService;

@Service
public class GroupeCoursServiceImpl implements GroupeCoursService {
	
	@Autowired
	private GroupeCoursRepository groupeCoursRepository;
	
	@Override
	public GroupeCours saveGroupeCours(GroupeCours groupeCours) {
		return groupeCoursRepository.save(groupeCours);
		
	}

	@Override
	public Optional<GroupeCours> getGroupeCoursById(Long id) {
		return groupeCoursRepository.findById(id);
	}

	@Override
	public GroupeCours archiverGroupeCours(GroupeCours groupeCours) {
		// TODO Auto-generated method stub
		return null;
	}


}
