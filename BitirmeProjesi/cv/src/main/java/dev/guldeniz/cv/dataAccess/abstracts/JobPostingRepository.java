package dev.guldeniz.cv.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.guldeniz.cv.entities.concretes.JobPosting;

public interface JobPostingRepository extends JpaRepository<JobPosting, Integer>{

}
