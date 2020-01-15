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
	@Override
	public Optional<Long> getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || !authentication.isAuthenticated()
				|| authentication instanceof AnonymousAuthenticationToken) {
			return Optional.empty();
		}

		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		return Optional.ofNullable(userPrincipal.getId());
	}
}