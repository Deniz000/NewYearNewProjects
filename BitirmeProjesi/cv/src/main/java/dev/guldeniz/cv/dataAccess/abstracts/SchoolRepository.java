package dev.guldeniz.cv.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.guldeniz.cv.entities.concretes.jobSeeker.School;

public interface SchoolRepository extends JpaRepository<School, Integer>{

}
