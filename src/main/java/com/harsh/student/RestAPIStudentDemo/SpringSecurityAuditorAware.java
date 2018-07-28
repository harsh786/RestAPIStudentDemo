package com.harsh.student.RestAPIStudentDemo;

import org.springframework.data.domain.AuditorAware;

class SpringSecurityAuditorAware implements AuditorAware<String> {

	  public String getCurrentAuditor() {

		  return "HARSH_USER";
		  
	  /*  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	    if (authentication == null || !authentication.isAuthenticated()) {
	      return null;
	    }

	    return ((MyUserDetails) authentication.getPrincipal()).getUser();*/
	  }
	}