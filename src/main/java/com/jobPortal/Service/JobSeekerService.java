package com.jobPortal.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobPortal.DTO.JobSeekerDTO;
import com.jobPortal.Entity.JobSeeker;
import com.jobPortal.Repository.JobSeekerRepository;

@Service
public class JobSeekerService {
	
	
	@Autowired
	private JobSeekerRepository jobSeekerRepository;
	
	
	
	public JobSeekerDTO createOrUpdate(JobSeekerDTO dto) {
		
		JobSeeker jobSeek = new JobSeeker();
		
		jobSeek.setId(dto.id);
		jobSeek.setName(dto.name);
		jobSeek.setEmail(dto.email);
		jobSeek.setPhone(dto.phone);
		jobSeek.setUniversityName(dto.universityName);
		jobSeek.setCourse(dto.course);
		jobSeek.setPassingYear(dto.passingYear);
		jobSeek.setResumeURL(dto.resumeURL);
		
		JobSeeker saved= jobSeekerRepository.save(jobSeek);
		
		
		return dto;
		
	}
	
	
	public JobSeekerDTO getJobSeekerByEmail(String email) {
		
		Optional<JobSeeker> jobSeeker =jobSeekerRepository.findByEmail(email);
		
		return jobSeeker.map(jobSeek->{
			                          
			JobSeekerDTO dto = new JobSeekerDTO();
			
			dto.setId(jobSeek.getId());
			dto.setName(jobSeek.getName());
			dto.setEmail(jobSeek.getEmail());
			dto.setPhone(jobSeek.getPhone());
			dto.setUniversityName(jobSeek.getUniversityName());
			dto.setCourse(jobSeek.getCourse());
			dto.setPassingYear(jobSeek.getPassingYear());
			dto.setResumeURL(jobSeek.getResumeURL());
			
			return dto;
		}).orElse(null);
	}

}





