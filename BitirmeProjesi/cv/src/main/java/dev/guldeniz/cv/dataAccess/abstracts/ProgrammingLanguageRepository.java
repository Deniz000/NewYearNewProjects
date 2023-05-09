package dev.guldeniz.cv.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.guldeniz.cv.entities.concretes.jobSeeker.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer>{

}
