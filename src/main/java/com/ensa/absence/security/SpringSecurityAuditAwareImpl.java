package com.ensa.absence.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ensa.absence.domain.entity.ResponsableScolarite;
import com.ensa.absence.domain.entity.User;
import com.ensa.absence.repository.ProfesseurRepository;
import com.ensa.absence.repository.ResponsableScolariteRepository;
import com.ensa.absence.repository.UserRepository;

public class SpringSecurityAuditAwareImpl implements AuditorAware<Long> {

	@Autowired
	private ResponsableScolariteRepository responsableRepository;
	
	@Autowired
	private ProfesseurRepository professeurRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<Long> getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || !authentication.isAuthenticated()
				|| authentication instanceof AnonymousAuthenticationToken) {
			return Optional.empty();
		}

		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		
		User user = userRepository.findById(userPrincipal.getId()).get();
		Optional<ResponsableScolarite> responsable = responsableRepository.findByUser_Id(userPrincipal.getId());
		if(responsable.isPresent())
			return Optional.ofNullable(responsable.get().getId());
		
		return Optional.ofNullable(professeurRepository.findByUser_Id(userPrincipal.getId()).get().getId());		
	}
}