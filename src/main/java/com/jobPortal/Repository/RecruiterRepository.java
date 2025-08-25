package com.jobPortal.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobPortal.Entity.Recruiter;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter,Long> {
	
	 Optional<Recruiter>findByEmail(String recruiterEmail);
	 Optional<Recruiter>findByCompanyName(String companyName);

}

