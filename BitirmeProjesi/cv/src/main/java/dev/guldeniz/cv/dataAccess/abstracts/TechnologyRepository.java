package dev.guldeniz.cv.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.guldeniz.cv.entities.concretes.jobSeeker.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer>{

}
