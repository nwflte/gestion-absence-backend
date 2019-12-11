package com.ensa.absence.service;

import java.util.Optional;

import com.ensa.absence.domain.entity.GroupeCours;

public interface GroupeCoursService {

	GroupeCours saveGroupeCours(GroupeCours groupeCours);
	Optional<GroupeCours> getGroupeCoursById(Long id);
	GroupeCours archiverGroupeCours(GroupeCours groupeCours);
}
