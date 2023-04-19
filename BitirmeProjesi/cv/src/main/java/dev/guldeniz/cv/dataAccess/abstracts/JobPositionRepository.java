package dev.guldeniz.cv.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.guldeniz.cv.entities.concretes.JobPosition;

public interface JobPositionRepository extends JpaRepository<JobPosition, Integer>{

}
