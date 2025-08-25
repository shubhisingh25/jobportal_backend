package com.jobPortal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobPortal.DTO.RecruiterDTO;
import com.jobPortal.Entity.Recruiter;
import com.jobPortal.Repository.RecruiterRepository;

@Service
public class RecruiterService {
	
	@Autowired
	private RecruiterRepository recruiterRepository;
	
	
	
	public Recruiter createOrRecruiterProfile(String recruiterEmail,RecruiterDTO dto) {
		
		Recruiter recruiter = recruiterRepository.findByEmail(recruiterEmail).orElse(new Recruiter());
		
		recruiter.setRecruiterEmail(dto.getRecruiterEmail());
		recruiter.setRecruiterPhone(dto.getRecruiterPhone());
		recruiter.setCompanyName(dto.getCompanyName());
		recruiter.setCompanyWebsite(dto.getCompanyWebsite());
		
		
		return recruiterRepository.save(recruiter);
	}
	
	public Recruiter getRecruiterByCompanyName(String companyName) {
		return recruiterRepository.findByCompanyName(companyName).orElseThrow(()->new RuntimeException("Recruiter not found"));
	}

}