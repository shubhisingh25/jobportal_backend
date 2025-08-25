package com.jobPortal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobPortal.Entity.JobPost;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost,Long> {
	
	List<JobPost>findByRecruiterEmail(String recruiterEmail);
	List<JobPost>findByJobTitle(String jobTitle);
	List<JobPost>findByCompanyName(String comapanyName);
	

}
