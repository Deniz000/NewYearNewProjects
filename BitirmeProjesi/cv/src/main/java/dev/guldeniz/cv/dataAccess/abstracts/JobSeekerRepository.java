package dev.guldeniz.cv.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.guldeniz.cv.entities.concretes.jobSeeker.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer>{

	boolean existsByEMail(String email);
	boolean existsByNationalIdentity(String id);

}
