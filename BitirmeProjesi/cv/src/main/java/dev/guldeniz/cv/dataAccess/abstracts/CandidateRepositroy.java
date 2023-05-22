package dev.guldeniz.cv.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.guldeniz.cv.entities.concretes.jobSeeker.Candidate;

public interface CandidateRepositroy extends JpaRepository<Candidate, Integer>{

}
