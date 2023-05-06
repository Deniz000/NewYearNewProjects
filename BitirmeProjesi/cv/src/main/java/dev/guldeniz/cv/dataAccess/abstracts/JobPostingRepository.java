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

    //jpql : her zaman ana tablodan gidilir.
    //productName=:parametre
    //from la başlarsan tüm alanları çek demek
    
    @Query("FROM JobPosting j INNER JOIN j.employer e WHERE j.isActive=true AND e.companyName=:companyName")
    List<JobPosting> findAllByIsActiveAndCompanyName(String companyName);
    
    //@Query("Select new dev.guldeniz.cv.entities.dtos.JobPostingWithEmployerDto(j.id, j.jobDescription, e.companyName) From Employer e Inner Join e.jobPostings j")
    
//    @Query("SELECT e.companyName, js.positionName FROM JobPosting j " +
//            "INNER JOIN j.employer e " +
//            "INNER JOIN j.jobPosition js")
    
    @Query("SELECT new dev.guldeniz.cv.entities.dtos.JobPostingWithEmployerDto(j.id, e.companyName, js.positionName) " +
            "FROM JobPosting j " +
            "INNER JOIN j.employer e " +
            "INNER JOIN j.jobPosition js")
    List<JobPosting> getJobPostingWithEmployerDetail();
    
}
