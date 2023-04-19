package dev.guldeniz.cv.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.guldeniz.cv.entities.concretes.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Integer>{

	boolean existsByEMail(String email);

}
