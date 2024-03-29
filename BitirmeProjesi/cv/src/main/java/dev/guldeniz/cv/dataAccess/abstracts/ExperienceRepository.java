package dev.guldeniz.cv.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.guldeniz.cv.entities.concretes.jobSeeker.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Integer>{

}
