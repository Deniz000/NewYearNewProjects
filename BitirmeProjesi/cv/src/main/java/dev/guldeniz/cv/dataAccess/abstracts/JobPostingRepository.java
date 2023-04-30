package dev.guldeniz.cv.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.guldeniz.cv.entities.concretes.JobPosting;

public interface JobPostingRepository extends JpaRepository<JobPosting, Integer>{

   // @Query("FROM JobPosting jp WHERE jp.active =true")
    @Query("FROM JobPosting jp WHERE jp.active=true")
    List<JobPosting> findAllActiveJobPostings();
}
