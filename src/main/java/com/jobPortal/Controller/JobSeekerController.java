package com.jobPortal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobPortal.DTO.JobSeekerDTO;
import com.jobPortal.Service.JobSeekerService;

@RestController
@RequestMapping("/api/jobSeekers")
public class JobSeekerController {
	
	
	@Autowired
	private JobSeekerService jobSeekerService;
	
	
	@PostMapping
	
	public ResponseEntity<JobSeekerDTO>saveJobSeeker(@RequestBody JobSeekerDTO dto){
		
		return ResponseEntity.ok(jobSeekerService.createOrUpdate(dto));
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<JobSeekerDTO> getJobSeekerByEmail(@PathVariable String email){
		return ResponseEntity.ok(jobSeekerService.getJobSeekerByEmail(email));
	}

}
