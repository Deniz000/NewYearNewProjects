package dev.guldeniz.cv.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.guldeniz.cv.entities.concretes.JobPosting;

public interface JobPostingRepository extends JpaRepository<JobPosting, Integer>{

   // @Query("FROM JobPosting jp WHERE jp.active =true")
   // @Query("FROM JobPosting jp WHERE jp.active=true")
    List<JobPosting> findAllByIsActiveTrue();
    List<JobPosting> findAllByIsActiveTrueOrderByPublishDateAsc();
    List<JobPosting> findAllByIsActiveTrueOrderByPublishDateDesc();

    @Query("FROM JobPosting j INNER JOIN j.employer e WHERE j.isActive=true AND e.companyName=:companyName")
    List<JobPosting> findAllByIsActiveAndCompanyName(String companyName);

    
}
